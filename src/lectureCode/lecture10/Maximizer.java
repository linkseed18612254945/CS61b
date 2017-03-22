package lectureCode.lecture10;

public class Maximizer
{	
	public static Comparable max(Comparable[] items, Comparator c)
	{
		if (items == null || items.length == 0)
		{
			return null;
		}
		Comparable maxItem = items[0];
		for (Comparable item: items) 
		{
			if (c.compare(maxItem, item) > 0)
			{
				maxItem = item;
			}
		}
		return maxItem;
	} 
}