package Leetecode.DivideandConquer;

/**
 * Created by qinjiawei on 17-2-22.
 */
public class MaximumSubarray {

    /**
     * 53 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        //整体的最大
        int sum =0;

        // 当前连续的最大数值
        int cursum =0;

        // 默认的最大就是第一个
        sum = nums[0];

        for (int i =0; i< nums.length; i++)
        {
            // 当不是负数的时候继续向上叠加
            if (cursum >=0)
            {
                cursum += nums[i];
            }
            //当以上的都是已经为负了 那么就需要重置，重新找个开始的节点
            else
            {
                cursum =nums[i];
            }
            if (cursum >sum)
            {
                sum = cursum;
            }
        }
        return sum;
    }
}
