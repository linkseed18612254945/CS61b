package project.project1b;

class OffByN implements CharacterComparator
{
	private int letterDistance;
	public OffByN(int N)
	{
		letterDistance = N;
	}

	@Override
	public boolean equalChars(char a, char b)
	{
		int differentLetter = a - b;
		return differentLetter == letterDistance || differentLetter == -letterDistance;
	}

}