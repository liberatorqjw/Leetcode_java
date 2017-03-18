package Leetecode;

import java.util.*;

/**
 * Created by qinjiawei on 16-12-21.
 */
public class LongestPalindrome {
    /**
     * 409
     * 求组成最长的回文
     * 主要是奇数的时候需要考虑的情况比较复杂
     * 奇数的时候要想到去掉一个也是偶数，所以也是可以构成回文的,所以是奇数虽然要取出最大，但是如果不是最大,那也不能直接舍弃
     * 也是需要加到最终结果中的。
     */

    public int longestPalindrome(String s) {

        Map<Integer, Integer> ans = new HashMap<>();
        for (int i =0; i< s.length(); i++)
        {
            if (ans.containsKey(Integer.valueOf(s.charAt(i))))
                ans.put(Integer.valueOf(s.charAt(i)),ans.get(Integer.valueOf(s.charAt(i))) +1);
            else
                ans.put(Integer.valueOf(s.charAt(i)),1);
        }
//        Set<Integer> values = (Set<Integer>) ans.values();
//        Iterator<Integer> it = values.iterator();
        int count =0;
        boolean flag = false;
        int max =0;
//        while (it.hasNext())
        for (Integer tmp : ans.values())
        {

            if (tmp % 2 ==0)
                count +=tmp;
            else {
                if (tmp >max)
                {
//                    把上一次的奇数加到最终的结果中， 但是当第一次的时候多减少了一个1
                    count += max -1;
                    max = tmp;
                }
                else
                //奇数减少1也是偶数
                    count += tmp -1;
            }
        }
        //max不等于0 表示存在奇数，那么就会在第一次多减少一个1 所以需要在后面加上来 +1操作
        return max ==0?count:count + max +1;
    }

    public static void  main(String[] args)
    {
        String s = "abccccdd";
        LongestPalindrome l = new LongestPalindrome();
        l.longestPalindrome(s);
    }
}
