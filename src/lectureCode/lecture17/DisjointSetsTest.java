package lectureCode.lecture17;

import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by 51694 on 2017/3/27.
 */
public class DisjointSetsTest
{
    public static void main(String[] args)
    {
        String[] people = new String[]{"Alan", "Bob", "Cat", "Domi", "Wiate"};
        RegularDisjointSets<String> djs = new RegularDisjointSets<>(people);
        djs.connect("Alan", "Bob");
        djs.connect("Cat","Wiate");
        djs.connect("Bob","Domi");
        System.out.println(djs.isConnected("Alan", "Cat"));
    }
}
