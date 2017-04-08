package project.project2.db;



import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static simpleTools.EasyString.*;

/**
 * Created by 51694 on 2017/3/27.
 */
public class Table
{
    //private final int columnNum;
    private int rowNum, colNum;
    private String tableName;
    private String[] colNames;
    private String[] colTypes;
    private Column[] columns;
    private Cursor cursor;
    private Map<String, Column> nameColMap = new HashMap<>();

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
            }
            else if (colTypes[i].equals("string"))
            {
                Column<String> col = new Column<>(colNames[i], colTypes[i]);
                columns[i] = col;
                nameColMap.put(colNames[i], col);
            }
            else if (colTypes[i].equals("float"))
            {
                Column<Float> col = new Column<>(colNames[i], colTypes[i]);
                columns[i] = col;
                nameColMap.put(colNames[i], col);
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

    private String[] sameCol(Table t)
    {
        return hashintersect(this.colNames, t.colNames);
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

    private Table oneLineJoin(Table olTable, Table t, String[] joinColNames)
    {
        int rowN = t.getRowNum();
        Column[] newCols = new Column[t.colNum + joinColNames.length];
        System.arraycopy(t.columns, 0, newCols, 0, t.colNum);
        for (int i = 0; i < joinColNames.length; i += 1)
        {
            Column joinCol = new Column<>(olTable.getColbyName(joinColNames[i]).getCursorItem(0), rowN);
            newCols[t.colNum + i] = joinCol;
        }
        return new Table("join", newCols);
    }

    public Table join(Table t)
    {
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
                List<Object> targetRowSameColItems = cursor.rowInfo(sameColNames);
                if(sourceRowSameColItems.equals(targetRowSameColItems))
                {
                    cursor.addSelectRow(j);
                }
            }
            if (t.cursor.selectRowsNumber() != 0)
            {
                String[] joinNames = colNames.re
                Table tempOneLineJoinTable = oneLineJoin(getCursorPointTable(cursor), getCursorPointTable(t.cursor), joinNames);
            }
        }
    }

    public Table selectedTable()
    {
        Table newSelectTable = new Table()
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
