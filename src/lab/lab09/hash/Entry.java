package lab.lab09.hash;

import java.util.Map;

/**
 * Created by 51694 on 2017/4/17.
 */
public class Entry<K, V> implements Map.Entry<K, V>
{
    K key;
    V value;
    public Entry<K, V> next;

    Entry(K key, V value, Entry<K, V> next)
    {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public K getKey()
    {
        return key;
    }

    @Override
    public V getValue()
    {
        return value;
    }

    @Override
    public V setValue(V value)
    {
        V old = this.value;
        this.value = value;
        return old;
    }

    public int hashCode()
    {
        return key.hashCode();
    }

    public boolean equals(Entry e)
    {
        return this.key.equals(e.getKey());
    }

}
