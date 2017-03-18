package Leetecode.BinarySearch;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by qinjiawei on 17-2-24.
 */
public class FindRightInterval {

    public class Interval {
             int start;
             int end;
             Interval() { start = 0; end = 0; }
             Interval(int s, int e) { start = s; end = e; }
         }
    /**
     * 436
     * 寻找区间内的 start 大于end 的最近的
     * @param intervals
     * @return
     */
    public int[] findRightInterval(Interval[] intervals) {

        int[] ans = new int[intervals.length];

        //红黑树，默认的排序是升序创建树
        TreeMap<Integer, Integer> tree = new TreeMap<>();

        for (int i =0; i< intervals.length; i++)
        {
            tree.put(intervals[i].start, i);
        }

        for (int i =0; i< intervals.length; i++)
        {
            //ceilingEntry(K key) 方法用来返回与该键至少大于或等于给定键，
            // 如果不存在这样的键的键 - 值映射，则返回null相关联。
            Map.Entry<Integer, Integer> tmp = tree.ceilingEntry(intervals[i].end);
            ans[i] = tmp==null?-1:tmp.getValue();
        }
        return ans;
    }

}
