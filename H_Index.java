package Leetecode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by qinjiawei on 16-11-4.
 */
public class H_Index {

    /**
     * 一个数组中有H个数字
     * 得到一个数字h,满足的条件就是 H-h的其他数字没有h大,
     * A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {

        int ret = 0;

        Arrays.sort(citations);
        for (int i =0; i< citations.length; i++)
        {
            ret = Math.max(ret, Math.min(citations.length - i, citations[i]));

        }
        return ret;
    }
}
