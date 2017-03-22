package lectureCode.lecture09;

public class AList<Item> implements List61B<Item>
{	
	private Item[] items;
	private int size;
	private int RFACTOR = 4;

	/* Create an empty list */
	public AList()
	{
		items = (Item[]) new Object[100];
		size = 0;
	}

	/* Resize the underlying array to the target capacity */
	private void resize(int capacity)
	{
		Item[] tempArray = (Item[]) new Object[capacity];
		System.arraycopy(items, 0, tempArray, 0, size);
		items = tempArray;
	}
	
	@Override
	public Item getFirst()
	{
		return items[0];
	}


	/* Inserts x into the last position of the the list */
	@Override
	public void addLast(Item x)
	{
		if (size == items.length)
		{
			resize(size * RFACTOR);
		}
		items[size] = x;
		size += 1;
	}

	/* Return the item from last of the list */
	@Override
	public Item getLast()
	{
		return items[size - 1];
	}

	/* Deletes item from last of list and return the deleted item */
	@Override
	public Item removeLast()
	{	
		Item deletedItem = getLast();
		size -= 1;
		items[size] = null;
		return deletedItem;
	}

	/* Get the ith item in the list */
	@Override
	public Item get(int i)
	{
		return items[i];
	}

	/* Return the size of list */
	@Override
	public int size()
	{
		return size;
	}



	public String toString()
	{
		String totalString = "";
		for (int i = 0; i < size; i += 1) 
		{
			totalString = totalString + " " + items[i];
		}
		return totalString;
	}
}