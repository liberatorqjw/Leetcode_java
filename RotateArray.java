package Leetecode;

/**
 * Created by qinjiawei on 16-4-23.
 */
public class RotateArray {

    int[]  reverse(int[] nums, int begin, int end)
    {
        int temp;
        for (int i =begin; i<(begin+end)/2; i++)
        {
            temp = nums[end-i-1 + begin];
            nums[end-i-1 + begin] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
    //三次倒序
    // 其中两次是部分倒顺序
    public void rotate(int[] nums, int k) {

        k = k % nums.length;
        nums = reverse(nums, 0, nums.length);
        nums = reverse(nums, 0, k);
        nums = reverse(nums, k, nums.length);

    }
}
