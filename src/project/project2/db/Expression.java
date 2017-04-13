package project.project2.db;

/**
 * Created by 51694 on 2017/4/11.
 */


public class Expression
{
    String basicCol;
    Operand[] operands;
    String asName;
    String type;
    Table sourceTable;

    public Expression(String[] expressions, Table t)
    {
        if (expressions.length == 1)
        {
            sourceTable = t;
            basicCol = expressions[0];
            operands = null;
            asName = null;
            type = "single";
        }
        else if (expressions.length == 3)
        {
            sourceTable = t;
            String op = "[+*/-]";
            operands = new Operand[expressions[0].split(op).length];
            basicCol = expressions[0].split("[+*/-]")[0];

            for (int i = 1; i < operands.length; i += 1)
            {
                int operatorIndex = expressions[0].indexOf(expressions[0].split(op)[i]) - 1;
                String operator = expressions[0].substring(operatorIndex, operatorIndex + 1);
                if (sourceTable.nameColMap.containsKey(expressions[0].split(op)[i]))
                {
                    operands[i] = new ColOperand(operator, sourceTable.nameColMap.get(expressions[0].split(op)[i]));
                }
                else
                {
                    operands[i] = new SimpleOperand(operator, expressions[0].split(op)[i]);
                }
            }
            asName = expressions[2];
            type = "complex";
        }
        else
        {
            throw new IllegalArgumentException("Wrong expression");
        }
    }

}
