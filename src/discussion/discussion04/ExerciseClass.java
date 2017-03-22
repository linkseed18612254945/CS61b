package discussion.discussion04;

public class ExerciseClass
{
	public class A
	{
		public int x = 5;
		public void m1()
		{
			System.out.println("Am1-> " + x);
		}
		public void m2()
		{
			System.out.println("Am2-> " + this.x);
		}
		public void update()
		{
			x = 99;
		}
	}

	public class B extends A
	{
		@Override
		public void m2()
		{
			System.out.println("Bm2-> " + x);
		}

		public void m2(int y)
		{
			System.out.println("Bm2y-> " + y);
		}

		public void m3()
		{
			System.out.println("Bm3-> " + "called");
		}
	}

	public class C extends B
	{
		public int y = x + 1;

		@Override
		public void m2()
		{
			System.out.println("Cm2-> " + super.x);
		}

		public void m4()
		{
			System.out.println("Cm4-> " + super.x);
		}

		public void m5()
		{
			System.out.println("Cm->5 " + y);
		}
	}


}