package lectureCode.lecture20;

/**
 * Created by 51694 on 2017/4/19.
 */
public class PrintAct<Label> implements Action<Label>
{

    @Override
    public void visit(Tree<Label> T)
    {
        System.out.print(T.item + " ");
    }
}
