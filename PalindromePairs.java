package Leetecode;

import java.util.*;

/**
 * Created by qinjiawei on 16-12-30.
 */
public class PalindromePairs {

    /**
     * 336  找到回文对
     * 1. 暴力求解方法，但是肯定会超时的
     * 2. 利用字典wmap保存单词 -> 下标的键值对

     遍历单词列表words，记当前单词为word，下标为idx：

     1). 若当前单词word本身为回文，且words中存在空串，则将空串下标bidx与idx加入答案

     2). 若当前单词的逆序串在words中，则将逆序串下标ridx与idx加入答案

     3). 将当前单词word拆分为左右两半left，right。

     3.1) 若left为回文，并且right的逆序串在words中，则将right的逆序串下标rridx与idx加入答案

     3.2) 若right为回文，并且left的逆序串在words中，则将left的逆序串下标idx与rlidx加入答案
     其实就是一种方法，通过map快速查找
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Set<List<Integer>> ret = new HashSet<>();

        int i =0;
        for (String word:words)
            map.put(word, i++);

        int j=0;
        for (String word : words)
        {
            int len = word.length();

            //之所以要到 len是因为要考虑特殊的情况
            for (i =0;  i<=len; i++)
            {
                String left = word.substring(0, i);
                String right = word.substring(i, len);

                if (isOakindrome(left)){
                    Integer tmp = map.get(new StringBuilder(right).reverse().toString());
                    if (tmp != null && tmp !=j)
                    {
                        List<Integer> ret_tmp = new ArrayList<>();
                        //注意组合的顺序
                        ret_tmp.add(tmp);
                        ret_tmp.add(j);
                        ret.add(ret_tmp);
                    }

                }

                //
                if (isOakindrome(right)){
                    Integer tmp = map.get(new StringBuilder(left).reverse().toString());
                    if (tmp != null && tmp !=j)
                    {
                        List<Integer> ret_tmp = new ArrayList<>();
                        ////注意组合的顺序
                        ret_tmp.add(j);
                        ret_tmp.add(tmp);
                        ret.add(ret_tmp);
                    }
                }
            }
            j++;
        }
        return new ArrayList<List<Integer>>(ret);
    }

    public boolean isOakindrome(String s)
    {
        int left =0;
        int right = s.length() -1;
        while (left <=right)
        {
            if (s.charAt(left) == s.charAt(right))
            {
                left++;
                right--;
            }
            else
                return false;
        }
        return true;
    }
}
