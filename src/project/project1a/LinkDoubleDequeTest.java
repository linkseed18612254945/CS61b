package project.project1a;

import static org.junit.Assert.*;
import org.junit.Test;
public class LinkDoubleDequeTest
{	
	@Test
	public void LLDDequeBuildTest()
	{
		LinkedListDoubleDeque testDeque = new LinkedListDoubleDeque();
		assertEquals(true, testDeque.isEmpty());
	}

	@Test
	public void LLDDequeFirstTest()
	{
		LinkedListDoubleDeque<Integer> testDeque = new LinkedListDoubleDeque<>();
		testDeque.addFirst(12);
		testDeque.addFirst(87);
		testDeque.addFirst(7);
		assertEquals("7->87->12", testDeque.toString());
		assertEquals(3, testDeque.size());
		Integer expectedInt = 7;
		assertEquals(expectedInt, testDeque.removeFirst());
		assertEquals("87->12", testDeque.toString());
		testDeque.removeFirst();
		testDeque.removeFirst();
		assertEquals(0, testDeque.size());
		assertEquals("", testDeque.toString());
		assertEquals(null, testDeque.removeFirst());
	}

	@Test
	public void LLDDequeLastTest()
	{
		LinkedListDoubleDeque<String> testDeque = new LinkedListDoubleDeque<>();
		testDeque.addLast("I");
		testDeque.addLast("am");
		testDeque.addLast("fine!");
		assertEquals("I->am->fine!", testDeque.toString());
		assertEquals(3, testDeque.size());
		String expectedStr1 = "fine!";
		assertEquals(expectedStr1, testDeque.removeLast());
		assertEquals("I->am", testDeque.toString());
		String expectedStr2 = "am";
		assertEquals(expectedStr2, testDeque.removeLast());
		testDeque.removeLast();
		assertEquals(0, testDeque.size());
		assertEquals("", testDeque.toString());
		assertEquals(null, testDeque.removeLast());
	}

	@Test
	public void LLDDequeGetTest()
	{
		LinkedListDoubleDeque<String> testDeque = new LinkedListDoubleDeque<>();
		testDeque.addLast("I");
		testDeque.addLast("am");
		testDeque.addLast("fine!");
		assertEquals("am", testDeque.getItem(1));
		assertEquals("fine!", testDeque.getItem(2));
		assertEquals(null, testDeque.getItem(6));
		assertEquals("am", testDeque.getRecursive(1));
		assertEquals("fine!", testDeque.getRecursive(2));
		assertEquals(null, testDeque.getRecursive(6));
	}



	public static void main(String[] args)
	{
		jh61b.junit.TestRunner.runTests("all", LinkDoubleDequeTest.class);
	}
}