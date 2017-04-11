package project.project2.db;

/**
 * Created by 51694 on 2017/4/11.
 */
public class ColOperand implements Operand
{
    String operator;
    Column operand;

    public ColOperand(String operator, Column operand)
    {
        this.operator = operator;
        this.operand = operand;
    }

    @Override
    public String getOperator()
    {
        return operator;
    }
}
