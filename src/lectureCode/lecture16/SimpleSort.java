package lectureCode.lecture16;

import java.util.Arrays;

/**
 * Created by 51694 on 2017/3/26.
 */
public class SimpleSort
{
    // order of growth: n ^ 2
    private static void selectSort(int[] arr)
    {
        int N = arr.length;
        int smallestIndex, temp;
        for (int i = 0; i < N; i += 1)
        {
            //System.out.println(Arrays.toString(arr));
            smallestIndex = i;
            for (int j = i + 1; j < N; j += 1)
            {
                if (arr[j] < arr[smallestIndex])
                {
                    smallestIndex = j;
                }
            }
            if (i != smallestIndex)
            {
                temp = arr[smallestIndex];
                arr[smallestIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    // order of growth: n + m
    private static int[] combine(int[] A, int[] B)
    {
        int N = A.length + B.length;
        int AIndex = 0, BIndex = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i += 1)
        {
            //System.out.println(Arrays.toString(arr));
            if (AIndex >= A.length)
            {
                System.arraycopy(B, BIndex, arr, i, N - i);
                return arr;
            }
            if (BIndex >= B.length)
            {
                System.arraycopy(A, AIndex, arr, i, N - i);
                return arr;
            }

            if (A[AIndex] <= B[BIndex])
            {
                arr[i] = A[AIndex];
                AIndex += 1;
            }
            else
            {
                arr[i] = B[BIndex];
                BIndex += 1;
            }
        }
        return arr;
    }

    private static void mergeSort(int[] arr)
    {

    }

    public static void main(String[] args)
    {
        int[] testArr = new int[] {20, 9, 5, 3, 2, 1, 7, 6, 8, 11, 0, 13, 10};
        int[] testA = new int[] {2, 3, 6, 10, 11};
        int[] testB = new int[] {4, 5, 7, 8};
        System.out.println(Arrays.toString(testArr));
        int[] arr = combine(testA, testB);
        System.out.println(Arrays.toString(arr));
    }
}
