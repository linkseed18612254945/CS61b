package lectureCode.lecture17;

/**
 * Created by 51694 on 2017/3/27.
 */
public class WeightedQuickUnionDS extends QuickUnionDS
{
    private int[] size;
    public WeightedQuickUnionDS(int N)
    {
        super(N);
        size = new int[N];
        for (int i = 0; i < N; i += 1)
        {
            size[i] = 1;
        }
    }

    @Override
    public void connect(int p, int q)
    {
        int i = super.findRoot(p);
        int j = super.findRoot(q);
        if (i != j)
        {
            if (size[i] < size[j])
            {
                super.id[i] = j;
                size[j] += size[i];
            }
            else
            {
                super.id[j] = i;
                size[i] += size[j];
            }
        }

    }

}
