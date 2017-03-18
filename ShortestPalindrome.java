package Leetecode;

/**
 * Created by qinjiawei on 17-2-16.
 */
public class ShortestPalindrome {

    /**
     * 214 最短的回文字串
     * 其实就是找到带上 s串的前半部分的最长的回文串,这样只需要在 s串的钱的前半部分加上一些字符串，就可以构成整体的回文字串了
     * @param s
     * @return
     */
    /**
     * 这个方法会出现超时的现象，所以需要进行优化处理
     * @param s
     * @return
     */
    public String shortestPalindrome_(String s) {

        int i =0;
        int start = 0;
        int end = s.length()-1;
        int j = end;

        while (i<j)
        {
            if (s.charAt(i) == s.charAt(j))
            {
                i++;
                j--;
            }
            else
            {
                i=0;
                end--;
                j = end;
            }
        }

        return new StringBuilder(s.substring(end+1)).reverse().toString() + s;

    }

    /**
     * 优化后的方法
     * 求公共的前缀后缀的方法，那么就可以直接想到kmp算法
     *
     */
    public String shortestPalindrome(String s)
    {
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().toString().substring(0, s.length()- getCommonLength(s)) + s;

    }

    /**
     * 计算公共前缀和后缀的长度
     * @param str
     * @return
     */
    public int getCommonLength(String str)
    {
        StringBuilder builder = new StringBuilder(str);
        String rev = new StringBuilder(str).reverse().toString();
        // 拼接形成一个新的字符串
        builder.append("#").append(rev);

        //kmp的next数组
        int[] p = new int[builder.length()];

        //（p即next数组，其中p[k]表示从0到k位置为止公共前缀后缀的长度，
        // 例如：abacaba，公共前缀后缀长度是3，
        // 当p[k]=m则表示s.substring(0,m)和s.substring(k-m+1,k+1)是相等的）
        for (int i =1; i< p.length; i++)
        {
            //j 表示长度
            int j = p[i-1];

            //依次当不相等的时候求得次长度的位置
            while (j >0 && builder.charAt(i) != builder.charAt(j))
                j = p[j-1];

            //重新更新长度位置      当原来是0的时候相等是 1
            p[i] = j==0?(builder.charAt(i) == builder.charAt(0) ? 1:0) : j+1;
        }
        return p[p.length-1];
    }

}
