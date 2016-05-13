package Leetecode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qinjiawei on 16-5-8.
 */
public class IsomorphicStrings {

    /*
    判断同构
    注意要判断两回
     */
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length())
            return false;

        Map<Character, Character> map = new HashMap<>();

        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        for(int i =0 ; i< s.length(); i++)
        {
            if(map.containsKey(schar[i]))
            {
                if (!(map.get(schar[i]).charValue()== tchar[i]))
                    return false;
            }
            else
                map.put(schar[i], tchar[i]);
        }
        map.clear();
        for(int i =0 ; i< t.length(); i++)
        {
            if(map.containsKey(tchar[i]))
            {
                if (!(map.get(tchar[i]).charValue()== schar[i]))
                    return false;
            }
            else
                map.put(tchar[i], schar[i]);
        }
        return true;


    }
}
