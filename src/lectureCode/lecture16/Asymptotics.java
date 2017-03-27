package lectureCode.lecture16;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by 51694 on 2017/3/24.
 */

// order of growth: n
public class Asymptotics
{
    public static void kviate(int[] a, int k)
    {
        int count = 0, N = a.length;
        for (int i = 0; i < N; i += 1)
        {
            if (a[i] == k)
            {
                count += 1;
            }
        }
        a[k] += count;
    }

    // order of growth: log(n)
    public void binarySearch() {}

    public static void main(String[] args)
    {
        int[] array = new int[90000000];
        Stopwatch sw = new Stopwatch();
        kviate(array, 0);
        double x = sw.elapsedTime();
        System.out.println("Time: " + x);
    }
}
