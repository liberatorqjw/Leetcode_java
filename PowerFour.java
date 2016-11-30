package Leetecode;

/**
 * Created by qinjiawei on 16-4-18.
 */
public class PowerFour {

    public boolean isPowerOfFour(int num) {

        double logans = Math.log10(num) /Math.log10(4);
        return (logans - (int)logans) ==0 ?true: false;
    }
}
