package Leetecode.BinarySearch;

/**
 * Created by qinjiawei on 17-2-27.
 */
public class ArrangingCoins {

    /**
     * 441
     * 注意一个越界的问题
     * @param n
     * @return
     */
    public static int arrangeCoins_(int n) {

        if (n ==0)
            return 0;
        if (n ==1)
            return  1;
        int ans = n/2;

        while ((ans+1)*ans/2>n)
        {
            ans = ans/2;
        }

        while ((ans+1)*ans/2<n)
        {
            ans+=1;
        }
        if ((ans +1) * ans/2 == n)
            return ans;
        else if ((ans +1) * ans/2 > n)
            return ans-1;
        else return ans;
    }

    /**
     *
     * @param n
     * @return
     */
    public int arrangeCoins(int n)
    {
        if (n<=1)
            return n;
        long left =0;
        long right = n;

        while (left<=right)
        {
            long mid = (left+right)/2;
            // 递增公式的求和公式
            long sum = ((1+ mid) * mid)/2;

            if (sum<=n){
                left = mid+1;
            }else {
                right = mid-1;
            }

        }
        return (int)left-1;
    }

    public static void main(String[] args) {
//        System.out.println(arrangeCoins(1804289383));
        long ans = (60070 +1) * 60070/2;
        System.out.println(ans);
    }
}
