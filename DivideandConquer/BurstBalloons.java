package Leetecode.DivideandConquer;

/**
 * Created by qinjiawei on 17-2-21.
 */
public class BurstBalloons {
    /**
     * 312 分而
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {

        int[] arrcoins = new int[nums.length +2];

        //调整原来数组的数值
        for (int i =1; i < nums.length +1; i++)
            arrcoins[i] = nums[i-1];
        //两个端点的默认数值是1
        arrcoins[0] = arrcoins[nums.length +1] = 1;

        //left right 就是表示第left到第right的节点的数据中的最小
        int dp[][] = new int[nums.length +2][nums.length +2];

        int n = nums.length +2;
        // left 与right的区间
        for (int k = 2; k < nums.length +2; k++)
        {
            for (int left =0; left < n-k; left++)
            {
               int right = left + k;
                for (int i = left +1 ; i< right; i++)
                {
                    // i 就是选择的分割点，那么分割点作为最后的 爆破的气球
                    dp[left][right] = Math.max(dp[left][right], arrcoins[left] * arrcoins[i] * arrcoins[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][n-1];
    }
}
