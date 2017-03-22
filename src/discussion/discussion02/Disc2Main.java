package discussion.discussion02;

public class Disc2Main
{
	public static void main(String[] args)
	{
		// Pokemon p = new Pokemon("Pikachu", 17);
		// int level = 100;
		// Pokemon.change(p, level);
		// System.out.println("Name: " + p.name + ", Level: " + p.level);
		
		Cat a = new Cat("Cream", "Meow!");
		Cat b = new Cat("Tubbs", "Nyan!");
		a.play();
		b.play();
		Cat.anger();
		a.calm();
		a.play();
		b.play();
	}
}