package Leetecode;

/**
 * Created by qinjiawei on 16-4-21.
 */
public class FactorialTrailingZeroes {
    /*
    给定一个整数n，返回n!（n的阶乘）数字中的后缀0的个数。

     注意：你的解法应该满足多项式时间复杂度
     n!后缀0的个数 = n!质因子中5的个数
     */
    public int trailingZeroes(int n) {
        if(n<1) return 0;
        int c = 0;

        while(n/5 != 0) {
            n /= 5;
            c += n;
        }

        return c;

    }

}
