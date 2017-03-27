package discussion.discussion07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by 51694 on 2017/3/25.
 */
public class Duplicate
{
    // order of growth: O(square(n))
    public static boolean complicateDuplicate(int[] arr)
    {
        int N = arr.length;
        for (int i = 0; i < N; i += 1)
        {
            boolean x = false;
            for (int j = 0; j < N; j += 1)
            {
                if (i != j && arr[i] == arr[j])
                {
                    x = true;
                }
            }
            if (!x)
            {
                return false;
            }
        }
        return true;
    }

    // order of growth: O(n)
    public static boolean simpleDuplicate(int[] arr)
    {
        Map<Integer, Integer> itemMap = new HashMap<>();
        int N = arr.length;
        for(int i = 0; i < N; i += 1)
        {
            if (itemMap.containsKey(arr[i]))
            {
                Integer itemNum = itemMap.get(arr[i]);
                itemNum += 1;
                itemMap.put(arr[i], itemNum);
            }
            else
            {
                itemMap.put(arr[i], 1);
            }
        }
        return !itemMap.containsValue(1);
    }

    //order of growth: O(n)
    public static boolean sortedDuplicate(int[] arr)
    {
        int N = arr.length;
        Arrays.sort(arr);
        if (N % 2 != 0)
        {
            return false;
        }
        for (int i = 0; i < N; i += 2)
        {
            if (arr[i] != arr[i + 1])
            {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args)
    {
        int[] testArray = new int[] {1, 2, 2, 1, 4};
        int[] testArray1 = new int[] { 1, 3, 1, 2};

        // System.out.println(complicateDuplicate(testArray));
        // System.out.println(complicateDuplicate(testArray1));

        System.out.println(simpleDuplicate(testArray));
        System.out.println(simpleDuplicate(testArray1));

        System.out.println(sortedDuplicate(testArray));
        System.out.println(sortedDuplicate(testArray1));
    }
}
