package lectureCode.lecture09;

public class RotatingSList<Item> extends SList<Item>
{	
	public void rotateRight()
	{
		Item x = removeLast();
		addFirst(x);
	}
}