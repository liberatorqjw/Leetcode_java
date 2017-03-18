package Leetecode.BinarySearch;

/**
 * Created by qinjiawei on 17-3-2.
 */
public class Search_in_Rotated_Sorted_Array {

    /**
     * 33
     * // 分了几种情况，数据在一个递增的序列中，那么就开始
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length <1 )
            return 0;
        int left =0;
        int right = nums.length-1;

        while (left <=right)
        {
            int mid = left +(right -left)/2;

            if (nums[mid] == target)
                return mid;
            //判断数组的情况,是不是满足真正的有序
            if (nums[left] <= nums[right])
            {
                if (target < nums[mid])
                    right = mid -1;
                else
                    left = mid +1;
            }
            // 左边是大的数组
            else if (nums[left] <= nums[mid])
            {
                // 目标不在左边 目标在小的一端
                if (target > nums[mid] || target < nums[left])
                    left = mid +1;
                else
                    right = mid -1;

            }
            // 左边是小的数组
            else {
                // 目标
                if (target < nums[mid] || target> nums[right])
                    right = mid -1;
                else
                    left = mid +1;
            }
        }
       return  -1;
    }
}
