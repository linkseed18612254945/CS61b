package homework.hw01.synthesizer;

/**
 * Created by 51694 on 2017/3/22.
 */
abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;

    /* Return the capacity of queue */
    public int capacity()
    {
        return capacity;
    }

    /* Return the current number of queue */
    public int fillCount()
    {
        return fillCount;
    }
}
