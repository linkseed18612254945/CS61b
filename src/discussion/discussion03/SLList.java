package discussion.discussion03;

public class SLList<Item>
{	
	/* The node class in list */
	private class IntNode
	{
		public Item item;
		public IntNode next;

		IntNode(Item i, IntNode n)
		{
			item = i;
			next = n;
		}
	}

	/* The class of list */
	private int size;
	private IntNode sentinel;
	private IntNode last;


	/* Constructor of list with empty or one node */ 
	public SLList()
	{
		size = 0;
		sentinel = new IntNode(null, null);
		last = sentinel;
	}

	public SLList(Item x)
	{
		size = 1;
		sentinel = new IntNode(null, new IntNode(x, null));
		last = sentinel.next;
	}

	/* Add an int node to the head of list, value is x. */
	public void addFirst(Item x)
	{
		sentinel.next = new IntNode(x, sentinel.next);
		if (last == null)
		{
			last = sentinel.next;
		}
		size += 1;
	}

	/* Return the value of first node */
	public Item getFirst()
	{
		return sentinel.next.item;
	}

	/* Remove the first element in list */
	public void removeFirst()
	{
		if (isEmpty()) return;
		sentinel.next = sentinel.next.next;
		size -= 1;
	}

	/* Adds an item to the end of the list */
	public void addLast(Item x)
	{	
		last.next = new IntNode(x, null);
		last = last.next;
		size += 1;
	}

	/* Return the last node value of the list */
	public Item getLast()
	{
		return last.item;
	}

	/* Remove the last node of the list */
	public void removeLast()
	{
		if (isEmpty()) return;
		IntNode p = sentinel;
		while (p.next.next != null)
		{
			p = p.next;
		}
		last = p;
		p.next = null;
	}

	/* Return the size of list */
	public int size()
	{
		return size;
	}

	public boolean isEmpty()
	{
		return sentinel.next == null;
	}

	/* Insert a node in the position of list */
	public void insert(Item item, int position)
	{
		if (position < 0) throw new IllegalArgumentException();
		if (position > size) position = size;
		IntNode currentP = sentinel;
		int index = 0;
		while (index < position)
		{
			currentP = currentP.next;
			index += 1;
		}
		currentP.next = new IntNode(item, currentP.next);
	}

	/* Reverse the node of list , method 1 , put every node front of the first node */
	public void reverse1()
	{
		IntNode p = sentinel.next;
		IntNode temp;
		last = p;
		while (p != null)
		{
			temp = p.next;
			p.next = sentinel.next;
			sentinel.next = p;
			p = temp;
		}
		last.next = null;
	}

	/* Reverse the node of list , method 2 , put every node behind the last node */
	public void reverse2()
	{
		IntNode p = sentinel.next;
		IntNode temp, first;
		first = sentinel.next;
		sentinel.next = last;
		while (p != last)
		{
			temp = p.next;
			p.next = last.next;
			last.next = p;
			p = temp;
		}
		last = first;
	}

	public String toString()
	{
		IntNode p = sentinel.next;
		String returnString = "";
		while (p != null)
		{
			if (returnString == "")
			{
				returnString = "" + p.item;
			}
			else
			{
				returnString = returnString + " -> " + p.item;					
			}
			p = p.next;
		}
		return returnString;
	}
}