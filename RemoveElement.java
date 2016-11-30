package Leetecode;

/**
 * Created by qinjiawei on 16-4-20.
 */
public class RemoveElement {

    //快速排序的思想
    public int removeElement(int[] nums, int val) {

        int sum =0;
        int i =0;
        int j =nums.length -1;
        while(i <=j)
        {
            if(nums[j] == val)
                j--;
            else if(nums[i] == val && nums[j] != val)
            {
                nums[i] = nums[j];
                j--;
                i++;
            }
            else if (nums[i] != val)
                i++;
        }
        return j+1;
    }
}
