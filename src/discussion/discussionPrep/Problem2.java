package discussion.discussionPrep;

public class Problem2
{	
	public static void changeDiagram(IntList a, IntList b)
	{

		IntList tempNode, aNode = a, bNode = b;
		while (aNode.tail != null)
		{
			tempNode = aNode.tail;
			aNode.tail = bNode.tail;
			bNode.tail = tempNode;
			bNode = aNode.tail;
			aNode = tempNode;
		}
	}

	public static void main(String[] args) 
	{
	 	IntList a = new IntList(0, null);
	 	a.tail = new IntList(2, null);
	 	a.tail.tail = new IntList(4, null);
	 	a.tail.tail.tail = new IntList(6, null);

	 	IntList b = new IntList(1, null);
	 	b.tail = new IntList(3, null);
	 	b.tail.tail = new IntList(5, null);
	 	b.tail.tail.tail = new IntList(7, null);

	 	System.out.println(a);
	 	System.out.println(b);
	 	changeDiagram(a, b);
	 	System.out.println("Changed");
	 	System.out.println(a);
	 	System.out.println(b);
	} 
}