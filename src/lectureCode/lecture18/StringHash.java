package lectureCode.lecture18;

import java.util.LinkedList;

/**
 * Created by 51694 on 2017/4/14.
 */
public class StringHash
{
    LinkedList[] present;

    StringHash()
    {
        present =  new LinkedList[10];
    }

    private int letterNum(String s, int i)
    {
        int ithChar = s.charAt(i);
        if ((ithChar < 'a') || (ithChar > 'z'))
        {
            throw new IllegalArgumentException();
        }
        return ithChar - 'a' + 1;
    }

    private int convertInt(String s)
    {
        int intRep = 0;
        for (int i = 0; i < s.length(); i += 1)
        {
            intRep = intRep << 5;
            intRep += letterNum(s, i);
        }
        return intRep % 10;
    }

    public void insert(String s)
    {
        int intRep = convertInt(s);
        if (present[intRep] == null)
        {
            present[intRep] = new LinkedList<>();
        }
        present[intRep].add(s);
    }

    public boolean contain(String s)
    {
        int intRep = convertInt(s);
        System.out.println(intRep);
        return present[intRep] != null && present[intRep].contains(s);

    }

    public int hashCode()
    {
        return 1;
    }
}
