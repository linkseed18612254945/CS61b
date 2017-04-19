package lectureCode.lecture18;

/**
 * Created by 51694 on 2017/4/14.
 */
public class HashTest
{
    public static void main(String[] args)
    {
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>();
        st.put("lk", 49);
        st.put("hkx", 2);

        System.out.println(st.get("lk"));
    }
}
