package lectureCode.lecture09;

public interface List61B<Item>
{
	public void addLast(Item y);
	public Item getFirst();
	public Item getLast();
	public Item removeLast();
	public Item get(int i);
	public int size();

	default public void print()
	{
		for (int i = 0; i < size(); i += 1)
		{
			System.out.print(get(i) + " ");
		}
		System.out.println();
	}
}