package Leetecode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by qinjiawei on 17-3-3.
 */
public class BinaryWatch {

    /**
     * 401 二进制的手表
     * @param num
     * @return
     */
    public static List<String> readBinaryWatch(int num) {

        List<String> list = new ArrayList<>();

        int[] hours = new int[]{1,2,4,8};
        boolean[] hvisited = new boolean[hours.length];

        int[] mins = new int[]{1,2,4,8,16,32};
        boolean[] visited = new boolean[mins.length];

        HashSet<String> hashset = new HashSet<>();
        collect(list, hours, 0, 0,0,hvisited,mins, 0,0,0, visited, num,hashset);

        return list;
    }

    public static void collect(List<String> list, int[] hours, int hidex, int hnum, int hcount, boolean[] hvisted,
                        int[] mins, int mindex, int mnum, int mcount, boolean[] mvisied, int num, HashSet<String> hashSet)
    {
        if (hcount + mcount == num)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(hnum ==0 ?"0:":hnum +":");
            sb.append(mnum ==0 ? "00" : mnum >=10 ? mnum:"0"+mnum);
            String tmmp = sb.toString();

            if (!hashSet.contains(tmmp) && hnum <=11 && mnum <=59)
            {
                // 去掉重复
                hashSet.add(tmmp);
                list.add(tmmp);

            }
            return;

        }

        for (int i = hidex; i< hours.length; i++)
        {
            for (int j = mindex; j < mins.length; j++)
            {
                if(!hvisted[i])
                {
                    hvisted[i] = true;
                    hnum += hours[i];
                    hcount++;
                    if (hcount + mcount <= num)
                    {
                        collect(list, hours, hidex, hnum, hcount, hvisted, mins, mindex, mnum, mcount, mvisied, num, hashSet);
                    }
                    hcount--;
                    hnum -= hours[i];
                    hvisted[i] = false;
                }
                if (!mvisied[j])
                {
                    mvisied[j] = true;
                    mnum += mins[j];
                    mcount++;
                    if (hcount + mcount <= num)
                    {
                        collect(list, hours, hidex, hnum, hcount, hvisted, mins, mindex, mnum, mcount, mvisied, num, hashSet);
                    }
                    mvisied[j] = false;
                    mnum -= mins[j];
                    mcount--;
                }
            }
        }
    }

    /**
     * 巧妙的用到了------bitCount方法返回指定int值的二进制补码表示形式的1位的数量。
     * @param num
     * @return
     */
    public  List<String> readBinaryWatch_(int num) {

        List<String> list = new ArrayList<>();

        for ( int i =0; i< 12; i++)
        {
            for ( int j =0; j <60; j++)
            {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num)
                    list.add(String.format("%d:%02d", i,j));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int num = 0;
        readBinaryWatch(0);
    }
}
