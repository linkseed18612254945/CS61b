package lectureCode.lecture07;

public class SelectionSort
{
	/* Find the index of smallest element */
	public static int findSmall(int[] input, int startIndex)
	{
		int minElementIndex = startIndex;
		for (int i = startIndex; i < input.length; i += 1) 
		{
			if (input[i] < input[minElementIndex])
			{
				minElementIndex = i;
			}
		}
		return minElementIndex;
	}

	/* Swap the target and from index element in input list */
	public static void swap(int[] input, int targetIndex, int fromIndex)
	{
		int temp = input[fromIndex];
		input[fromIndex] = input[targetIndex];
		input[targetIndex] = temp;
	}


	/* Sort the list by selection samllest and swap with first */
	private static void sort(int[] x, int k)
	{
		if (k < x.length - 1)
		{
			int smallest = findSmall(x, k);
			swap(x, k, smallest);
			sort(x, k + 1);
		}

	}

	public static void sort(int[] x)
	{
		sort(x, 0);
	}

}