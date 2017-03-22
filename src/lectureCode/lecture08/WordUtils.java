package lectureCode.lecture08;

import lectureCode.lecture09.List61B;

public class WordUtils
{	
	public static String longest(List61B<String> list)
	{
		int maxDex = 0;
		for (int i = 0; i < list.size(); i += 1)
		{
			String longestString = list.get(maxDex);
			String thisString = list.get(i);
			if (thisString.length() > longestString.length())
			{
				maxDex = i;
			}
		}
		return list.get(maxDex);
	}

	public static void main(String[] args) 
	{
		SLList<String> s1 = new SLList<String>();
		s1.addLast("horse");
		s1.addLast("is");
		s1.print();
		//System.out.println(WordUtils.longest(s1));
	}

}