package project.project2.db;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 51694 on 2017/3/28.
 */
public class Cursor
{
    private int rowPosition;
    private Table belongTable;
    private Set<Integer> rowNumbers;

    public Cursor(Table t)
    {
        rowNumbers = new HashSet<>();
        rowPosition = 0;
        belongTable = t;
    }

    public int selectRowsNumber()
    {
        return rowNumbers.size();
    }

    public int getRowPosition()
    {
        return rowPosition;
    }

    public void addSelectRow(int index)
    {
        rowNumbers.add(index);
    }

    public void setSelectRow(int index)
    {
        rowNumbers.clear();
        rowNumbers.add(index);
    }

    public void clearSelectRow()
    {
        rowNumbers.clear();
    }

    public void setRange(int startIndex, int endIndex)
    {
        for (int i = startIndex; i <= endIndex; i += 1)
        {
            rowNumbers.add(i);
        }
    }

    public Set<Integer> getRowNumbers()
    {
        return rowNumbers;
    }

    public void setRowPosition(int rowPosition)
    {
        this.rowPosition = rowPosition;
    }

    public List<Object> rowInfo(String[] colNames)
    {
        List<Object> row = new ArrayList<>();
        for (String colName: colNames)
        {
            row.add(belongTable.getColbyName(colName).getCursorItem(rowPosition));
        }
        return row;
    }
}
