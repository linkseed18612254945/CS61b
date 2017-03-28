package lectureCode.lecture17;

/**
 * Created by 51694 on 2017/3/27.
 */
public interface DisjointSets
{
    void connect(int p, int q);
    boolean isConnected(int p, int q);
}
