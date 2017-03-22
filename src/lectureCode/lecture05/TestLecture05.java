package lectureCode.lecture05;

public class TestLecture05
{
	public static void main(String[] args) 
	{
		/*
		int[] z = null;
		int[] x, y;

		x = new int[]{1, 2, 3, 4, 5};
		y = x;
		x = new int[]{-1, 2, 5, 4, 99};
		y = new int[3];
		z = new int[0];
		int xL = x.length;

		String[] s = new String[6];
		s[4] = "ketchup";
		s[x[3] - x[1]] = "muffins";

		int[] b = {9, 10, 11};
		System.arraycopy(b, 0, x, 0, 3);
		System.out.println(x[2]);
		*/

		int[][] pascalsT;
		pascalsT = new int[4][];
		int[] rowZero = pascalsT[0];
		pascalsT[0] = new int[]{1};
		pascalsT[1] = new int[]{1, 1};
		pascalsT[2] = new int[]{2, 2, 1};
		pascalsT[3] = new int[]{1, 3, 3, 1};
		int[] rowTwo = pascalsT[2];
		rowTwo[1] = -5;
		int[][] matrixA, matrixB, matrixC;
		matrixA = new int[4][];
		matrixB = new int[4][4];
		matrixC = new int[][]{{1}, {1, 1}, {1, 2, 1}, {1, 3, 3, 1}};
	}

}