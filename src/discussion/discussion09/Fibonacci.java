package discussion.discussion09;

import java.util.HashMap;

/**
 * Created by 51694 on 2017/4/17.
 */
public class Fibonacci
{
    HashMap<Integer, Integer> map = new HashMap<>();

    public int fib(int n)
    {
        map.put(-2, 0);
        map.put(-1, 1);
        int x = 0;
        for (int i = 2; i <= n; i += 1)
        {
            x = map.get(-2) + map.get(-1);
            map.put(-2, map.get(-1));
            map.put(-1, x);
        }
        return x;
    }

    public int fibRec(int n)
    {
        if (n == 0)
        {
            return 0;
        }
        else if (n == 1)
        {
            return 1;
        }
        else
        {
            return fibRec(n - 1) + fibRec(n - 2);
        }
    }

}
