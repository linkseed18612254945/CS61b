package lectureCode.lecture17;

/**
 * Created by 51694 on 2017/3/27.
 */
public class QuickFindDS implements DisjointSets
{
    private int[] id;

    public QuickFindDS(int N)
    {
        id  = new int[N];
        for (int i = 0; i < N; i += 1)
        {
            id[i] = i;
        }
    }

    @Override
    public boolean isConnected(int p, int q)
    {
        return id[p] == id[q];
    }

    @Override
    public void connect(int p, int q)
    {
        int pId = id[p];
        int qId = id[q];
        if (pId != qId)
        {
            for (int i = 0; i < id.length; i += 1)
            {
                if (id[i] == pId)
                {
                    id[i] = qId;
                }
            }
        }
    }
}
