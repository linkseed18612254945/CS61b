package discussion.discussion02;

public class Cat
{
	public String name;
	public static String noise;

	public Cat(String name, String noise)
	{
		this.name = name;
		this.noise = noise;
	}

	public void play()
	{
		System.out.println(noise + " I'm " + name + " the cat");
	}

	public static void anger()
	{
		noise = noise.toUpperCase();
	}

	public static void calm()
	{
		noise = noise.toLowerCase();
	}
}