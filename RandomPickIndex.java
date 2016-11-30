package Leetecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by qinjiawei on 16-10-22.
 */
public class RandomPickIndex {

    int[] nums = null;
    public RandomPickIndex(int[] nums)
    {
        this.nums=nums;

    }

    public int pick(int target)
    {
        int len = nums.length;
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i< len; i++)
        {
            if (nums[i] == target)
                index.add(i);
        }
//        System.out.println(Math.random() * len);
        //c语言中rand（）函数产生的随机数返回是0-32767（rand_max），所以设定这个数更有随机性
        int rd = (int) (Math.random() * 32767 % index.size());

        Random random = new Random();
        return index.get(rd);
//        return 0;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,2,3,3,3,3};
        RandomPickIndex randomPickIndex = new RandomPickIndex(nums);
        for (int i = 0; i<40;i++)
            System.out.println(randomPickIndex.pick(3));
    }
}
