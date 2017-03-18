package Leetecode;

/**
 * Created by qinjiawei on 16-12-20.
 */
public class SingleNumber {
    /**
     * 136
     * 本题目的大致意思是给出一个数组，数组中的元素都是出现了两次除了一个以外，
     * 那么找出这个数字
     * 思路1 循环遍历，但是肯定超时
     * 思路2 做一个hash映射
     * 思路3 o(n)的时间复杂度  异或运算因为0^a=a   a ^a =0.这就表明两个相同的元素异或后得出0唯一个不同的最终会和0进行
     * 异或运算，得出的结果也就是自己本身
     *
     */
    public int singleNumber(int[] nums) {

        int ans =0;
        for (int i =0; i< nums.length; i++)
            ans ^=nums[i];
        return ans;

    }
}
