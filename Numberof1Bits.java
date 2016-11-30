package Leetecode;

/**
 * Created by qinjiawei on 16-4-13.
 */
public class Numberof1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(long n) {
        //对于大数字要进行以为运算
        int sum=0;
        long m;
        while(n !=0)
        {
            sum += n & 1;
            n = n >>> 1;
        }

        return sum;
    }
}
