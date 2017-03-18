package Leetecode.backtracking;

/**
 * Created by qinjiawei on 17-3-15.
 */
public class CountNumberswithUniqueDigits {

    /**
     * 357
     * 题目的意思 表示几位数，求出数字都是不重复的数字的个数
     * 公式f(k) = 9 * 9 * 8 * ... (9 - k + 2)
     * @param n
     * @return
     */
    public static int countNumbersWithUniqueDigits(int n) {

        if (n == 0)
            return 1;
        int ans = 1;
        for (int i =1; i<=n; i++)
        {
            ans +=count(i);
        }
        return ans;
    }

    static int count(int k)
    {
        if (k==0)
            return 0;
        if (k ==1)
            return 10;

        int res = 1;
        for (int i = 9; i>= (9-k+2); i--)
        {
            res *= i;
        }

        return res *9;
    }

    public static void main(String[] args) {
        countNumbersWithUniqueDigits(2);
    }
}
