package Leetecode;

/**
 * Created by qinjiawei on 16-4-20.
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int j = 1;
        if (nums.length ==0)
            return 0;
        int index =0;
        nums[index] = nums[0];

        int length = nums.length;
        for (int i=0; i<length; i++)
        {
            if(nums[index] != nums[i])
                nums[++index] = nums[i];

        }

            return index+1;

    }
}
