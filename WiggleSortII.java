package Leetecode;

import java.util.Arrays;

/**
 * Created by qinjiawei on 16-11-3.
 */
public class WiggleSortII {

    /**
     * 324 题 摆动排序
     *
     */



    /**
     * 先排序再交叉互相换
     * @param nums
     */
        public void wiggleSort(int[] nums) {
            // 先将数组排序
            Arrays.sort(nums);
            int i = nums.length/2 -1;
            int j = nums.length/2;
            // 将数组中一对一对交换
            int tmp = 0;
            while (i >0)
            {
                if (i%2==0)
                {
                    if (nums[i] >nums[j])
                    {
                        tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                    }
                }
                else
                {
                    if (nums[i] < nums[j])
                    {
                        tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                    }
                }
                i--;
                j++;
            }
        }

    /**
     * 先排好序列,然后牺牲空间
     * @param nums
     */
    public void wiggle(int[] nums)
    {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = (n-1)/2;
        int index = 0;
        int[] tmp = new int[n];
        for (int i =0; i<=mid; i++)
        {
            tmp[index] = nums[mid-i];
            if(index +1 < n)
            {
                tmp[index +1] = nums[n-1-i];
            }
            index +=2;
        }
        System.arraycopy(tmp, 0, nums, 0 ,n);
    }
    public static void main(String[] args)
    {
        int[] nums = {1,1,1,4,5,6};
        WiggleSortII w = new WiggleSortII();
        w.wiggleSort(nums);
    }


}
