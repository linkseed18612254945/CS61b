package lectureCode.lecture19;

/**
 * Created by 51694 on 2017/4/18.
 */
public interface MinPQ<Item extends Comparable<Item>>
{
    /** adds the item to the priority queue */
    void add(Item x);

    /** Return the smallest item in the priority queue */
    Item getSmallest();

    /** Removes the smallest item */
    Item removeSmallest();

    int size();
}
