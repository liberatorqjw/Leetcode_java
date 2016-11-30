package Leetecode;

/**
 * Created by qinjiawei on 16-5-8.
 */
public class ReverseBits {

    /*
    把n的二进制形式 翻转然后形成一个新数字
    java
      中直接进行位操作  做和就会当成有符号的数字了

     */
    public int reverseBits( int n)
    {
        int reverse =0;
        for (int i =0; i<31; i++)
        {
            reverse = reverse | (n & 1);
            reverse = reverse<<1;
            n = n >>1;
        }
        //最后一次 reverse不应该左移动
        reverse = reverse | (n &1);
        return reverse;
    }
    public int reverseBitsErro(int n) {

        int c=0;
        int[]  bitnums = new int[32];
        int sum =0;
        int i =0;
        int len = 31;
        while (n !=0)
        {
            c = n%2;
            n /=2;
            sum += sumbits(sum, c, len);
            len--;
            bitnums[i++] = c;
        }

        System.out.println(sum);
        return sum;
    }
    public  int sumbits(int curvalue, int n, int len)
    {
        n = n << len;
        curvalue += n;
        return curvalue;
    }
}
