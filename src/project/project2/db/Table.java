package project.project2.db;



import simpleTools.EasyString;

import java.util.*;

import static simpleTools.EasyString.*;

/**
 * Created by 51694 on 2017/3/27.
 */
public class Table
{
    //private final int columnNum;
    private int rowNum, colNum;
    private String tableName;
    public String[] colNames;
    private String[] colTypes;
    private Column[] columns;
    private Cursor cursor;
    public Map<String, Column> nameColMap = new HashMap<>();
    private Map<String, String> nameTypeMap = new HashMap<>();

    public Table(String name, String[] colNames, String[] colTypes)
    {
        tableName = name;
        colNum = colNames.length;
        rowNum = 0;
        this.colNames = colNames;
        this.colTypes = colTypes;
        columns = new Column[colNum];
        cursor = new Cursor(this);
        createCols();
    }

    public Table(String name, Column[] cols)
    {
        tableName = name;
        colNum = cols.length;
        rowNum = cols[0].getRowNumber();
        colNames = new String[cols.length];
        colTypes = new String[cols.length];
        cursor = new Cursor(this);
        for (int i = 0; i < cols.length; i += 1)
        {
            nameColMap.put(cols[i].getName(), cols[i]);
            nameTypeMap.put(cols[i].getName(), cols[i].getType());
            colNames[i] = cols[i].getName();
            colTypes[i] = cols[i].getType();
        }
        columns = cols;
    }

    public Column getColbyName(String colName)
    {
        return nameColMap.get(colName);
    }

    private void createCols()
    {
        for (int i = 0; i < colNum; i += 1)
        {
            if (colTypes[i].equals("int"))
            {
                Column<Integer> col = new Column<>(colNames[i], colTypes[i]);
                columns[i] = col;
                nameColMap.put(colNames[i], col);
                nameTypeMap.put(colNames[i], colTypes[i]);
            }
            else if (colTypes[i].equals("string"))
            {
                Column<String> col = new Column<>(colNames[i], colTypes[i]);
                columns[i] = col;
                nameColMap.put(colNames[i], col);
                nameTypeMap.put(colNames[i], colTypes[i]);
            }
            else if (colTypes[i].equals("float"))
            {
                Column<Float> col = new Column<>(colNames[i], colTypes[i]);
                columns[i] = col;
                nameColMap.put(colNames[i], col);
                nameTypeMap.put(colNames[i], colTypes[i]);
            }
            else
            {
                return;
            }
        }
    }

    public String getTableName()
    {
        return tableName;
    }

    public void insertRow(String[] values)
    {
        if (values.length != colNum)
        {
            throw new ArrayIndexOutOfBoundsException("Insert with wrong column number.");
        }
        for (int i = 0; i < colNum; i += 1)
        {
            columns[i].insert(values[i]);
        }
        rowNum += 1;
    }

    public void insertFromTable(Table t)
    {
        if (!Arrays.equals(colNames, t.colNames))
        {
            throw new IllegalArgumentException("Table tStack need same column");
        }
        for (int i = 0; i < t.rowNum; i += 1)
        {
            for (int j = 0; j < colNum; j += 1)
            {
                columns[j].insert(t.columns[j].getCursorItem(i));
            }
            rowNum += 1;
        }
    }


    private String[] sameCol(Table t)
    {
        return hashIntersect(this.colNames, t.colNames);
    }

    private Table getCursorPointTable(Cursor cursor)
    {
        Column[] cursorCol = new Column[colNum];
        for (int i = 0; i < colNum; i += 1)
        {
            cursorCol[i] = columns[i].getCursorColumn(cursor);
        }
        return new Table("tempTable", cursorCol);
    }

    /** helper method for join */
    private Table oneLineJoin(Table t, String[] joinColNames)
    {
        if (rowNum != 1)
        {
            throw new IllegalArgumentException("Table should be one row");
        }
        int rowN = t.getRowNum();
        Column[] newCols = new Column[t.colNum + joinColNames.length];
        System.arraycopy(t.columns, 0, newCols, 0, t.colNum);
        for (int i = 0; i < joinColNames.length; i += 1)
        {
            Column joinCol = new Column<>(getColbyName(joinColNames[i]).getCursorItem(0),joinColNames[i], nameTypeMap.get(joinColNames[i]), rowN);
            newCols[t.colNum + i] = joinCol;
        }
        return new Table("join", newCols);
    }

