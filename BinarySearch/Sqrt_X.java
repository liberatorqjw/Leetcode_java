package Leetecode.BinarySearch;

/**
 * Created by qinjiawei on 17-2-28.
 */
public class Sqrt_X {

    /**
     * 69 实现对X的开平方操作
     * 思路简单但是会出现越界的问题，所在不要乘法，要除法操作。
     * @param x
     * @return
     */
    public static  int mySqrt(int x) {
        if (x<=1)
            return x;
        int left = 1;
        int right = x;
        while (left <right)
        {
            int mid = left + (right-left)/2;
            if (mid  == x/mid)
                return (int)mid;
            if (mid > x/mid)
                right = mid-1;
            else {
                left = mid+1;

            }

        }
        //返回小的一端
       return right;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2));
    }
}
