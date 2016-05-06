package Leetecode;

/**
 * Created by qinjiawei on 16-5-4.
 */public class NumArray {

    /*
    把耗时的操作放在  初始化中， 构造函数中
     */
    private int[] Snums;

    public NumArray(int[] nums) {


        Snums = new int[nums.length];
        if(nums.length != 0) {
            Snums[0] = nums[0];
            for (int k = 1; k < nums.length; k++)
                Snums[k] = Snums[k - 1] + nums[k];
        }
    }

    public int sumRange(int i, int j) {

        if(Snums.length ==0)
            return 0;
        if(i==0)
            return Snums[j];
        else
        return Snums[j] - Snums[i-1];
    }

    public static void main(String[] args)
    {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(2,5));
        System.out.println(numArray.sumRange(0,5));

    }
}
