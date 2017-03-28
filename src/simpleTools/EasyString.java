package simpleTools;

/**
 * Created by 51694 on 2017/3/27.
 */
public class EasyString
{
    public static String pyStyleJoin(String[] strings, Character pun)
    {
        String joinString = "";
        for (String s: strings)
        {
            joinString += s + pun;
        }
        return joinString.trim();
    }

}
