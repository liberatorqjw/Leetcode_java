package Leetecode.BinarySearch;

/**
 * Created by qinjiawei on 17-3-2.
 */
public class Pow_X_N {

    /**
     * 50 模拟实现pow(x,n)这个功能
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        if (n ==0 )
            return 1.0;
        // 考虑到特殊情况， 就是在达到数据边界的时候的情况下
        if(Math.abs(x) ==1 && n == -2147483648)
            return 1.0;
        if(Math.abs(x)> 1 && n == -2147483648)
            return 0.0;
        if (n < 0)
            return 1.0/myPow(x, -n);
        // n 右移动1位置，那么就是表示这个操作
        double half = myPow(x, n>>1);
        if (n%2 ==0)
            return half * half;
        else
            // 奇数的时候多剩一个
            return half * half * x;
    }
    public static void main(String[] args) {
        System.out.println(myPow(1.0000, -2147483648));
        int n = -2147483648;
        System.out.println(-n);
    }
}
