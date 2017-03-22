package discussion.discussion03;

import static org.junit.Assert.*;
import org.junit.Test;

public class ListTest
{
	//@Test
	public void testListInsert()
	{
		SLList testList = rangeList(1, 4, false);
		SLList expectedList = new SLList(1);
		expectedList.addLast(2);
		expectedList.addLast(10);
		expectedList.addLast(3);
		testList.insert(10, 2);
		assertEquals(expectedList.toString(), testList.toString());
	}

	//@Test
	public void testListReverse()
	{
		SLList testList = rangeList(1, 5, false);
		SLList expectedList = rangeList(1, 5, true);
		testList.reverse2();
		assertEquals(expectedList.toString(), testList.toString());
	}


	//@Test
	public void testArrayInsert()
	{
		int[] testArray = new int[] {5, 9, 14, 15};
		int[] expectedArray1 = new int[] {5, 9, 6, 14, 15};
		int[] expectedArray2 = new int[] {5, 9, 14, 15, 11};
		int[] testArray1 = ArrayMethod.insert(testArray, 6, 2);
		int[] testArray2 = ArrayMethod.insert(testArray, 11, 9);
		assertArrayEquals(expectedArray1, testArray1);
		assertArrayEquals(expectedArray2, testArray2);
	}

	//@Test
	public void testArrayReverse()
	{
		int[] testArray = new int[] {5, 9 ,14, 15};
		int[] expectedArray = new int[] {15, 14, 9, 5};
		testArray = ArrayMethod.reverse(testArray);
		assertArrayEquals(expectedArray, testArray);
	}

	@Test
	public void	testXify()
	{
		int[] testArray = new int[] {3, 2, 1};
		int[] expectedArray = new int[] {3, 3, 3, 2, 2, 1};
		testArray = ArrayMethod.xify(testArray);
		assertArrayEquals(expectedArray, testArray);
	}

	/* Build a simple range int list */
	public static SLList rangeList(int start, int end, boolean decre)
	{
		SLList L = new SLList();
		for (int i = start; i < end; i += 1) 
		{
			if (decre)
			{
				L.addFirst(i);			
			}
			else
			{
				L.addLast(i);
			}
		}
		return L;
	}

	public static void main(String[] args)
	{
		jh61b.junit.TestRunner.runTests("all", ListTest.class);
	}
}
