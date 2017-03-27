package discussion.discussion07;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by 51694 on 2017/3/25.
 */
public class FindSum
{
    // order of growth: n ^ 2
    public static boolean findSumSlow(int[] arr, int x)
    {
        int N = arr.length;
        for (int i = 0; i < N; i += 1)
        {
            for (int j = i + 1; j < N; j += 1)
            {
                if (x == arr[i] + arr[j])
                {
                    System.out.println(arr[i]);
                    System.out.println(arr[j]);
                    return true;
                }
            }
        }
        return false;
    }

    // order of growth: n , use map
    public static boolean findSumFaster(int[] arr, int x)
    {
        int N = arr.length, count;
        double half = x / 2, distance;
        Map<Double, Integer> distanceMap = new HashMap<>();
        for(int i = 0; i < N; i += 1)
        {
            distance = Math.abs(arr[i] - half);
            if (distanceMap.containsKey(distance))
            {
                count = distanceMap.get(distance);
                count += 1;
                distanceMap.put(distance, count);
            }
            else
            {
                distanceMap.put(distance, 1);
            }
        }
        return distanceMap.containsValue(2);
    }

    // order of growth: n
    public static boolean findSumFaster2(int[] arr, int x)
    {
        int N = arr.length;
        int leftIndex = 0;
        int rightIndex = N - 1;
        while (leftIndex < rightIndex)
        {
            if (arr[leftIndex] + arr[rightIndex] == x)
            {
                System.out.println(arr[leftIndex]);
                System.out.println(arr[rightIndex]);
                return true;
            }
            else if(arr[leftIndex] + arr[rightIndex] < x)
            {
                leftIndex += 1;
            }
            else
            {
                rightIndex -= 1;
            }
        }
        return false;
    }


    public static void main(String[] args)
    {
        int[] testArray = new int[]{8, 2, 1, 3, 0, 9 , 7, 11, 6, 10, 5};
        Arrays.sort(testArray);
        boolean y = findSumFaster2(testArray, 12);
        System.out.println(y);
    }
}
