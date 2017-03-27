package project.project2.db;

import javafx.scene.control.Tab;
import simpleTools.EasyString;

import java.util.HashMap;
import java.util.Map;

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

    public Table(String name, String[] colNames, String[] colTypes)
    {
        tableName = name;
        colNum = colNames.length;
        this.colNames = colNames;
        this.colTypes = colTypes;
        columns = new Column[colNum];
        createCols();
    }

    private void createCols()
    {
        for (int i = 0; i < colNum; i += 1)
        {
            if (colTypes[i].equals("int"))
            {
                Column<Integer> col = new Column<>(colNames[i], colTypes[i]);
                columns[i] = col;
            }
            else if (colTypes[i].equals("str"))
            {
                Column<String> col = new Column<>(colNames[i], colTypes[i]);
                columns[i] = col;
            }
            else if (colTypes[i].equals("float"))
            {
                Column<Float> col = new Column<>(colNames[i], colTypes[i]);
                columns[i] = col;
            }
            else
            {
                return;
            }
        }
    }

    public String getColNames()
    {
        return EasyString.pyStyleJoin(colNames, ' ');
    }
}
