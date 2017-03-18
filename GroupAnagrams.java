package Leetecode;

import java.util.*;

/**
 * Created by qinjiawei on 16-12-25.
 */
public class GroupAnagrams {

    /**
     * 49
     * 回文数组
     */
    public List<List<String>> groupAnagrams(String[] strs) {


        List<List<String>> ans = new ArrayList<>();
        if (strs == null || strs.length <1)
            return ans;
        Map<String,List<String>> map = new HashMap<>();
        for (String item : strs)
        {
//            int[] hash = new int[26];
//
//            for (int i =0; i< item.length(); i++)
//            {
//                hash[item.charAt(i)- 'a']++;
//            }
            char[] args = item.toCharArray();
            Arrays.sort(args);
            String hash = new String(args);

            if (map.containsKey(hash)) {
                map.get(hash).add(item);
            }else {
                System.out.println("do not contain"+ hash);
                List<String> ret = new ArrayList<>();
                ret.add(item);
                map.put(hash, ret);
            }
        }

        for (List<String> value : map.values())
        {

            ans.add(value);
        }

        return  ans;

    }

}
