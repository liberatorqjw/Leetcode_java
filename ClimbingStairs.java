package Leetecode;

/**
 * Created by qinjiawei on 16-4-14.
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] results = {0,1,2};
        if(n <=2)
        {
            return results[n];
        }
        return climbStairs(n-1) + climbStairs(n-2);


    }
    public int climbStairst(int n){
        int[] dp = {1,1,0};
        if(n < 2)
        {
            return 1;
        }
        for (int i=2; i<=n; i++)
        {
            dp[2] = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
}
