package lectureCode.lecture17;

/**
 * Created by 51694 on 2017/3/27.
 */
public class QuickUnionDS implements DisjointSets
{
    int[] id;

    public QuickUnionDS(int N)
    {
        id = new int[N];
        for (int i = 0; i < N; i += 1)
        {
            id[i] = i;
        }
    }

    int findRoot(int p)
    {
        if (id[p] == p)
        {
            return p;
        }
        return findRoot(id[p]);
    }

    @Override
    public boolean isConnected(int p, int q)
    {
        return findRoot(p) == findRoot(q);
    }

    @Override
    public void connect(int p, int q)
    {
        int qRoot = findRoot(q);
        id[qRoot] = findRoot(p);
    }
}
