package lectureCode.lecture12and13;

import static org.junit.Assert.*;
import org.junit.Test;
public class MapTest
{	
	@Test
	public void xxTest()
	{
		ArrayMap<Integer, Integer> am = new ArrayMap<>();
		am.put(2, 5);
		int expected = 5;
		// assertEquals((Integer) expected, am.get(2));
		assertEquals(expected, (int) am.get(2));
	}

	//@Test
	public void getTest()
	{
		Map61B<String, Integer> m = new ArrayMap<String, Integer>();
		m.put("horse", 3);
		m.put("fish", 9);
		m.put("house", 10);
		Integer actual = MapHelper.get(m, "fish");
		Integer expected = 9;
		assertEquals(expected, actual);
		Integer actualNull = MapHelper.get(m, "none");
		assertEquals(null, actualNull);
	}

	//@Test
	public void maxKeyTest()
	{
		Map61B<String, Integer> m = new ArrayMap<String, Integer>();
		m.put("horse", 3);
		m.put("fish", 9);
		m.put("house", 10);
		String actual = MapHelper.maxKey(m);
		String expected = "house";
		assertEquals(expected, actual);
	}

	//@Test
	public void maxValueTest()
	{
		Map61B<String, Integer> m = new ArrayMap<String, Integer>();
		m.put("horse", 3);
		m.put("fish", 18);
		m.put("house", 10);
		String actual = MapHelper.maxValue(m);
		String expected = "fish";
		assertEquals(expected, actual);
	}

}