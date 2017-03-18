package Leetecode.BinarySearch;

/**
 * Created by qinjiawei on 17-3-2.
 */
public class Search_in_Rotated_Sorted_ArrayII {

    /**
     * 存在冗余的数字的时候，怎么求这个结果
     * ，我们并不知道应该跳向哪一半。解决的办法只能是对边缘移动一步，
     * 直到边缘和中间不在相等或者相遇，这就导致了会有不能切去一半的可能。
     * 所以最坏情况（比如全部都是一个元素，或者只有一个元素不同于其他元素，而他就在最后一个）
     * 就会出现每次移动一步，总共是n步，算法的时间复杂度变成O(n)
     * @param nums
     * @param target
     * @return
     */
    public static  boolean search(int[] nums, int target) {

        if (nums == null || nums.length < 1)
            return false;

        int left = 0;
        int right = nums.length -1;

        while (left <= right)
        {
            int mid = left + (right -left)/2;
            if (nums[mid] == target)
                return true;
            //开始判断边缘，不能一半的速度砍掉
            // 可能有序
            if (nums[left] < nums[mid])
            {
                //中间节点在左边, 移动右边端点的条件比较苛刻
                if ( target < nums[mid]  && nums[left] <= target )
                    right = mid-1;
                else
                    left = mid +1;
            }
            // 中间节点的数值大于最左边的结果
            // 这个时候两边都可能是重复的数值，或者不重复
            else if (nums[mid] < nums[left])
            {
                // target再右边的有序列
                if (nums[mid] < target && nums[right] >= target)
                {
                    left = mid +1;
                }
                else
                    right = mid -1;
            }
            // 慢慢的移动 左边的序列
            else
            {
                left++;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,1};
        int target = 3;
        search(nums, target);
    }
}
