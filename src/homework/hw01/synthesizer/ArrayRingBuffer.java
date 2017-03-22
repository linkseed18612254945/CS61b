package homework.hw01.synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> implements Iterable<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity)
    {
        first = 0;
        last = 0;
        this.capacity = capacity;
        this.fillCount = 0;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x)
    {
        if (isFull())
        {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        last = (last + 1) % capacity;
        fillCount += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue()
    {
        T deleteElement = rb[first];
        first = (first + 1) % capacity;
        fillCount -= 1;
        return deleteElement;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek()
    {
        return rb[first];
    }

    @Override
    public void reset(T resetElement)
    {
        for (int i = 0; i < capacity; i += 1)
        {
            rb[i] = resetElement;
        }
        first = 0;
        last = 0;
        fillCount = 0;
    }

    public Iterator<T> iterator()
    {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T>
    {
        private int nextPosition;
        private int itemNumber = fillCount;
        QueueIterator()
        {
            nextPosition = first;
        }

        public boolean hasNext()
        {
            return (itemNumber != 0);
        }

        public T next()
        {
            T nextMember = rb[nextPosition];
            nextPosition = (nextPosition + 1) % capacity;
            itemNumber -= 1;
            return nextMember;
        }
    }

}
