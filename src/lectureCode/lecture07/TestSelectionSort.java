package lectureCode.lecture07;

import static org.junit.Assert.*;
import org.junit.Test;



public class TestSelectionSort
{
	@Test
	public void testFindSmall()
	{	
		int[] test1 = new int[] {1, 3, 19, 8, 32};
		int[] test2 = new int[] {13, 3, 19, 8, 32, 7};
		int[] test3 = new int[] {32, 31, 19, 18, 18, 32};
		assertEquals(0, SelectionSort.findSmall(test1, 0));
		assertEquals(5, SelectionSort.findSmall(test2, 2));
		assertEquals(3, SelectionSort.findSmall(test3, 0));
	}

	@Test
	public void testSwap()
	{
		int[] testList = new int[] {13, 3, 19, 8, 32, 2};
		int[] expectedList = new int[] {13, 32, 19, 8, 3, 2};
		SelectionSort.swap(testList, 1, 4);
		assertArrayEquals(expectedList, testList);
	}

	@Test
	public void testSort()
	{
		int[] testList1 = new int[] {13, 3, 19, 8, 32, 2};
		int[] testList2 = new int[] {32, 31, 19, 18, 18, 3};
		int[] expectedList1 = new int[] {2, 3, 8, 13, 19, 32};
		int[] expectedList2 = new int[] {3, 18, 18, 19, 31, 32};
		SelectionSort.sort(testList1);
		SelectionSort.sort(testList2);
		assertArrayEquals(expectedList1, testList1);
		assertArrayEquals(expectedList2, testList2);
	}

	public static void main(String[] args)
	{
		jh61b.junit.TestRunner.runTests("all", TestSelectionSort.class);
	}
}