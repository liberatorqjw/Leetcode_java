package Leetecode.BinarySearch;

/**
 * Created by qinjiawei on 17-3-13.
 */
public class KthLargestElementinanArray {

    /**
     * 215 寻找倒数第几大的数
     * 思路是快速排序
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        //                 第几个位置
        return findk(nums, nums.length-k, 0, nums.length -1);

    }

    public int findk(int[] nums, int k, int i, int j)
    {
        if (i >= j)
            return nums[i];
        int m = partion(nums, i, j);
        if (m == k)
            return nums[m];
        // 位置小于 目标的第几位， 那么就需要继续在后面寻找
        else if (m < k)
        {
            return findk(nums, k, m+1, j);
        }
        // 位置超过了，那么就在前面寻找
        else
        {
            return findk(nums, k, i, m-1);
        }

    }
    public int partion(int[] nums, int i , int j)
    {
        int x = nums[i]; // key
        int m =i;
        int n = i+1;

        // 递增排序
        while (n <= j)
        {
            if (nums[n] < x)
            {
                swap(nums, ++m, n);
            }
            ++n;
        }

        // 把已经排的部分有序重新组装
        swap(nums, i, m);
        // 返回目标位置的下标
        return m;
    }

    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        KthLargestElementinanArray k = new KthLargestElementinanArray();
        k.findKthLargest(nums, 2);
    }
}
