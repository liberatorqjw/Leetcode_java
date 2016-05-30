package Leetecode;

/**
 * Created by qinjiawei on 16-5-19.
 */
public class LongestPalindromicSubstring {

    /**
     * 最长回文子串
     */
    public String longestPalindrome(String s) {

        if(s == null)
            return null;
        StringBuilder sb = new StringBuilder();

        sb.append("#");
        for(int i=0; i< s.length(); i++)
        {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        return Manacher(sb.toString());
    }

    public  String  Manacher(String s)
    {
        int id =0;
        int mx = 0;
        int[] p = new int[s.length()];
        for (int i =1; i< s.length(); i++)
        {
            if(mx > i)
                p[i] = Math.min(p[2 * id - i], mx -i );
            else
                p[i] = 1;
            while ( ((i-p[i])>=0) && ((i + p[i]) < s.length()) && (s.charAt(i + p[i]) == s.charAt(i -p[i])))
            {
                p[i] ++;
            }
            if(p[i] +i > mx)
            {
                mx = p[i] + i;
                id = i;
            }

        }
        int max =0;
        int index =0;
        for (int i =0; i< p.length; i++)
        {
            if(p[i] -1 > max)
            {
                max = p[i] -1;
                index = i;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i= index -max; i<=index + max; i++)
        {
            if(s.charAt(i) != '#')
            res.append(s.charAt(i));
        }
        //System.out.append("max: " + max);
        //System.out.append("result: " + res.toString());

        return res.toString();
    }
}
