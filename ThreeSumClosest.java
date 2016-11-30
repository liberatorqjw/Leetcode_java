package Leetecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qinjiawei on 16-5-20.
 */
public class ThreeSumClosest {
    /**
     * 3Sum Closest
     *
     */
    public int threeSumClosest(int[] nums, int target) {

        int l =0;
        int r =0;
        int start =0;
        int aultarget =-1;
        if(nums.length < 3 || nums == null)
            return 0;

        Arrays.sort(nums);

        int len = nums.length;
        int close =1000000;

        for (int i=0; i<len-2; i++ )
        {
            if (i> 0 && nums[i] == nums[i-1])
                continue;

            start = i;
            l = i+1;
            r = len-1;

            while (l < r)
            {
                int item = nums[l] + nums[r] + nums[start];
                if(Math.abs(target - item) ==0) {
                    close = 0;
                    aultarget = target;
                    return aultarget;
                }
                else if (Math.abs(target - item) < close)
                {
                    close =Math.abs(target - item);
                    aultarget = item;

                }

                if(item < target)
                    l++;
                else
                    r--;
            }
        }
        return aultarget;
    }
}
