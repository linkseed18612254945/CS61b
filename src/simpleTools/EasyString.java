package simpleTools;

/**
 * Created by 51694 on 2017/3/27.
 */
public class EasyString
{
    public static String pyStyleJoin(String[] strings, Character pun)
    {
        String joinString = "";
        for (int i = 0; i < strings.length; i += 1)
        {
            if (i == strings.length - 1)
            {
                joinString += strings[i];
                break;
            }
            joinString += strings[i] + pun;
        }
        return joinString;
    }

    public static String pyStyleJoin(String[] str1, Character pun1,  String[] str2, Character pun2)
    {
        String joinString = "";
        for (int i = 0; i < str1.length; i += 1)
        {
            if (i == str1.length - 1)
            {
                joinString += str1[i] + pun1 + str2[i];
                break;
            }
            joinString += str1[i] + pun1 + str2[i] + pun2;
        }
        return joinString;
    }


}
