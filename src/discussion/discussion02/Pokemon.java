package discussion.discussion02;

public class Pokemon
{
	public String name;
	public int level;

	public Pokemon(String name, int level)
	{
		this.name = name;
		this.level = level;
	}

	public static void change(Pokemon poke, int level)
	{
		poke.level = level;
		level = 50;
		poke = new Pokemon("Genger", 1);
	}
}