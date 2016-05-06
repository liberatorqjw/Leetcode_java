package Leetecode;

/**
 * Created by qinjiawei on 16-5-4.
 */
public class ImplementstrStr {
    /*
    寻找字串存在的位置  KMP
    注意一些字符串为空的条件
     */
    public int[] getNext(String needle)
    {
        int lengh = needle.length();
        int[] next = new int[lengh];
        next[0] = -1;
        int k =-1;
        int j = 0;
        while (j < lengh-1 ) {
            if (k == -1 || needle.charAt(j) == needle.charAt(k))
            {
                k++;
                j++;
                next[j] = k;
            }
            else
                k = next[k];
        }
        return next;
    }

    public int strStr(String haystack, String needle) {

        if (haystack == null)
            return -1;
        else if(haystack.length() == 0 && needle.length()==0)
            return 0;
        else if(haystack.length() ==0 && needle.length() >0)
            return -1;
        else if ((haystack.length() >0 && needle.length()==0))
            return 0;

        int[] next = getNext(needle);
        int i = 0;
        int j =0;
        int hlength = haystack.length();
        int nlength = needle.length();

        while (i <hlength && j < nlength)
        {
            if( j ==-1 || haystack.charAt(i)== needle.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                j = next[j];
            }
        }
        if(j == nlength)
            return i -j;
        else
            return -1;
    }
}
