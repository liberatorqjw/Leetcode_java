package Leetecode.BinarySearch;

/**
 * Created by qinjiawei on 17-2-24.
 */
public class FindMinimuminRotatedSortedArray {
    /**
     * 153
     * 刚开始题目没有读懂
     * 应该是寻找一个旋转的轴心点，（最小数值） 这个轴心点可以旋转成一个递增的序列
     */

    public int findMin(int[] nums) {
        int low =0;
        int high = nums.length -1;

        //因为找的结果是个最小数值
        int ans = Integer.MAX_VALUE;

        while (low <= high)
        {
            int mid = (high -low)/2 + low;

            //存在冗余的数据，采用线性搜索， 这个就是I 和II的区别了，应对冗余元素的策略就是线程的判断。
            if (nums[low] ==nums[high])
            {
                ans = Math.min(nums[low], ans);
                low++;
                continue;
            }
            //表示这个区间是递增的,最小的就在最左边的
            if (nums[low] <= nums[high])
            {
                return Math.min(nums[low], ans);
            }
            //不是个递增的区间
            else
            {
                //再区间内再寻找到小的区间
                if (nums[mid] >= nums[low])
                {

                    low= mid+1;
                }
                else
                {
                    ans = nums[mid];
                    high = mid-1;
                }
            }
        }

        return ans;
    }
}
