package Leetecode;

/**
 * Created by qinjiawei on 16-5-26.
 */
public class NextPermutation {

    /**
     * 字典序列的全排问题
     * 思想是从后向前寻找，找到一个升序的位置，然后把最后面的最小数值向前移动
     * 再把后面的降序改成升序
     * @param nums
     */
    public void nextPermutation(int[] nums) {

        int pos = -1;

        //找到一个升序的位置
        for (int i = nums.length-1; i>0; i--)
        {
            if (nums[i] > nums[i-1])
            {
                pos = i-1;
                break;
            }
        }

        if (pos == -1)
        {
            reverse(nums, 0, nums.length-1);
            return;
        }

        //找到一个大于pos位置的数值
        for (int i = nums.length -1 ; i>pos; i--)
        {
            //交换数值
            if (nums[i] > nums[pos])
            {
                int tmp = nums[pos];
                nums[pos] = nums[i];
                nums[i] = tmp;
                break;
            }
        }
        //将pos后面的数值 按照从小到的顺序
        reverse(nums, pos+1, nums.length-1);
    }
    public  void reverse(int[] nums, int start, int end)
    {
        while (start < end)
        {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;

            end--;
            start++;
        }
    }
}
