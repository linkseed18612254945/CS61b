package lectureCode.lecture12and13;

import java.util.List;

public interface Map61B<K, V>
{
	void put(K key, V value);
	boolean containsKey(K key);
	V get(K key);
	int size();
	List<K> keys();
}