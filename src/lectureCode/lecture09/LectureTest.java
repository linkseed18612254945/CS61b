package lectureCode.lecture09;

public class LectureTest
{	
	public static int do_twice(IntUnaryFunction f, int x)
	{
		return f.apply(f.apply(x));
	}


	public static void main(String[] args) 
	{
		// RotatingSList<Integer> rsl = new RotatingSList<>();
		// rsl.addLast(10);
		// rsl.addLast(11);
		// rsl.addLast(12);
		// rsl.addLast(13);
		// System.out.println(rsl);
		// rsl.rotateRight();
		// System.out.println(rsl);

		// VengefulSList<Integer> vsl = new VengefulSList<>();
		// SList<Integer> sl = vsl;
		// sl.addLast(1);
		// sl.addLast(5);
		// sl.addLast(10);
		// sl.addLast(13);
		// System.out.println(sl);
		// sl.removeLast();
		// sl.removeLast();
		// System.out.println(sl);
		// System.out.print("The fallen values are:");
		// vsl.printLostItems();
		// VengefulSList<Integer> vsl2 = (VengefulSList) sl;

		// Dog dogTest = new VerboseDog();
		// dogTest.barkMany(3);

		IntUnaryFunction tenF = new Tenx();
		int x = do_twice(tenF, 2);
		System.out.print(x);
	}
}
