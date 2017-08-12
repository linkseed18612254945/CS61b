package lectureCode.lecture21;

import java.util.List;

/**
 * Created by 51694 on 2017/4/24.
 */
public interface GraphPath
{
    void printPaths();
    Iterable<Integer> pathTo(int v);
    boolean hasPathTo(int v);
}
