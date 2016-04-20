package Leetecode;

/**
 * Created by qinjiawei on 16-4-18.
 */
//动态规划  表示i位置的最大数值 与从哪来的数值无关
public class HouseRobber {
    public int rob(int[] nums) {
        int sum =0;
        int sum1 = 0;
        int[] maxnum = new int[nums.length];
        if(nums.length ==0)
            return 0;
        else if (nums.length ==1)
            return  nums[0];

        else
        {

            maxnum[0] = nums[0];
            maxnum[1] = Math.max(nums[0], nums[1]);
            for (int i =2; i< nums.length; i++)
                maxnum[i] = Math.max(maxnum[i-2] + nums[i], maxnum[i-1]);

        }
        return maxnum[nums.length -1];
    }
}
