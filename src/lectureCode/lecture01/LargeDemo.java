package lectureCode.lecture01;

public class LargeDemo
 {
	public static int larger(int x, int y) 
	{
		if (x > y) 
		{
			return x;
		}
		return y;
	}

	public static int double_plus_10(int x)
	{
		if (x < 10)
		{
			x += 10;
		}
		if (x < 10)
		{
			x = x + 10;
		}
		return x;
	}

	public static void if_else_print(int x)
	{
		if (x >= 50)
		{
			System.out.println("woof!");
		}
		else if (x >= 10)
		{
			System.out.println("bark!");
		}
		else 
		{
			System.out.println("yip!");
		}
	}

	public static void while_print(int bottles)
	{
		while (bottles > 0)
		{
			System.out.println(bottles + " bottles of beer on the wall");
			bottles -= 1;
		}
	}

	public static void draw_triangle(int rows)
	{
		int total_row = rows;
		while (rows > 0)
		{
			for (int i=0; i <= total_row - rows; i += 1)
			{
				System.out.print("*");
			}
			System.out.println(" ");
			rows -= 1;
		}
	}

	public static void array_print()
	{
		int[] number = new int[3];
		int[] alternate_num = new int[] {1, 6, 12, 29};
		number[0] = 4;
		number[1] = 7;
		number[2] = 10;
		System.out.println(number[1]);
		System.out.println(alternate_num.length);
	}

	public static int max_int(int[] m)
	{	
		int the_max = 0;
		for (int n : m) 
		{
			if (n > the_max)
			{
				the_max = n;
			}
		}
		return the_max;
	}

	public static void main (String[] args) 
	{
		//System.out.println(larger(8, 10));

		//int x = -1;
		//System.out.println(double_plus_10(x));

		//int dogSize = 1;
		//if_else_print(dogSize);

		//int bot = 50;
		//while_print(bot);

		//int row = 10;
		//draw_triangle(row);

		//array_print();

		int[] numbers = new int[] {9, 2, 15, 2, 22, 10, 6};
		System.out.println(max_int(numbers));
	}

}