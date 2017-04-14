package lectureCode.lecture18;

/**
 * Created by 51694 on 2017/4/14.
 */
public class HashTest
{
    public static void main(String[] args)
    {
        String x = "cat";
        StringHash a = new StringHash();
        a.insert(x);
        a.insert("catss");
        System.out.println(a.contain("catss"));
    }
}
