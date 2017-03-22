package lectureCode.lecture10;// import java.util


public class Dog implements Comparable<Dog>
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

	@Override
	public int compareTo(Dog d)
	{
		return this.size - d.size;
	}

	private static class NameComparator implements Comparator<Dog>
	{
		@Override
		public int compare(Dog a, Dog b)
		{
			return a.name.compareTo(b.name);
		}
	}

	public static Comparator<Dog> getNameComparator()
	{
		return new NameComparator();
	}

	public void bark()
	{
		System.out.println(name + " says: bark!!");
	}
}