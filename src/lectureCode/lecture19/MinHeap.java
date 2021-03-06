package lectureCode.lecture19;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by 51694 on 2017/4/18.
 */
public class MinHeap<Item extends Comparable<Item>> implements MinPQ<Item>
{
    private ArrayList<Item> keys;

    MinHeap(){}

    private void swap(int i, int j)
    {
        Item temp = keys.get(i);
        keys.set(i, keys.get(j));
        keys.set(j, temp);
    }

    private int parent(int child)
    {
        return child / 2;
    }

    private int lChild(int parent)
    {
        return parent * 2 ;
    }

    private int rChild(int parent)
    {
        return parent * 2 + 1;
    }

    @Override
    public void add(Item x)
    {
    }

    @Override
    public Item getSmallest()
    {
        return keys.get(0);
    }

    @Override
    public Item removeSmallest()
    {
        return null;
    }

    @Override
    public int size()
    {
        return keys.size();
    }
}
