package Leetecode;

import java.util.HashMap;

/**
 * Created by liberator on 16-4-7.
 */
public class Contains_Duplicate {


    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i=0;i<nums.length; i++)
        {
            if (hashMap.containsKey(nums[i]))
            {
                return Boolean.TRUE;
            }
            else
                hashMap.put(nums[i], 1);

        }
        return Boolean.FALSE;

    }
}
