package Leetecode;

/**
 * Created by qinjiawei on 16-4-14.
 */
public class PowerOftwo {
    public boolean isPowerOfTwo(int n) {
        if(n ==1)
            return true;
        if(n <=0)
            return false;
        int sum =0;
        while(n!=0)
        {
            sum += n &1;
            n = n >>>1;

        }
        if(sum > 1)
            return false;
        return true;
    }
}
