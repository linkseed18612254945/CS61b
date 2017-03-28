package lectureCode.lecture17;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 51694 on 2017/3/27.
 */
public class RegularDisjointSets<T>
{
    private Map<T, Integer> itemsMap = new HashMap<>();
    private DisjointSets disjointSets;

    public RegularDisjointSets(T[] items)
    {
        disjointSets = new WeightedQuickUnionDS(items.length);
        for (int i = 0; i < items.length; i += 1)
        {
            itemsMap.put(items[i], i);
        }
    }

    public boolean isConnected(T p, T q)
    {
        return disjointSets.isConnected(itemsMap.get(p), itemsMap.get(q));
    }

    public void connect(T p, T q)
    {
        disjointSets.connect(itemsMap.get(p), itemsMap.get(q));
    }
}
