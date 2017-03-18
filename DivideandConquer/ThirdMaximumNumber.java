package Leetecode.DivideandConquer;

/**
 * Created by qinjiawei on 17-3-13.
 */
public class ThirdMaximumNumber {

    /**
     * 414 去掉重复的数字
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {

        // 一定要是long类型， 否则int的最小数值情况， 数组扫描不出来
        long fisrt = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int num: nums)
        {
            // 错位赋值
            if (num> fisrt)
            {
                third = second;
                second = fisrt;
                fisrt = num;
            }
            else if (num > second && num < fisrt)
            {
                third = second;
                second = num;
            }
            else if (num > third && num < second)
            {
                third = num;
            }

        }

        return (third == Long.MIN_VALUE||third == second)? (int)fisrt:(int)third;
    }
}
