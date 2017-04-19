package discussion.discussion09;

/**
 * Created by 51694 on 2017/4/17.
 */
public class dis09Test
{
    public static void main(String[] args)
    {
        Fibonacci f =  new Fibonacci();
        int fibn = f.fib(6);
        int fibn2 = f.fibRec(6);
        System.out.println(fibn);
        System.out.println(fibn2);
    }

}
