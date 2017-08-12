package lectureCode.lecture03;

public class IntList
{
	public int first;
	public IntList rest;

	public IntList(int f, IntList r)
	{
		first = f;
		rest = r;
	}

	/** Return the size of List recursionly */
	public int size()
	{
		if (rest == null)
		{
			return 1;
		}
		return 1 + this.rest.size();
	}

	public int iterativeSize()
	{
		IntList p = this;
		int totalSize = 0;
		while (p != null)
		{
			totalSize += 1;
			p = p.rest;
		}
		return totalSize;
	}

	/** Return the i.th item in list */
	public int get(int i)
	{
		if (i == 0)
		{
			return first;
		}
		return this.rest.get(i - 1);
	}

	public int iterGet(int i)
	{
		int index = 0;
		IntList p = this;
		while (index != i)
		{
			p = p.rest;
			index += 1;
		}
		return p.first;
	}

	/* Return a new int list copy by a list and increment by int x */
	public static IntList incrList(IntList L, int x)
	{	
		if (L == null)
		{
			return null;
		}
		return new IntList(L.first + x, incrList(L.rest, x));
	}

	/* Return the intlist decrement by int x */
	public static IntList decrList(IntList L, int x)
	{
		IntList p = L;
		while(p != null)
		{
			p.first -= x;
			p = p.rest;
		}
		return L;
	}

	public static IntList SquareDestructive(IntList L)
	{
		IntList org_L = L;
		while (L != null)
		{
			L.first = L.first * L.first;
			L = L.rest;
		} 
		return org_L;
	}

	public static IntList SquareNonDestructive(IntList L)
	{
		if (L == null)
		{
			return L;
		}
		IntList squareL = new IntList(L.first * L.first, SquareNonDestructive(L.rest));
		return squareL;
	}

}