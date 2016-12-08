package Leetecode;

/**
 * Created by qinjiawei on 16-12-7.
 */
public class PerfectSquares {

    /**
     * 279
     * 动态规划完
     * 由于题目要求的就是 x = a + b *b 的最小个数, 那么就是求出a 的最小平方和个数加上 1
     */
    public int numSquares(int n) {

        int[] nums = new int[n+1];
        for (int i=0; i<= n; i++)
            nums[i] = 99999;
        for (int i = 0; i*i<= n ; i++)
        {
            nums[i*i] = 1;

        }

        //先去找到一个a
        for (int a=0; a<=n; a++) {
            // 然后再去找到一个b
            for (int b = 0; b * b + a <=n; b++)
            {
                //也许 nums[a] + 1 可能比nums[a + b*b] 还要小
                nums[a + b*b] = Math.min(nums[a] +1, nums[a + b*b]);
            }
        }
        return  nums[n];
    }
}
