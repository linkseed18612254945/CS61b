package lectureCode.lecture02;

public class DogLanucher
{
	public static void main(String[] args)
	{
		Dog d = new Dog(20);
		Dog d2 = new Dog(45);
		Dog big = Dog.maxDog(d, d2);
		big.makeNoise();
		System.out.println(big.binome);
	}
}