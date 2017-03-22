package lectureCode.lecture12and13;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class MapHelper
{	
	public static <K, V> V get(Map61B<K, V> sim, K key)
	{
		if (sim.containsKey(key))
		{
			return sim.get(key);
		}
		return null;
	}

	/* Returns max of all keys. Works only if keys are comparable */
	public static <K extends Comparable<K>, V> K maxKey(Map61B<K, V> sim)
	{
		List<K> keyList = sim.keys();
		K largest = keyList.get(0);
		for (K k : keyList) 
		{
			if (k.compareTo(largest) > 0)
			{
				largest = k;
			}
		}
		return largest;
	}

	/* Returns the key with max value in whole map. Works only if values are comparable */
	public static <K, V extends Comparable<V>> K maxValue(Map61B<K, V> sim)
	{
		List<K> keyList = sim.keys();
		K largest = keyList.get(0);
		for (K k : keyList) 
		{
			if (sim.get(k).compareTo(sim.get(largest)) > 0)
			{
				largest = k;
			}
		}
		return largest;
	} 
}