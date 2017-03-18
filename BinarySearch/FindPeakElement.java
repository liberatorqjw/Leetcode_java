package Leetecode.BinarySearch;

/**
 * Created by qinjiawei on 17-2-27.
 */
public class FindPeakElement {
    public static int findPeakElement(int[] nums) {

        if (nums== null || nums.length <1)
            return  0;
        int left =0;
        int right = 0;
        for (int i =0; i< nums.length; i++)
        {
            if (i-1<0)
                left = Integer.MIN_VALUE;
            else
             left = nums[i-1];

            if (i+1 >=nums.length)
                right = Integer.MIN_VALUE;
            else
              right = nums[i+1];
            if (nums[i] >left && nums[i] > right)
                return i;
        }
        return 0;
    }

    /**
     * 二分查找
     * 假设如果不存在，那么就会有存在一个序列是个递增的，因为 num【0】大于左边的元素
     * @param nums
     * @return
     */
    public int find(int[] nums)
    {


        return 1;
    }
    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,1};
        findPeakElement(num);
    }
}
