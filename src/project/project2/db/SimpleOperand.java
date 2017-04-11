package project.project2.db;

/**
 * Created by 51694 on 2017/4/11.
 */
public class SimpleOperand implements Operand
{
    String operator;
    String operand;

    public SimpleOperand(String operator, String operand)
    {
        this.operator = operator;
        this.operand = operand;
    }

    @Override
    public String getOperator()
    {
        return null;
    }
}
