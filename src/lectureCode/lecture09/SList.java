package lectureCode.lecture09;

public class SList<obj> implements List61B<obj>
{	
	public class Node
	{
		public obj item;
		public Node next, prior;

		public Node(obj i, Node p, Node n)
		{
			item = i;
			prior = p;
			next = n;
		}
	}

	/* The class of list */
	private int size;
	private Node sentinel;


	/* Constructor of list with empty or one node */ 
	public SList()
	{
		size = 0;
		obj empty = null;
		sentinel = new Node(empty, null, null);
		sentinel.prior = sentinel;
		sentinel.next = sentinel;
	}

	public SList(obj x)
	{
		size = 0;
		sentinel = new Node(x, null, null);
		sentinel.prior = sentinel;
		sentinel.next = sentinel;
	}

	/* Return if deque is empty */
	public boolean isEmpty()
	{
		if(sentinel.next == sentinel)
		{
			return true;
		}
		return false;
	}

	/* Add an obj node to the head of list, value is x. */
	public void addFirst(obj x)
	{
		sentinel.next = new Node(x, sentinel, sentinel.next);
		sentinel.next.next.prior = sentinel.next;
		size += 1;
	}

	/* Remove the first element in list */
	public obj removeFirst()
	{
		if (isEmpty())
		{
			return null;
		}
		obj firstItem = sentinel.next.item;
		sentinel.next.next.prior = sentinel;
		sentinel.next = sentinel.next.next;
		size -= 1;
		return firstItem;
	}

	@Override
	public obj getFirst()
	{
		if (isEmpty())
		{
			return null;
		}
		obj firstItem = sentinel.next.item;
		return firstItem;
	}

	/* Adds an item to the end of the list */
	@Override
	public void addLast(obj x)
	{
		sentinel.prior.next = new Node(x, sentinel.prior, sentinel);
		sentinel.prior = sentinel.prior.next;
		size += 1;
	}

	@Override
	public obj getLast()
	{
		obj lastItem = sentinel.prior.item;
		return lastItem;
	}

	/* Remove the last node of the list */
	@Override
	public obj removeLast()
	{
		if (isEmpty())
		{
			return null;
		}
		obj lastItem = sentinel.prior.item;
		sentinel.prior= sentinel.prior.prior;
		sentinel.prior.next = sentinel;
		size -= 1;
		return lastItem;
	}

	/* Return the index item in the list */
	@Override
	public obj get(int index)
	{
		if (index < 0 || index >= size || isEmpty())
		{
			return null;
		}
		Node p = sentinel.next;
		for (int i=0; i<size; i++)
		{
			if (i == index)
			{
				return p.item;
			}
			p = p.next;
		}
		return null;
	}

	/* Return the index item in the list recursively  */
	private obj getRecursiveHelper(int index, Node p)
	{	
		if (index == 0)
		{
			return p.item;
		}
		return getRecursiveHelper(index - 1, p.next);
	}

	public obj getRecursive(int index)
	{
		if (index < 0 || index >= size || isEmpty())
		{
			return null;
		}
		Node p = sentinel.next;
		return getRecursiveHelper(index, p);
	}

	@Override
	public int size()
	{
		return size;
	}

	public String toString()
	{
		Node p = sentinel.next;
		String returnString = "";
		while (p != sentinel)
		{
			if (returnString.equals(""))
			{
				returnString = "" + p.item;
			}
			else
			{
				returnString = returnString + "->" + p.item;					
			}
			p = p.next;
		}
		return returnString;
	}
}