package project.project1b;

public class Palindrome
{	
	/** Conver the string word to deque */
	public static Deque<Character> wordToDeque(String word)
	{
		Deque<Character> wordDeque = new ArrayDequeSolution<>();
		for (int i = 0; i < word.length(); i += 1)
		{
			wordDeque.addLast(word.charAt(i));
		}
		return wordDeque;
	} 


	/* Check if the word is Palindrome */
	public static boolean isPalindrome(String word)
	{
		if (word.length() <= 1)
		{
			return true;
		}
		char firstChar = word.charAt(0);
		char lastChar = word.charAt(word.length() - 1);
		boolean firstLastEqual = (firstChar == lastChar);
		String cutWord = word.substring(1, word.length() - 1);
		return firstLastEqual && isPalindrome(cutWord);
	}

	/* Check if the word is Palindrome by the comparator like character off by one */
	public static boolean isPalindrome(String word, CharacterComparator cc)
	{
		if (word.length() <= 1)
		{
			return true;
		}
		char firstChar = word.charAt(0);
		char lastChar = word.charAt(word.length() - 1);
		boolean firstLastEqual = cc.equalChars(firstChar, lastChar);
		String cutWord = word.substring(1, word.length() - 1);
		return firstLastEqual && isPalindrome(cutWord, cc);
	}

	public static void testTask1()
	{
		String testWord1= "noon";
		String testWord2 = "a";
		String testWord3 = "mipo";

		Deque<Character> testWordDeque = wordToDeque(testWord3);
		testWordDeque.printDeque();
		System.out.println();

		System.out.println(isPalindrome(testWord1));
		System.out.println(isPalindrome(testWord2));
		System.out.println(isPalindrome(testWord3));
	}

	public static void testTask2()
	{
		OffByOne obo = new OffByOne();
		System.out.println(obo.equalChars('b', 'a'));
		System.out.println(obo.equalChars('r', 'q'));
		System.out.println(obo.equalChars('a', 'e'));
		System.out.println(obo.equalChars('z', 'a'));
		System.out.println(obo.equalChars('a', 'a'));
		System.out.println();

		CharacterComparator cc = new OffByOne();
		String testWord1= "ba";
		String testWord2= "flake";
		String testWord3= "yrqaze";

		System.out.println(isPalindrome(testWord1, cc));
		System.out.println(isPalindrome(testWord2, cc));
		System.out.println(isPalindrome(testWord3, cc));
	}

	public static void testTask3()
	{
		OffByN offby5 = new OffByN(5);
		System.out.println(offby5.equalChars('f', 'a'));
		System.out.println(offby5.equalChars('h', 'f'));
		System.out.println();

		String testWord1= "fa";
		String testWord2= "hbagm";
		String testWord3= "yrqaze";
		CharacterComparator cc = new OffByN(5);
		System.out.println(isPalindrome(testWord1, cc));
		System.out.println(isPalindrome(testWord2, cc));
		System.out.println(isPalindrome(testWord3, cc));
	} 

	public static void main(String[] args) 
	{
		// testTask1();
		// testTask2();
		testTask3();
	}
}