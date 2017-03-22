package lectureCode.lecture03;

public class TestType
{
	public static void main(String[] args)
	{
		// char c = 'H';
		// int x = c;
		// System.out.println(c);
		// System.out.println(x);

		// Walrus a = new Walrus(1000, 8.3);
		// Walrus b;
		// b = a;
		// b.weight = 5;
		// System.out.println(a.weight);
		// System.out.println(b.weight);

		// Walrus wl = new Walrus(3500, 10.5);
		// int x = 9;
		// doStuff(wl, x);
		// System.out.println(wl);
		// System.out.println(x);

		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);
		// IntList newInL = IntList.incrList(L, 3);
		L = IntList.SquareNonDestructive(L);
		System.out.println(L.get(2));
	}

	public static void doStuff(Walrus w, int x)
	{
		w.weight -= 100;
		x -= 5;
	}
}