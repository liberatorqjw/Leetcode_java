package Leetecode;

/**
 * Created by qinjiawei on 16-5-15.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /*
    最长不连续子序列
    用一个exits数组保存出现的字符 位置
    如果遍历的字符出现过 那么位置就要回退到之前出现的下一个位置， 同时更新start位置，还有出现的数组

     */

    public int lengthOfLongestSubstring(String s) {

        int res =0;
        int start =0;
        boolean[] exists = new boolean[256];

        for (int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if (exists[ch])
            {
                res = Math.max(res, i- start);

                for (int k =start; k < i; k++)
                {
                    if(s.charAt(k) == ch)
                    {
                        start = k +1;
                        break;
                    }
                    exists[s.charAt(k)] = false;
                }
            }
            else
                exists[ch] = true;
        }
        return Math.max(res, s.length() - start);

    }
    public int method2(String s)
    {
        int[] loc = new int[256];
        int res =0;
        //记录开始的位置 由于数组初始值不能为-1, 所以调整位置都加1
        int idex = 0;

        for (int i =0; i< s.length(); i++)
        {
            if (loc[s.charAt(i)] > idex)
            {

                idex =  loc[s.charAt(i)];
            }

            res = Math.max(i+1 - idex, res);
            loc[s.charAt(i)] = i+1;
        }
        return res;
    }
}
