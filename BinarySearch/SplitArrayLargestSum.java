package Leetecode.BinarySearch;

import Leetecode.Majority_Element;

/**
 * Created by qinjiawei on 17-2-28.
 */
public class SplitArrayLargestSum {

    /**
     * 410 题目意思是  分成连续的m个数组，使得m个数组的最大和变得最小
     * 我们首先来分析，如果m和数组nums的个数相等，那么每个数组都是一个子数组，所以返回nums中最大的数字即可，
     * 如果m为1，那么整个nums数组就是一个子数组，返回nums所有数字之和，所以对于其他有效的m值，
     * 返回的值必定在上面两个值之间，所以我们可以用二分搜索法来做。
     * 我们用一个例子来分析
     * ，nums = [1, 2, 3, 4, 5], m = 3，我们将left设为数组中的最大值5，right设为数字之和15，
     * 然后我们算出中间数为10，我们接下来要做的是找出和最大且小于等于10的子数组的个数，[1, 2, 3, 4], [5]，
     * 可以看到我们无法分为3组，说明mid偏大，所以我们让right=mid，然后我们再次进行二分查找哦啊，
     * 算出mid=7，再次找出和最大且小于等于7的子数组的个数，[1,2,3], [4], [5]，我们成功的找出了三组，
     * 说明mid还可以进一步降低，我们让right=mid，然后我们再次进行二分查找哦啊，算出mid=6，
     * 再次找出和最大且小于等于6的子数组的个数，[1,2,3], [4], [5]，我们成功的找出了三组，
     * 我们尝试着继续降低mid，我们让right=mid，然后我们再次进行二分查找哦啊，算出mid=5，
     * 再次找出和最大且小于等于5的子数组的个数，[1,2], [3], [4], [5]，发现有4组，此时我们的mid太小了，
     * 应该增大mid，我们让left=mid+1，此时left=6，right=5，循环退出了，我们返回left即可
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        long left =0;
        long right =0;

        for (int i =0; i< nums.length; i++)
        {
            left = Math.max(nums[i], left);
            right += nums[i];
        }

        // 取出最大数值和最小数值的中间值， 然后判断这个数组，能分分割出m个并且数值上满足这个条件
        while (left <right)
        {
            long mid = (left + right)/2;
            if (iscan_split(nums, m, mid))
                right = mid; // 由于不是坐标，所以不能加1 或者减1 操作
            else

                left = mid+1;

        }
        return (int)left;
    }

    public boolean iscan_split(int[] nums, int m, long sum)
    {
        int cnt =1;  //分割数量
        int cursum =0; // 当前数组最大

        for (int i =0; i< nums.length; i++)
        {
            cursum += nums[i];
            // 一定是大于的时候 因为等于是判断可以相等的
            if (cursum > sum)
            {
                //由于做和超了,那么就需要当前作为
                cursum = nums[i];
                cnt++;
                if (cnt>m)
                    return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{7,2,5,10,8};
        SplitArrayLargestSum s = new SplitArrayLargestSum();
        System.out.println(s.splitArray(nums, 2));
    }
}