    private Table join(Table t)
    {
        Table joinTable = null;
        int tempNum = 0;
        String[] sameColNames = sameCol(t);
        if (sameColNames == null)
        {
            return null;
        }
        for (int i = 0; i < rowNum; i += 1)
        {
            cursor.setRowPosition(i);
            cursor.setSelectRow(i);
            List<Object> sourceRowSameColItems = cursor.rowInfo(sameColNames);
            for (int j = 0; j < t.rowNum; j += 1)
            {
                t.cursor.setRowPosition(j);
                List<Object> targetRowSameColItems = t.cursor.rowInfo(sameColNames);
                if(sourceRowSameColItems.equals(targetRowSameColItems))
                {
                    t.cursor.addSelectRow(j);
                }
            }
            if (t.cursor.selectRowsNumber() != 0)
            {
                String[] joinNames = EasyString.complement(colNames, sameColNames);
                Table tempOneLineJoinTable = getCursorPointTable(cursor).oneLineJoin(t.getCursorPointTable(t.cursor), joinNames);
                if (tempNum == 0)
                {
                    joinTable = tempOneLineJoinTable;
                }
                else
                {
                    joinTable.insertFromTable(tempOneLineJoinTable);
                }
                tempNum += 1;
                t.cursor.clearSelectRow();
            }
        }
        return joinTable;
    }


    /** Choose some rows by "where condition" */
    private Table conditionChoose(Condition c)
    {
        if (c == null)
        {
            return this;
        }
        if (c.type.equals("unary"))
        {
            for (int i = 0; i < rowNum; i += 1)
            {
                if (c.compare(nameColMap.get(c.columnName).getCursorItem(i)))
                {
                    cursor.addSelectRow(i);
                }
            }
        }
        else
        {
            for (int i = 0; i < rowNum; i += 1)
            {
                if (c.compare(nameColMap.get(c.columnName).getCursorItem(i), nameColMap.get(c.literal).getCursorItem(i)))
                {
                    cursor.addSelectRow(i);
                }
            }
        }
        return getCursorPointTable(cursor);
    }

    private Table selectedTable(String tableName, String[] expressions)
    {
        Expression[] exps = new Expression[expressions.length];
        for (int i = 0; i < expressions.length; i += 1)
        {
            exps[i] = new Expression(expressions[i].split(" "), this);
        }
        Column[] selectedCol = new Column[expressions.length];
        for (int i = 0; i < exps.length; i += 1)
        {
            if (exps[i].type.equals("single"))
            {
                selectedCol[i] = nameColMap.get(exps[i].basicCol);
            }
            else
            {
                selectedCol[i] = nameColMap.get(exps[i].basicCol).operate(exps[i].operands, exps[i].asName);
            }

        }
        return new Table(tableName, selectedCol);
    }

    public Table select(String tableName, String[] expressions, Table[] joinTables, Condition cond)
    {
        Table selectT;
        if (joinTables == null)
        {
            selectT = conditionChoose(cond).selectedTable(tableName, expressions);
        }
        else
        {
            Table joinTable = this;
            for (Table t: joinTables)
            {
                joinTable = joinTable.join(t);
            }
            selectT = joinTable.conditionChoose(cond).selectedTable(tableName, expressions);
        }
        return selectT;
    }

    public String getColNames()
    {
        return pyStyleJoin(colNames, ' ', colTypes, ',');
    }


    public int getRowNum()
    {
        return rowNum;
    }

    public String toString()
    {
        String tableString = "";
        tableString += getColNames() + "\n";
        for (int i = 0; i < rowNum; i += 1)
        {
            for (int j = 0; j < colNum; j += 1)
            {
                if (j == colNum - 1)
                {
                    tableString += columns[j].getItems().get(i);
                    break;
                }
                tableString += columns[j].getItems().get(i) + ",";
            }

            tableString = tableString + "\n";
        }
        return tableString;
    }
}
