package Leetecode;

/**
 * Created by qinjiawei on 17-2-21.
 */
public class DecodeWays {

    /**
     * 92 动态规划
     *
     * dp[n] 表示前n个字符的编码数量
     * 当知道了n-2的字符串能够编码的数量
     * 还有就是知道了n-1的字符的编码数量
     * 那么第n个字符的时候有两种情况
     * （1） n个字符属于1-9 那么n长度的字符能够编码的数量就包含了n-1 长度的字符
     * (2) n-1 与n 个字符组合可以解释成一个字母的话，n长度的字符能够编码的数量就包含了n-2长度的字符
     * @param s
     * @return
     */
    public int numDecodings(String s) {

        if (s == null || s.length() < 1)
            return 0;
        if (s.length() == 1)
            return s.charAt(0) != '0' ?1:0;
        else if (s.length() == 2)
        {
            return (s.charAt(0) != '0' && s.charAt(1) != '0' ?1:0) + ((s.charAt(0) != '0' && char2int(s.charAt(0)) * 10 + char2int(s.charAt(1))<=26) ?1:0);
        }
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) != '0'?1:0;
        dp[1] = (s.charAt(0) != '0' && s.charAt(1) != '0' ?1:0) + ((s.charAt(0) != '0' && char2int(s.charAt(0)) * 10 + char2int(s.charAt(1))<=26) ?1:0);

        for (int i = 2; i< s.length(); i++)
        {
            dp[1] = 0;

//            （1） n个字符属于1-9 那么n长度的字符能够编码的数量就包含了n-1 长度的字符
            if (s.charAt(i) != '0')
            {
                dp[i] += dp[i-1];
            }
//            * (2) n-1 与n 个字符组合可以解释成一个字母的话，n长度的字符能够编码的数量就包含了n-2长度的字符

            if (s.charAt(i-1) != '0' && (char2int(s.charAt(i-1)) * 10 + char2int(s.charAt(i)) <=26))
            {
                dp[i] +=dp[i-2];
            }
        }

        return dp[s.length() -1];
    }

    /**
     * 字符转换为int
     * @param c
     * @return
     */
    int char2int(char c)
    {
        return c- '0';
    }
}
