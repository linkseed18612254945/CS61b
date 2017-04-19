package lectureCode.lecture18;

import edu.princeton.cs.algs4.SequentialSearchST;

import java.util.HashSet;

/**
 * Created by 51694 on 2017/4/17.
 */
public class SeparateChainingHashST<K, V>
{
    private static final int INIT_CAPACITY = 4;
    private static final int LONGEST_LINK = 10;

    private int n;                          // number of key-value pairs
    private int m;                          // hash table size
    private SequentialSearchST<K, V>[] st;

    public SeparateChainingHashST()
    {
        this(INIT_CAPACITY);
    }

    public SeparateChainingHashST(int m)
    {
        this.m = m;
        st = (SequentialSearchST<K, V>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i += 1)
        {
            st[i] = new SequentialSearchST<>();
        }
    }

    private void resize(int chains)
    {
        SeparateChainingHashST<K, V> temp = new SeparateChainingHashST<>(chains);
        for (int i = 0; i < m; i += 1)
        {
            for (K key: st[i].keys())
            {
                temp.put(key, st[i].get(key));
            }
        }
        this.m = chains;
        this.n = temp.n;
        this.st = temp.st;
    }

    private int hash(K key)
    {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public void put(K key, V value)
    {
        if (key == null)
        {
            throw new IllegalArgumentException();
        }
        if (value == null)
        {
            delete(key);
            return;
        }

        if (n >= LONGEST_LINK * m)
        {
            resize(2 * m);
        }

        int hashIndex = hash(key);
        if (!st[hashIndex].contains(key))
        {
            n += 1;
        }
        st[hashIndex].put(key, value);
    }

    public V get(K key)
    {
        if (key == null)
        {
            throw new IllegalArgumentException();
        }
        int hashIndex = hash(key);
        return st[hashIndex].get(key);
    }

    public boolean contains(K key)
    {
        if (key == null)
        {
            throw new IllegalArgumentException();
        }

        return get(key) != null;
    }

    public boolean isEmpty()
    {
        return size() != 0;
    }

    public int size()
    {
        return n;
    }

    public void delete(K key)
    {
        if (key == null)
        {
            throw new IllegalArgumentException();
        }
        int hashIndex = hash(key);
        if (st[hashIndex].contains(key))
        {
            n -= 1;
        }
        st[hashIndex].delete(key);
        if (n < m * LONGEST_LINK && m > INIT_CAPACITY)
        {
            resize(m / 2);
        }
    }

    public Iterable<K> keys()
    {
        HashSet<K> keys = new HashSet<>();
        for (int i = 0; i < m; i += 1)
        {
            for (K key: st[i].keys())
            {
                keys.add(key);
            }
        }
        return keys;
    }

}
