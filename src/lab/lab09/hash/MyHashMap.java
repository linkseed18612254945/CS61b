package lab.lab09.hash;


import java.util.*;

/**
 * Created by 51694 on 2017/4/17.
 */
public class MyHashMap<K extends Comparable<K>, V> implements Map61B<K, V>
{
    private static int SMALLEST_BUCKET = 4;
    private static int DEFAULT_FACTOR = 5;

    private int size;
    private int bucketNumber;
    private double loadFactor;
    private Entry<K, V>[] hashTable;

    public MyHashMap(int initialBuckets, double loadFactor)
    {
        if (initialBuckets < SMALLEST_BUCKET || loadFactor <= 0)
        {
            throw new IllegalArgumentException();
        }
        bucketNumber = initialBuckets;
        size = 0;
        this.loadFactor = loadFactor;
        hashTable = (Entry<K, V>[]) new Entry[bucketNumber];
    }

    public MyHashMap(int initialSize)
    {
        this(initialSize, DEFAULT_FACTOR);
    }
    public MyHashMap()
    {
        this(SMALLEST_BUCKET, DEFAULT_FACTOR);
    }


    private int hash(K key)
    {
        return (0x7fffffff & key.hashCode()) % bucketNumber;
    }

    private Entry<K, V> find(Entry<K, V> currentEntry, K key)
    {
        if (currentEntry == null)
        {
            return null;
        }
        if (currentEntry.getKey().equals(key))
        {
            return currentEntry;
        }
        return find(currentEntry.next, key);
    }

    private void growSize()
    {
        MyHashMap<K, V> tempHashMap = new MyHashMap<>(bucketNumber * 2);
        for (int i = 0; i < bucketNumber; i += 1)
        {
            Entry<K, V> currentEntry = hashTable[i];
            while (currentEntry != null)
            {
                tempHashMap.put(currentEntry.getKey(), currentEntry.getValue());
                currentEntry = currentEntry.next;
            }
        }
        this.hashTable = tempHashMap.hashTable;
        this.size = tempHashMap.size;
        this.bucketNumber = tempHashMap.bucketNumber;
    }


    @Override
    public void clear()
    {
        size = 0;
        for (int i = 0; i < bucketNumber; i += 1)
        {
            hashTable[i] = null;
        }
    }

    @Override
    public boolean containsKey(K key)
    {
        return get(key) != null;
    }

    @Override
    public V get(K key)
    {
        if (key == null)
        {
            throw new IllegalArgumentException();
        }
        int hashIndex = hash(key);
        Entry<K, V> e = find(hashTable[hashIndex], key);
        if (e == null)
        {
            return null;
        }
        else
        {
            return e.getValue();
        }
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public void put(K key, V value)
    {
        if (key == null)
        {
            throw new IllegalArgumentException();
        }
        if (value == null)
        {
            remove(key);
        }
        int hashIndex = hash(key);
        Entry<K, V> e = find(hashTable[hashIndex], key);
        if (e == null)
        {
            hashTable[hashIndex] = new Entry<>(key, value, hashTable[hashIndex]);
            size += 1;
        }
        else
        {
            e.setValue(value);
        }
        if (size > loadFactor * bucketNumber)
        {
            growSize();
        }
    }

    @Override
    public Set<K> keySet()
    {
        Set<K> keys = new HashSet<>();
        for (int i = 0; i < bucketNumber; i += 1)
        {
            Entry<K, V> currentEntry = hashTable[i];
            while (currentEntry != null)
            {
                keys.add(currentEntry.getKey());
                currentEntry = currentEntry.next;
            }
        }
        return keys;
    }

    @Override
    public V remove(K key)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator()
    {
        return new KeyIterator();
    }

    private class KeyIterator implements Iterator<K>
    {
        private int nextPosition;
        private int currentIndex;
        private Entry<K, V> nextEntry;

        KeyIterator()
        {
            nextPosition = 0;
            currentIndex = 0;
            nextEntry = hashTable[currentIndex];
        }
        public boolean hasNext()
        {
            return nextPosition < size;
        }

        public K next()
        {
            while (nextEntry == null)
            {
                nextPosition += 1;
                nextEntry = hashTable[currentIndex];
            }
            K returnKey = nextEntry.getKey();
            nextPosition += 1;
            nextEntry = nextEntry.next;
            return returnKey;
        }
    }
}
