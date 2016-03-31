public class Solution {
    public void moveZeroes(int[] nums) {
           int index =0;
        int length = nums.length;
        for (int i=0; i< length;i++)
        {
            if (nums[i] !=0)
            {
                nums[index++] = nums[i];
            }
        }
        for (;index<length; index++)
            nums[index] =0;
        
    }
}