package Leetecode;

import java.util.HashMap;

/**
 * Created by liberator on 16-4-7.
 */
public class Majority_Element {

    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int max =0;
        int maxnum =0;
        for(int i=0;i<nums.length; i++)
        {
            if (hashMap.containsKey(nums[i]))
            {
                int value = hashMap.get(nums[i]);
                hashMap.put(nums[i], value+1);
            }
            else
                hashMap.put(nums[i], 1);

            int value_tmp = hashMap.get(nums[i]);
            if(value_tmp >max)
            {
                maxnum = nums[i];
                max = value_tmp;
            }

        }
        return maxnum;
    }
}
