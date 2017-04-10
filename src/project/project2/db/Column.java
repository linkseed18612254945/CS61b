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
    private int rowNumber;

    public Column(String colName, String colType)
    {
        items = new ArrayList<>();
        name = colName;
        type = colType;
        rowNumber = 0;
    }

    public Column(T item, String colName, String colType, int rowNumber)
    {
        name = colName;
        items = new ArrayList<>();
        type = colType;
        this.rowNumber = rowNumber;
        for (int i = 0; i < rowNumber; i += 1)
        {
            items.add(item);
        }
    }

    public List<T> getItems()
    {
        return items;
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public int getRowNumber()
    {
        return rowNumber;
    }

    public Column getCursorColumn(Cursor cursor)
    {
        Column<T> newCol = new Column<>(name, type);
        for (Integer index: cursor.getRowNumbers())
        {
            newCol.insert(items.get(index));
        }
        return  newCol;
    }

    public T getCursorItem(int rowPosition)
    {
        return items.get(rowPosition);
    }
    public void insert(T value)
    {
        items.add(value);
        rowNumber += 1;
    }

    public void insert(String value)
    {
        value = value.trim();
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
            rowNumber += 1;
        }
        catch (ClassCastException e)
        {
            System.out.println("Wrong insert data type");
            throw e;
        }
    }
}
