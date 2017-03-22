package homework.hw01.synthesizer;

/**
 * Created by 51694 on 2017/3/22.
 */
public interface BoundedQueue<T> {
    int capacity(); // return size of the buffer
    int fillCount(); // return number of items currently in the buffer
    void enqueue(T x); // add item x to the end of queue
    T dequeue(); // delete and return item from the front
    T peek(); // return (but not delete) item from the front
    void reset(T resetElement); // reset the queue with some element

    default boolean isEmpty()
    {
        return fillCount() == 0;
    }

    default  boolean isFull()
    {
        return fillCount() == capacity();
    }
}
