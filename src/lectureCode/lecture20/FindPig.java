package lectureCode.lecture20;

/**
 * Created by 51694 on 2017/4/19.
 */
public class FindPig implements Action<String>
{
    public boolean found = false;

    public boolean isFound()
    {
        return found;
    }

    @Override
    public void visit(Tree<String> T)
    {
        if ("pig".equals(T.item))
        {
            found = true;
        }
    }
}
