package Leetecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qinjiawei on 16-5-26.
 */
public class SearchforaRange {

    public int[] searchRange(int[] nums, int target) {
        List<Integer> ret = new ArrayList<>();

        boolean flag = false;

        Arrays.sort(nums);

        for (int i=0; i< nums.length; i++)
        {
            if (nums[i] == target)
            {
                ret.add(i);
                flag = true;
            }
            if (flag && nums[i] != target)
                break;

        }

        int[] retnums = new int[ret.size()];

        if (!flag)
        {
            retnums = new int[2];
            retnums[0] =-1;
            retnums[1] =-1;
            return retnums;
        }
        if (ret.size() ==1)
        {
            retnums = new int[2];
            retnums[0] = ret.get(0);
            retnums[1] = ret.get(0);
            return retnums;
        }
        if (ret.size() >1)
        {
            retnums = new int[2];
            retnums[0] = ret.get(0);
            retnums[1] = ret.get(ret.size() -1);
            return retnums;
        }

        return retnums;
    }
}
