package project.project2.db;

import simpleTools.EasyString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 51694 on 2017/3/27.
 */
public class Column<T>
{
    private String name;
    private String type;
    private List<T> items;

    public Column(String colName, String colType)
    {
        items = new ArrayList<>();
        name = colName;
        type = colType;
    }

    public void insert(String value)
    {
        try
        {
            if (type.equals("int"))
            {
                T valueWithRightType = (T) Integer.valueOf(value);
                items.add(valueWithRightType);
            }
            else if(type.equals("float"))
            {
                T valueWithRightType = (T) Double.valueOf(value);
                items.add(valueWithRightType);
            }
            else
            {
                items.add((T) value);
            }
        }
        catch (ClassCastException e)
        {
            System.out.println("Wrong insert data type");
            throw e;
        }
    }
}
