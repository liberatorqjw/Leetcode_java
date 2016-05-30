package Leetecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qinjiawei on 16-5-20.
 */
public class ThreeSum {
    /**
     * 3sum
     * 从数组的一端开始 找到一个目标
     * 从而把问题转化为2sums问题
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        if(nums.length < 3 || nums == null)
            return  ret;

        //排序
        Arrays.sort(nums);

        int len = nums.length;
        for (int i=0; i<len-2; i++ )
        {
            //去掉重复
            if (i>0 && nums[i] == nums[i-1])
                continue;
            findsum(nums[i], i+1, len -1, nums, ret);

        }
       return ret;
    }
    public void findsum(int target, int start, int end, int[] nums, List<List<Integer>> ret)
    {
        while(start < end)
        {
            if(nums[start] + nums[end] + target == 0)
            {
                List<Integer> item = new ArrayList<>();
                item.add(target);
                item.add(nums[start]);
                item.add(nums[end]);

                ret.add(item);
                //帮助去掉重复
                while (start < end && nums[start] == nums[start+1]) start++;
                while (start < end && nums[end] == nums[end-1]) end--;
                start++;
                end--;


            }
            else if (nums[start] + nums[end] + target < 0)
            {
                start++;
            }
            else
                end--;
        }
    }
}
