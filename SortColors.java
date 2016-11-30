package Leetecode;

/**
 * Created by qinjiawei on 16-11-13.
 */
public class SortColors {

    /**
     * 荷兰国旗问题
     *
     */

    public void sortColors(int[] nums) {

        int left = 0;
        int right = nums.length-1;
        int i=0;
        while (i <=right)
        {
            if(nums[i] ==0)
            {
                int tmp = nums[left];
                nums[left]= nums[i];
                nums[i] = tmp;
                left++;
                i++;   // 返回互相换的时候，可以i++ 操作
            }
            else if(nums[i] ==2)
            {
                int tmp = nums[right];
                nums[right]= nums[i];
                nums[i] = tmp;
                right--;
            }
            else i++;

        }
    }
}
