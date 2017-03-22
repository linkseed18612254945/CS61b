package project.project1b;

public class OffByOne implements CharacterComparator
{	
	@Override
	public boolean equalChars(char a, char b)
	{
		int differentLetter = a - b;
		return differentLetter == 1 || differentLetter == -1;
	} 
}