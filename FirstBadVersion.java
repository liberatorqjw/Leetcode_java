package Leetecode;

/**
 * Created by qinjiawei on 16-4-22.
 */
public class FirstBadVersion {

    // 二分查找
    public int firstBadVersion(int n) {
        int begin =0;
        int end =n;
        int index =0;
        while(begin < end)
       {
           //注意点  不这样就会limit time
           index = begin + (end - begin)/2;
           if(isBadVersion(index)){
               end = index;
           }
           else {
               begin = index +1;
           }
       }
        return begin;
    }

    public boolean isBadVersion(int n)
    {
        return true;
    }
}
