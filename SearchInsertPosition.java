package Leetecode;

/**
 * Created by qinjiawei on 16-5-27.
 */
public class SearchInsertPosition {

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int begin = 0;
        int end = nums.length;
        int curindex = (begin + end) /2;

        if (nums == null)
            return 0;
        else if (nums.length ==1)
        {

            if (nums[0] < target)
                return 1;
            else
                return 0;
        }
        while (begin < end)
        {
            if (nums[curindex] == target)
            {
                return curindex;
            }
            else if(nums[curindex] <target)
            {
                begin = curindex +1;
                curindex = (begin + end)/2;
            }
            else
            {
                end = curindex -1;
                curindex = (begin + end)/2;
            }
        }

        if (curindex >nums.length-1)
            return curindex;
        if (nums[curindex] < target)
        return curindex +1;
        else
            return curindex;
    }
}
