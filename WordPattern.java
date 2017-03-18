package Leetecode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qinjiawei on 16-5-8.
 */
public class WordPattern {
    /*
    切记 比对一定要两遍， 否则会忽略情况
     */

    public boolean wordPattern(String pattern, String str) {
        String[] strnums = str.trim().split(" ");
        if(strnums.length != pattern.length())
            return false;

        Map<Character, String> map = new HashMap<>();

        Map<String, Character> reversemap = new HashMap<>();

        char[] patternchar = pattern.toCharArray();
        for (int i = 0 ; i< patternchar.length; i++)
        {
            if (!map.containsKey(patternchar[i]))
            {
                map.put(patternchar[i], strnums[i]);
            }
            else
            {
                if(!map.get(patternchar[i]).toString().equals(strnums[i]))
                    return false;
            }
        }
        for (int i = 0 ; i< strnums.length; i++)
        {
            if (!reversemap.containsKey(strnums[i]))
            {
                reversemap.put(strnums[i], patternchar[i]);
            }
            else
            {
                if(!(reversemap.get(strnums[i]) == patternchar[i]))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char c = ']';
        System.out.println(92 - c);
    }
}
