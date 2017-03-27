package project.project2.db;

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
}
