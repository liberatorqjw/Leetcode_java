package Leetecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qinjiawei on 16-12-23.
 */
public class FindAllAnagramsinaString {

    /**
     * 438
     * 寻找字符一样且次数一样，但是字符的顺序不要一致
     * 思路： 由于只需要保证字符的个数和字符一样，但是顺序不需要一致. 那么就直接自己定义一下顺序.
     * 滑动窗口的思路
     */
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        int[] hp = new int[26];
        int[] hs = new int[26];

        int pl = p.length();
        int sl = s.length();

        for (int i =0; i< p.length(); i++)
        {
            //统计某个字符的次数
            hp[p.charAt(i) - 'a']++;
        }
        for (int i =0; i< s.length(); i++)
        {
            hs[s.charAt(i) - 'a']++;
            if (i >= pl)
            {
                hs[s.charAt(i-pl) - 'a']--;
            }
            if(Arrays.equals(hs,hp)) {
                ans.add(i - pl+1);
            }

        }
        return ans;

    }

    public static void  main(String[] args)
    {
        String s = "cbaebabacd";
        String p = "abc";
        FindAllAnagramsinaString f = new FindAllAnagramsinaString();
        System.out.println(f.findAnagrams(s, p));
    }
}
