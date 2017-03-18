package Leetecode;

/**
 * Created by qinjiawei on 17-2-10.
 */
public class DistinctSubsequences {

    /**
     * 115  动态规划
     * dp 的矩阵是横坐标表示的是T串(目标串)，纵坐标表示的是s串（母串，寻找其中的子串）
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {

        if (s.length() <1 && t.length() >0)
            return 0;
        if (s.length() >0 && t.length() <1)
            return 1;

        int slen = s.length();
        int tlen = t.length();

        int[][] dp = new int[slen + 1][ tlen + 1];

        dp[0][0] = 1;
        for (int i =0 ;i < tlen; i++)
            dp[i][0] = 0; // 母串是空的所以没有匹配的
        for (int i = 0; i < slen; i++)
            dp[0][i] = 1; //目标是空，所以肯定存在一个匹配的

        for (int i =1 ; i<= tlen ;i++)
            for (int j =1; j<= slen; j++)
            {
                dp[i][j] = dp[i][j-1]; //s已经匹配了j-1个字符得到的匹配个数是dp[i][j-1]
                if(s.charAt(j-1) == t.charAt(i-1)) //如果 s中的第j个字符和t中第i个字符匹配，那么它的数量特意去寻找j-1 和i-1来匹配
                    dp[i][j] += dp[i-1][j-1];

            }
        return dp[tlen ][slen ];
    }
}
