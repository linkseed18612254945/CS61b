package lectureCode.lecture12and13;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class ArrayMap<K, V> implements Map61B<K, V>, Iterable<K>
{	
	private K[] keys;
	private V[] values;
	private int mapCapacity = 100;
	int size;

	public ArrayMap()
	{
		keys = (K[]) new Object[mapCapacity];
		values = (V[]) new Object[mapCapacity];
		size = 0;
	}

	/* Return the index of the given key if it exists, -1 otherwise */
	private int keyIndex(K key)
	{
		for (int i = 0; i < size; i += 1) 
		{
			if (keys[i].equals(key))
			{
				return i;
			}
		}
		return -1;
	}


	/* Put the associate key and value in the map */
	@Override
	public void put(K key, V value)
	{
		int index = keyIndex(key);
		if (index > -1)
		{
			values[index] = value;
		}
		else
		{
			keys[size] = key;
			values[size] = value;
			size += 1;
		}
	}

	/* Checks to see if ArrayMap contains the key */
	@Override
	public boolean containsKey(K key)
	{
		return keyIndex(key) > -1;
	}

	/* Return the value of key, assuming key exists */
	@Override
	public V get(K key)
	{
		int index = keyIndex(key);
		if (index < 0)
		{
			throw new IllegalArgumentException("The key provided " + key + " was not in ArrayMap.");
		}
		return values[index];
	}

	/* Returns a list of all keys */
	@Override
	public List<K> keys()
	{
		List<K> keyList = new ArrayList<K>();
		for (int i = 0; i < size; i += 1) 
		{
			keyList.add(keys[i]);
		}
		return keyList;
	}

	/* Returns number of keys */
	@Override
	public int size()
	{
		return size;
	}

	public Iterator<K> iterator()
	{
		return new KeyIterator();
	}


	/* The Iterator class for keys of map */
	private class KeyIterator implements Iterator<K>
	{
		private int nextPosition;

		public KeyIterator()
		{
			nextPosition = 0;
		}

		public boolean hasNext()
		{
			return nextPosition < size;
		}

		public K next()
		{
			K returnKey = keys[nextPosition];
			nextPosition += 1;
			return returnKey;
		}
	}
}