package discussion.discussion04;

public class DiscTest
{	
	public static void main(String[] args) 
	{
		 Cat testCat = new Cat("Linda", 4);
		 testCat.greet();

		 Animal a = new Animal("Pluto", 10);
		 Cat c = new Cat("Grafield", 6);
		 Dog d = new Dog("Fido", 4);
		 a = c;
		 a.greet();
		 ((Cat) a).greet();
		 a = new Dog("Spot", 10);
		 d = (Dog) a;

	}
}