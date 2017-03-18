package Leetecode.BinarySearch;

/**
 * Created by qinjiawei on 17-3-1.
 */
public class SmallestGoodBase {

    /**
     * 483  输入一个数字num 找到一个进制base 使得该数再base进制下的每一个位置都是1
     * 通过目标结果开始寻找 base的结果, 因为目标是固定的就是k个1 而且k的范围是固定的
     * @param n
     * @return
     */
    public String smallestGoodBase(String n) {

        long num = Long.valueOf(n);
        //k = logm(n) = (long) (pow(n, 1/m)) = (long) (log(n) / log(m))
        // 最长的k就应该是 log2(num)
        for (int m = Math.min((int)(Math.pow(num, 0.5)), 64); m>1; m--)
        {
            // m表示1 的长度 k 表示求出的基底
            // 注意pow后面的数字一定要是小数，要不然会出现 doble到long的缺失
            long k = (long) Math.pow(num, 1.0/m);
            if (isGoodBase(num, k, m))
                return String.valueOf(k);

        }
        return String.valueOf(num -1);
    }

    /**
     * base 为进制的数字 m长度的1 的数字，表示的数字是否和 num相等
     * base 是基底 数字
     * @param num 整体要求完的目标数
     * @param base
     * @param m  m是表示1 的长度
     * @return
     */
    boolean isGoodBase(long num, long base, int m)
    {
        long sum = num;
        long val = 1;
        for (int i =0; i<=m; i++)
        {
            sum -=val;
            val *= base;
        }
        return sum == 0;
    }
}
