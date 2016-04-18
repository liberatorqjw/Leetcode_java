package Leetecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by qinjiawei on 16-4-14.
 */
public class HappyNumber {
    public boolean isHappy(int n) {

        if(n<=0)
            return Boolean.FALSE;
        if(n==1)
            return Boolean.TRUE;
        List<Integer> sumlist = new ArrayList<>();

        int sum;
        while(true)
        {
            sum=0;
            while(n !=0)
            {
                sum += (n%10) * (n%10);
                n /=10;

            }
            if(sum ==1)
                return true;
            if(sumlist.contains(sum))
                return false;
            sumlist.add(sum);
            n = sum;

        }

    }

}
