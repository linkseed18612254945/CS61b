package discussion.discussionPrep;

public class IntList
{	
	public int head;
	public IntList tail;

	public IntList(int i, IntList n)
	{
		head = i;
		tail = n;
	}

	public String toString()
	{
		String strHead = head + " ";
		if (tail == null)
		{
			return strHead;
		}
		return strHead + tail.toString();
	}	
}