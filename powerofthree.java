package Leetecode;

/**
 * Created by qinjiawei on 16-4-14.
 */
public class powerofthree {
    //换底公式
    public boolean isPowerOfThree(int n) {

        double logans = Math.log10(n) / Math.log10(3);
        System.out.println(logans +"\n"+(int)logans);
        return (logans-(int)logans == 0) ? true :false;
    }

}
