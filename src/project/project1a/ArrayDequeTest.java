package project.project1a;

import static org.junit.Assert.*;
import org.junit.Test;
public class ArrayDequeTest
{	
	@Test
	public void DequeBuildTest()
	{
		ArrayDeque testDeque = new ArrayDeque();
		assertEquals(true, testDeque.isEmpty());
	}

	@Test
	public void DequeBasicTest()
	{
		ArrayDeque<Integer> testDeque = new ArrayDeque<>();
		assertEquals("", testDeque.toString());
		testDeque.addLast(5);
		testDeque.addLast(13);
		assertEquals("5 13", testDeque.toString());
		testDeque.addLast(10);
		testDeque.addLast(11);
		assertEquals("5 13 10 11", testDeque.toString());
		int front = testDeque.removeFirst();
		assertEquals(5, front);
		assertEquals("13 10 11", testDeque.toString());
		testDeque.removeFirst();
		testDeque.addLast(6);
		testDeque.addLast(5);
		testDeque.addLast(4);
		testDeque.addLast(3);
		testDeque.addLast(2);
		testDeque.addLast(1);
		assertEquals("10 11 6 5 4 3 2 1", testDeque.toString());
		assertEquals(8, testDeque.size());
		testDeque.addLast(0);
		testDeque.addLast(-1);
		assertEquals("10 11 6 5 4 3 2 1 0 -1", testDeque.toString());
		assertEquals(10, testDeque.size());
		testDeque.removeFirst();
		testDeque.removeFirst();
		testDeque.removeFirst();
		assertEquals("5 4 3 2 1 0 -1", testDeque.toString());
	}

	public static void main(String[] args)
	{
		jh61b.junit.TestRunner.runTests("all", ArrayDequeTest.class);
	}
}