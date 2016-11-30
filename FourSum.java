package Leetecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qinjiawei on 16-5-23.
 */
public class FourSum {
    /**
     * 4Sum
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ret = new ArrayList<>();

        Arrays.sort(nums);

        int l =0;
        int r =0;
        int len = nums.length;
        for (int i = 0; i < len -3; i++)
        {
            //去掉重复
            if (i >0 && nums[i] == nums[i-1])
                continue;
            for (int j =i+1; j< len-2; j++)
            {
                //去掉重复, 注意j的范围的选择
                if(j > i+1 &&nums[j] == nums[j-1])
                    continue;
                l = j+1;
                r = len-1;

                while (l <r)
                {
                    if(nums[i] + nums[j] + nums[l] + nums[r] == target)
                    {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[l]);
                        item.add(nums[r]);
                        /*
                        判断条件的前后也对循环有影响
                         */
                        while ( l<r && nums[l] == nums[l+1]  )
                            l++;
                        while (l <r && nums[r] == nums[r-1] )
                            r--;

                        l++;
                        r--;
                        ret.add(item);
                    }
                    else if ((nums[i] + nums[j] + nums[l] + nums[r]) < target)
                        l++;
                    else
                        r--;

                }
            }
        }

        return ret;
    }
}
