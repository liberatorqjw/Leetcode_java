package Leetecode;

/**
 * Created by qinjiawei on 16-5-24.
 */
public class DivideTwoIntegers {

    /**
     * 想到计算机中的数值用二进制表示
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        int res =0;

        if (divisor == 0)
            return Integer.MAX_VALUE;

        //被除数为最小 此时一般情况下是1 但是有些情况还要继续计算，所以把被除数放大, 之所以是res为1， 因为
        //被除数减去除数，相当于结果加了1
        if (dividend == Integer.MIN_VALUE)
        {
            //note that
            if (divisor == -1)
                res = 0;
            else
                res =1;
            dividend += Math.abs(divisor);
        }
        //除数为最小 计算机中直接就是结果为0
        if (divisor == Integer.MIN_VALUE)
            return res;

        boolean isNeg = ((dividend ^divisor)>>>31 ==1)? true:false;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int digits =0;
        //左移动除数， 让它刚好小于被除数的最大值
        while (divisor <= (dividend>>1))
        {
            divisor <<=1;
            digits +=1;
        }

        while (digits >=0)
        {
            if(dividend >=divisor)
            {
                dividend -= divisor;
                res += 1<<digits;
            }

            digits --;
            //基数永远保持小于被除数的最大值
            divisor >>=1;

        }
        return isNeg?-res: res;
    }
}
