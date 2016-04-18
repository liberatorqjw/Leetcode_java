package Leetecode;

/**
 * Created by qinjiawei on 16-4-14.
 */
public class UglyNumber {

    public boolean isUgly(int num) {
        if (num ==1)
            return Boolean.TRUE;
        if(num <=0)
            return Boolean.FALSE;
        while(num >=2 && num %2==0) num /=2;
        while (num >=3 && num %3 ==0) num/=3;
        while(num>5 && num %5==0) num /=5;

        return num ==1;

    }
}
