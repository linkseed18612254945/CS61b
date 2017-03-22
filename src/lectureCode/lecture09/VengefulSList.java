package lectureCode.lecture09;

public class VengefulSList<Item> extends SList<Item>
{	
	private SList<Item> deletedItems;

	public VengefulSList()
	{
		deletedItems = new SList<>();
	}

	public VengefulSList(Item x)
	{
		super(x);
		deletedItems = new SList<>();
	}

	@Override
	public Item removeLast()
	{
		Item x = super.removeLast();
		deletedItems.addLast(x);
		return x;
	}

	public void printLostItems()
	{
		System.out.println(deletedItems);
	}
}