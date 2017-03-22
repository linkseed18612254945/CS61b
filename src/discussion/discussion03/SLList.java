package discussion.discussion03;

public class SLList
{	
	/* The node class in list */
	public class IntNode
	{
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n)
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
		sentinel = new IntNode(0, null);
		last = sentinel;
	}

	public SLList(int x)
	{
		size = 1;
		sentinel = new IntNode(0, null);
		sentinel.next = new IntNode(x, null);
		last = sentinel.next;
	}

	/* Add an int node to the head of list, value is x. */
	public void addFirst(int x)
	{
		sentinel.next = new IntNode(x, sentinel.next);
		if (last == null)
		{
			last = sentinel.next;
		}
		size += 1;
	}

	/* Return the value of first node */
	public int getFirst()
	{
		return sentinel.next.item;
	}

	/* Remove the first element in list */
	public void removeFirst()
	{
		sentinel.next = sentinel.next.next;
	}

	/* Adds an item to the end of the list */
	public void addLast(int x)
	{	
		last.next = new IntNode(x, null);
		last = last.next;
		size += 1;
	}

	/* Return the last node value of the list */
	public int getLast()
	{
		return last.item;
	}

	/* Remove the last node of the list */
	public void removeLast()
	{
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

	/* Insert a node in the position of list */
	public void insert(int item, int position)
	{
		IntNode currentP = sentinel;
		int index = 0;
		while (index < position)
		{
			currentP = currentP.next;
			index += 1;
		}
		IntNode insetNode = new IntNode(item, currentP.next);
		currentP.next = insetNode;
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