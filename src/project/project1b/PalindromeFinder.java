package project.project1b;

import edu.princeton.cs.introcs.In;

/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder 
{
    public static void main(String[] args) 
    {
        int minLength = 4;
        In in = new In("C:\\Users\\51694\\cs61b\\texts\\words");
        CharacterComparator ccOne = new OffByOne();
        CharacterComparator ccFive = new OffByN(5);
        int wordCount = 0;

        while (!in.isEmpty()) 
        {
            String word = in.readString();
            if (word.length() >= minLength && Palindrome.isPalindrome(word, ccFive)) 
            {
                wordCount += 1;
                System.out.println(word);
            }
        }
        System.out.println(wordCount);
    }
} 
