package Leetecode.BinarySearch;

/**
 * Created by qinjiawei on 17-2-26.
 */
public class LongestIncreasingSubsequence {

    /**
     * 300 最长的子序列 不是连续的
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        if (nums.length ==0)
            return 0;

        int[] dis = new int[nums.length];

        dis[0] = 1;
        //至少都有一个 的长度，所以最小是1
        int max = 1;

        for (int i =0; i < nums.length; i++)
        {
            // 找到最长的 递增长度，并且寻找num[j] < num[i]
            for (int j =0; j< i; j++)
            {
                // 一定要递增，相等是不行的
                if (nums[j] < nums[i])
                {
                    dis[i] = Math.max(nums[i], nums[j]);
                }
            }
            // 每个位置至少还有个自己，所以最少应该是0+1
            dis[i] +=1;
            max = Math.max(max, dis[i]);
        }

        return max;
    }
}
