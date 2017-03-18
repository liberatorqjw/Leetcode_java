package Leetecode;

/**
 * Created by qinjiawei on 17-2-14.
 */
public class InterleavingString {

    public boolean isInterleave_(String s1, String s2, String s3) {

        if (s3.length() < 1 || s3 == null)
        {
            if (s1.length()<1 && s2.length() < 1)
                return true;
            else return false;
        }

        int i =0;
        int j =0;
        int k =0;

        char s1_char = s1.charAt(i);
        char s2_char = s2.charAt(j);
        char s3_char ;

        while (k < s3.length())
        {
            s3_char = s3.charAt(k);

            if (s1_char == s3_char) {
                i++;
                if (i < s1.length())
                  s1_char = s1.charAt(i);

            }
            else if (s2_char == s3_char)
            {
                j++;
                if (j < s2.length())
                    s2_char = s2.charAt(j);

            }
            else
            {
                return false;
            }
            k++;
        }
        if (i == s1.length() && j == s2.length())
            return true;
        else
            return false;


    }

    /**
     * 深度优先遍历，但是会出现超时的错误
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave_dfs(String s1, String s2, String s3)
    {
        if ( s1.length() == 0)
            return s2.equals(s3);
        if (s2.length() ==0)
            return s1.equals(s3);
        if (s3.length() ==0)
            return s1.length() + s2.length() == 0;

        if (s1.charAt(0) == s3.charAt(0) && s2.charAt(0) != s3.charAt(0))
            return isInterleave_dfs(s1.substring(1), s2, s3.substring(1));
        else if (s1.charAt(0)!= s3.charAt(0) && s2.charAt(0) == s3.charAt(0))
            return isInterleave_dfs(s1, s2.substring(1), s3.substring(1));
        else if (s1.charAt(0) == s2.charAt(0) && s2.charAt(0) == s3.charAt(0))
            return isInterleave_dfs(s1.substring(1), s2, s3.substring(1)) || isInterleave_dfs(s1, s2.substring(1), s3.substring(1));

        else
            return false;
    }

    /**
     * 97 动态规划去做
     * dp[i][j]表示s1取前i位，s2取前j位，是否能组成s3的前i+j位
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3)
    {
        if ( s1.length() == 0)
            return s2.equals(s3);
        if (s2.length() ==0)
            return s1.equals(s3);
        if (s3.length() ==0)
            return s1.length() + s2.length() == 0;

      boolean[][] dp = new boolean[s1.length() +1][s2.length() +1];
        dp[0][0] =true;
        for (int i =1; i <=s1.length(); i++)
        {
            //字符串中的第i个匹配上了，那么就应该标注为true  dp[i][j] 就是表示s1的前i-1个和s2的前j-1组成的字符串和s3的i + j-1 相匹配
            if (s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0])
                dp[i][0] = true;
        }

        for (int i =1; i<=s2.length(); i++)
        {
            if (s2.charAt(i-1) == s3.charAt(i-1) && dp[0][i-1])
                dp[0][i] = true;
        }

        for (int i =1; i<= s1.length(); i++)
            for (int j=1; j <= s2.length(); j++ )
            {
                if (s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j])
                    dp[i][j] = true;
                if (s2.charAt(j-1) == s3.charAt(i+j -1) && dp[i][j-1])
                    dp[i][j] = true;
            }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";

        InterleavingString is = new InterleavingString();
        is.isInterleave(s1, s2, s3);
    }
}
