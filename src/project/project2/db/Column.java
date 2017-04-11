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

    public Column(List<T> items, String colName, String colType)
    {
        this.items = items;
        name = colName;
        type = colType;
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

    private T operateCalculate (T basic , String operator, T operand)
    {
        if (operator.equals("+"))
        {
            if (basic instanceof String)
            {
                String tempBasic = (String) basic;
                String tempOperand = (String) operand;
                return (T) (tempBasic + tempOperand);
            }
            else if (basic instanceof Integer)
            {
                Integer tempBasic = (Integer) basic;
                Integer tempOperand = (Integer) operand;
                return (T) (Integer) (tempBasic + tempOperand);
            }
            else if (basic instanceof Double)
            {
                Double tempBasic = (Double) basic;
                Double tempOperand = (Double) operand;
                return (T) (Double)(tempBasic + tempOperand);
            }
        }
        else if (operator.equals("*"))
        {
            if (basic instanceof String)
            {
                throw new IllegalArgumentException("String don't have the operate method");
            }
            else if (basic instanceof Integer)
            {
                Integer tempBasic = (Integer) basic;
                Integer tempOperand = (Integer) operand;
                return (T) (Integer) (tempBasic * tempOperand);
            }
            else if (basic instanceof Double)
            {
                Double tempBasic = (Double) basic;
                Double tempOperand = (Double) operand;
                return (T) (Double)(tempBasic * tempOperand);
            }
        }
        else if (operator.equals("-"))
        {
            if (basic instanceof String)
            {
                throw new IllegalArgumentException("String don't have the operate method");
            }
            else if (basic instanceof Integer)
            {
                Integer tempBasic = (Integer) basic;
                Integer tempOperand = (Integer) operand;
                return (T) (Integer) (tempBasic - tempOperand);
            }
            else if (basic instanceof Double)
            {
                Double tempBasic = (Double) basic;
                Double tempOperand = (Double) operand;
                return (T) (Double)(tempBasic - tempOperand);
            }
        }
        else if (operator.equals("/"))
        {
            if (basic instanceof String)
            {
                throw new IllegalArgumentException("String don't have the operate method");
            }
            else if (basic instanceof Integer)
            {
                Integer tempBasic = (Integer) basic;
                Integer tempOperand = (Integer) operand;
                return (T) (Integer) (tempBasic / tempOperand);
            }
            else if (basic instanceof Double)
            {
                Double tempBasic = (Double) basic;
                Double tempOperand = (Double) operand;
                return (T) (Double)(tempBasic / tempOperand);
            }
        }
        else
        {
            throw new IllegalArgumentException("Illegal operator");
        }
        return null;
    }

    private T getValue(String operand)
    {
        if (type.equals("string"))
        {
            return (T) operand;
        }
        else if (type.equals("integer"))
        {
            return (T) (Integer) Integer.parseInt(operand);
        }
        else if (type.equals("double"))
        {
            return (T) (Double) Double.parseDouble(operand);
        }
        else
        {
            throw new IllegalArgumentException("Wrong col type");
        }
    }


    public Column<T> operate(Operand[] operands, String asName)
    {
        List<T> newItems = new ArrayList<>();
        for (int i = 0; i < items.size(); i += 1)
        {
            T newRowItem = items.get(i);
            T operandValue;
            for (int j = 1; j < operands.length; j += 1)
            {
                Operand op = operands[j];
                if (op instanceof SimpleOperand)
                {
                    operandValue = getValue(((SimpleOperand) op).operand);
                }
                else if (op instanceof ColOperand)
                {
                    operandValue = (T) ((ColOperand) op).operand.items.get(i);
                }
                else
                {
                    throw new IllegalArgumentException("Wrong operand type");
                }
                newRowItem = operateCalculate(newRowItem, op.getOperator(), operandValue);
            }
            newItems.add(i, newRowItem);
        }
        return new Column<>(newItems, asName, type);
    }
}
