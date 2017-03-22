package lectureCode.lecture12and13;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class IterationDemo
{	
	public static void listIterTest()
	{
		List<String> l = new ArrayList<>();
		l.add("nice");
		l.add("fine");
		l.add("new");

		for (String item : l) 
		{
			System.out.println(item);
		}
		System.out.println();

		Iterator<String> liter = l.iterator();
		while (liter.hasNext())
		{
			System.out.println(liter.next());
		}
	} 

	public static void mapIterTest()
	{
		ArrayMap<String, Integer> am = new ArrayMap<>();
		am.put("Hello", 5);
		am.put("reas", 6);
		am.put("pop", 12);

		Iterator ami = am.iterator();
		while (ami.hasNext())
		{
			System.out.println(ami.next());
		}
		System.out.println();

		for (String key : am)
		{
			System.out.println(key);	
		}
	} 

	public static void main(String[] args) 
	{
		//listIterTest();
		mapIterTest();
	}
}