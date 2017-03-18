package Leetecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by qinjiawei on 17-1-3.
 */
public class SubstringwithConcatenationofAllWords {

    /**
     * 30
     * 刚开始的思路是O(n^2), 这样会超时间
     * 思路2 是准备前后两个指针 O(n)
     */

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();
        if (words==null || words.length <1|| s== null || s.length()<1)
            return ans;

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (String word:words)
        {
            if (map.containsKey(word))
                map.put(word, map.get(word) +1);
            else
                map.put(word, 1);
        }

        int left = 0;
        int right =0;
        int len = words[0].length();
        int count =0;

        while (right<s.length())
        {
            String tmp ="";
            if(right + len >=s.length())
                tmp = s.substring(right);
            else
                tmp = s.substring(right, right+len);

            if (map.containsKey(tmp))
            {
                map.put(tmp, map.get(tmp)-1);
                if (map.get(tmp) >=0)
                    count++;
                else
                {
                     for (;left<right;left+=len)
                     {
                    String item = s.substring(left, left+len);
                    if (map.containsKey(item))
                    {
                        map.put(item, map.get(item)+1);

                        if (map.get(item)>0)
                            count--;

                    }
                         if (item.equals(tmp))
                             break;
                     }
                    // left= right;
                    left+=len;

                }

                while (count == words.length)
                {
                    ans.add(left);
                    // for (;left<right;left+=len)
                    // {
                    String item = s.substring(left, left+len);
                    if (map.containsKey(item))
                    {
                        map.put(item, map.get(item)+1);
                        if (map.get(item) >0)
                            count--;
                    }

                    // }
                    // left = right;
                    left += len;
                }
            }
            else {
                for (;left<right;left+=len)
                {
                    String item = s.substring(left, left+len);
                    if (map.containsKey(item))
                    {
                        map.put(item, map.get(item)+1);
                        if(map.get(item)>0)
                            count--;
                    }

                }
                left = right+len;
//                count =0;

            }

            right+=len;
        }

        return ans;
    }

    /**
     * O(n)时间，唯一不同的是之前的，用一个新的字典来保存当前出现的单词情况
     * 这样不需要一直移动left去删除掉哪些已经出现的
     * @param S
     * @param L
     * @return
     */
    public ArrayList<Integer> findSubstring_N(String S, String[] L) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(S==null || S.length()==0 || L==null || L.length==0)
            return res;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<L.length;i++)
        {
            if(map.containsKey(L[i]))
            {
                map.put(L[i],map.get(L[i])+1);
            }
            else
            {
                map.put(L[i],1);
            }
        }
        //窗口的起始位置要控制一下，这样就会把所有的可能都遍历一遍
        for(int i=0;i<L[0].length();i++)
        {
            HashMap<String,Integer> curMap = new HashMap<String,Integer>();
            int count = 0;
            int left = i;
            for(int j=i;j<=S.length()-L[0].length();j+=L[0].length())
            {
                String str = S.substring(j,j+L[0].length());

                if(map.containsKey(str))
                {
                    if(curMap.containsKey(str))
                        curMap.put(str,curMap.get(str)+1);
                    else
                        curMap.put(str,1);
                    if(curMap.get(str)<=map.get(str))
                        count++;
                    // 某个单词的数量超过了目标数量
                    else
                    {
                        while(curMap.get(str)>map.get(str))
                        {
                            String temp = S.substring(left,left+L[0].length());
                            if(curMap.containsKey(temp))
                            {
                                curMap.put(temp,curMap.get(temp)-1);
                                if(curMap.get(temp)<map.get(temp))
                                    count--;
                            }
                            left += L[0].length();
                        }
                    }
                    if(count == L.length)
                    {
                        res.add(left);
                        //if(left<)
                        String temp = S.substring(left,left+L[0].length());
                        if(curMap.containsKey(temp))
                            curMap.put(temp,curMap.get(temp)-1);
                        count--;
                        left += L[0].length();
                    }
                }
                else
                {
                    curMap.clear();
                    count = 0;
                    left = j+L[0].length();
                }
            }
        }
        return res;
    }
    public static void main(String[] args)
    {
        String str="wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","good"};
        SubstringwithConcatenationofAllWords s = new SubstringwithConcatenationofAllWords();
        System.out.println(s.findSubstring(str, words));
    }
}
