package simpleTools;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static boolean pyContain(String[] strings, String s)
    {
        for (String str:strings)
        {
            if (str.equals(s))
            {
                return true;
            }
        }
        return false;
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

    private static void putCollection(Map<String, Integer> m, String k)
    {
        if (m.containsKey(k))
        {
            Integer v = m.get(k);
            v += 1;
            m.put(k, v);
        }
        else
        {
            m.put(k, 1);
        }
    }

    public static String[] hashIntersect(String[] str1, String[] str2)
    {
        Map<String, Integer> tempMap = new HashMap<>();
        Set<String> set1 = new HashSet<>(Arrays.asList(str1));
        Set<String> set2 = new HashSet<>(Arrays.asList(str2));
        for (String s : set1)
        {
            putCollection(tempMap, s);
        }
        for (String s : set2)
        {
            putCollection(tempMap, s);
        }
        if (!tempMap.containsValue(2))
        {
            return null;
        }
        Set<String> intersect = new HashSet<>();
        for (String k : tempMap.keySet())
        {
            if (tempMap.get(k) == 2)
            {
                intersect.add(k);
            }
        }
        return intersect.toArray(new String[0]);
    }


    public static String[] complement(String[] total, String[] other)
    {
        List<String> complementSet = new ArrayList<>();
        for (String s: total)
        {
            if (!pyContain(other, s))
            {
                complementSet.add(s);
            }
        }
        return complementSet.toArray(new String[0]);
    }

    public static String[] stringInMap(Map<String, String> m, String[] strs)
    {
        List<String> stringInMap = new ArrayList<>();
        for (String s: strs)
        {
            if (m.containsKey(s))
            {
                stringInMap.add(s);
            }
        }
        return  stringInMap.toArray(new String[0]);
    }

    public static Matcher containsString(String s, String subs)
    {
        Pattern pattern = Pattern.compile(subs);
        return pattern.matcher(s);
    }

}
