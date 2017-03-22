package lectureCode.lecture10;

public class DogLauncher
{	
	public static Comparable cmp(Comparable a, Comparable b)
	{
		if (a.compareTo(b) > 0)
		{
			return a;
		}
		return b;
	}

	public static Comparable cmpor(Comparable a, Comparable b, Comparator c)
	{
		if (c.compare(a, b) > 0)
		{
			return a;
		}
		return b;
	}


	public static void main(String[] args)
	{
		Dog d1 = new Dog("Elyse", 3);
		Dog d2 = new Dog("Strue", 9);
		Dog d3 = new Dog("Benjamin", 13);
		Dog[] dogs = new Dog[]{d1, d2, d3};
		Comparator nc = Dog.getNameComparator();
		// Dog bigDog = (Dog) cmpor(d3, d1, nc);
		Dog maxDog = (Dog) Maximizer.max(dogs, nc);
		maxDog.bark();
	}
}