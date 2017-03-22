package lectureCode.lecture08;

public class Dog
{	
	private String name;
	private int size;

	public Dog(String n, int s)
	{
		name = n;
		size = s;
	}

	public int size()
	{
		return size;
	}

	public void bark()
	{
		System.out.println(name + " says: bark!!");
	}
}