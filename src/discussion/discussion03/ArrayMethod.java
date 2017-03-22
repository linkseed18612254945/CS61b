package discussion.discussion03;

public class ArrayMethod
{	

	/* Insert a new item in the list x */
	public static int[] insert(int[] x, int term, int position)
	{
		int[] newArray = new int[x.length + 1];
		if (position > x.length)
		{
			position = x.length;
		}
		System.arraycopy(x, 0, newArray, 0, position);
		newArray[position] = term;
		System.arraycopy(x, position, newArray, position + 1, x.length - position); 
		return newArray;
	} 

	/* Reverse the list x */
	public static int[] reverse(int[] x)
	{
		int[] newArray = new int[x.length];
		for (int i = 0; i < x.length; i += 1) 
		{
			newArray[i] = x[x.length - 1 -i];	
		}
		return newArray;
	} 

	/* Build a extend copy, [3, 2, 1] -> [3, 3, 3, 2, 2, 1, 1] */
	public static int[] xify(int[] x)
	{
		int sum = 0;
		for (int i=0; i<x.length; i++) 
		{
			sum += x[i];
		}
		int[] newArray = new int[sum];

		int startIndex = 0;
		for (int element: x) 
		{
			for (int i=0; i<element; i++)
			{
				newArray[startIndex + i] = element;
			}
			startIndex += element;
		}
		return newArray;
	} 
}

