package Leetecode;

import java.util.*;

/**
 * Created by qinjiawei on 16-5-13.
 */
public class ContainsDuplicateII {

    /*
    set 维护一个数组 滑动窗口
    时刻保持窗口的大小在 k之内
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        int start =0;
        int end =0;
        Set<Integer> setnum = new HashSet<Integer>();

        for (int i =0; i< nums.length; i++)
        {
           if (!setnum.contains(nums[i]))
           {
               setnum.add(nums[i]);
               end++;
           }
           else return true;

            if(end - start > k)
            {
                   setnum.remove(nums[start]);
                   start++;
            }


        }
        return false;
    }
}
