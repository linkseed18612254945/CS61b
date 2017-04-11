package project.project2.db;


/**
 * Created by 51694 on 2017/4/10.
 */
public class Condition
{
    public String type;
    public String columnName;
    public String comparison;
    public String literal;

    public Condition(String columnName, String comparison, String literal, String type)
    {
        this.columnName = columnName;
        this.comparison = comparison;
        this.literal = literal;
        this.type = type;
    }


    public boolean compare(Object col0)
    {
        Object literalValue;
        if (col0 instanceof String)
        {
            literalValue = literal.split("'")[1];
        }
        else if (col0 instanceof Integer)
        {
            literalValue = Integer.valueOf(literal);
        }
        else
        {
            literalValue = Double.valueOf(literal);
        }

        boolean compareResult;
        switch (comparison)
        {
            case "==":
                compareResult = col0.equals(literalValue);
                break;
            case "!=":
                compareResult = !col0.equals(literalValue);
                break;
            case ">":
                if (col0 instanceof String)
                {
                    compareResult = ((String) col0).compareTo(literal) > 0;
                }
                else if (col0 instanceof Double)
                {
                    compareResult = (Double)col0 > (Double) literalValue;
                }
                else if (col0 instanceof Integer)
                {
                    compareResult = (Integer)col0 > (Integer) literalValue;
                }
                else
                {
                    throw new IllegalArgumentException("Wrong column type");
                }
                break;
            case ">=":
                if (col0 instanceof String)
                {
                    compareResult = ((String) col0).compareTo(literal) >= 0;
                }
                else if (col0 instanceof Double)
                {
                    compareResult = (Double)col0 >= (Double) literalValue;
                }
                else if (col0 instanceof Integer)
                {
                    compareResult = (Integer)col0 >= (Integer) literalValue;
                }
                else
                {
                    throw new IllegalArgumentException("Wrong column type");
                }
                break;
            case  "<":
                if (col0 instanceof String)
                {
                    compareResult = ((String) col0).compareTo(literal) < 0;
                }
                else if (col0 instanceof Double)
                {
                    compareResult = (Double)col0 < (Double) literalValue;
                }
                else if (col0 instanceof Integer)
                {
                    compareResult = (Integer)col0 < (Integer) literalValue;
                }
                else
                {
                    throw new IllegalArgumentException("Wrong column type");
                }
                break;
            case "<=":
                if (col0 instanceof String)
                {
                    compareResult = ((String) col0).compareTo(literal) <= 0;
                }
                else if (col0 instanceof Double)
                {
                    compareResult = (Double)col0 <= (Double) literalValue;
                }
                else if (col0 instanceof Integer)
                {
                    compareResult = (Integer)col0 <= (Integer) literalValue;
                }
                else
                {
                    throw new IllegalArgumentException("Wrong column type");
                }
                break;
            default:
                throw new IllegalArgumentException("Illegal comparison");
        }
        return compareResult;
    }

    public boolean compare(Object col0, Object col1)
    {
        boolean compareResult;
        switch (comparison)
        {
            case "==":
                compareResult = col0.equals(col1);
                break;
            case "!=":
                compareResult = !col0.equals(col1);
                break;
            case ">":
                if (col0 instanceof String)
                {
                    compareResult = ((String) col0).compareTo((String) col1) > 0;
                }
                else if (col0 instanceof Double)
                {
                    compareResult = (Double)col0 > (Double) col1;
                }
                else if (col0 instanceof Integer)
                {
                    compareResult = (Integer)col0 > (Integer) col1;
                }
                else
                {
                    throw new IllegalArgumentException("Wrong column type");
                }
                break;
            case ">=":
                if (col0 instanceof String)
                {
                    compareResult = ((String) col0).compareTo((String) col1) >= 0;
                }
                else if (col0 instanceof Double)
                {
                    compareResult = (Double)col0 >= (Double) col1;
                }
                else if (col0 instanceof Integer)
                {
                    compareResult = (Integer)col0 >= (Integer) col1;
                }
                else
                {
                    throw new IllegalArgumentException("Wrong column type");
                }
                break;
            case  "<":
                if (col0 instanceof String)
                {
                    compareResult = ((String) col0).compareTo((String) col1) < 0;
                }
                else if (col0 instanceof Double)
                {
                    compareResult = (Double)col0 < (Double) col1;
                }
                else if (col0 instanceof Integer)
                {
                    compareResult = (Integer)col0 < (Integer) col1;
                }
                else
                {
                    throw new IllegalArgumentException("Wrong column type");
                }
                break;
            case "<=":
                if (col0 instanceof String)
                {
                    compareResult = ((String) col0).compareTo((String) col1) <= 0;
                }
                else if (col0 instanceof Double)
                {
                    compareResult = (Double)col0 <= (Double) col1;
                }
                else if (col0 instanceof Integer)
                {
                    compareResult = (Integer)col0 <= (Integer) col1;
                }
                else
                {
                    throw new IllegalArgumentException("Wrong column type");
                }
                break;
            default:
                throw new IllegalArgumentException("Illegal comparison");
        }
        return compareResult;
    }
}
