package lectureCode.lecture11;

import edu.princeton.cs.introcs.In;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;



public class DemoCollections
{	
	public static int countUniqueWords(List<String> words)
	{
		Set<String> wordSet = new HashSet<String>();
		for (String ithWord : words) 
		{
			wordSet.add(ithWord);
		}
		return wordSet.size();
	} 


	public static String cleanString(String s)
	{
		return s.toLowerCase().replaceAll("[^a-z]","");
	}

	public static Map<String, Integer> collectWordCount(List<String> words, List<String> targets)
	{
		Map<String, Integer> counts = new HashMap<String, Integer>();
		for (String t : targets) 
		{
			counts.put(t, 0);				
		}
		for (String s : words)
		{
			if (counts.containsKey(s))
			{
				int oldCount = counts.get(s);
				counts.put(s, oldCount + 1);			
			}
		}
		return counts;			
	} 

	public static List getWords(String fileName)
	{
		List<String> words = new ArrayList<String>();
		In in = new In(fileName);
		while (!in.isEmpty())
		{
			String nextWord = cleanString(in.readString());
			words.add(nextWord);
		}
		return words;
	} 


	public static void main(String[] args) 
	{
		List<String> w = getWords("C:\\Users\\51694\\cs61b\\texts\\libraryOfBabylon.txt");
		Set<String> setW = new HashSet<>(w);
		Map<String, Integer> wordDict = new HashMap<>();
		List<String> t = new ArrayList<>();
		t.add("the");
		t.add("babylon");
		t.add("lottery");
		wordDict = collectWordCount(w, t);
		System.out.println(wordDict);
	}
}