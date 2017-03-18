package Leetecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qinjiawei on 16-12-25.
 */
public class RepeatedDNASequences {

    /**
     * 187
     * 寻找出现重复次数的字符串
     */
    public List<String> findRepeatedDnaSequences(String s) {

        List<String> ans = new ArrayList<>();
        if (s == null || s.length() < 10)
            return ans;

        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i< s.length(); i++)
        {
            if (i+10 > s.length())
                break;
            String tmp = s.substring(i, i+10);
            if (map.containsKey(tmp))
            {
                int k = map.get(tmp);
                map.put(tmp, k+1);
            }
            else
            {
                map.put(tmp, 1);
            }
        }
        for (String key : map.keySet())
        {
            if (map.get(key) >1)
                ans.add(key);
        }
        return ans;
    }
}
