package lectureCode.lecture20;

/**
 * Created by 51694 on 2017/4/19.
 */
public interface Action<Label>
{
    void visit(Tree<Label> T);
}
