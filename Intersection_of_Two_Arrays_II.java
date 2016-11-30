package Leetecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 两个数组的交集， 而且对重复出现的不去进行过滤操作
 * Created by qinjiawei on 16-11-1.
 */
public class Intersection_of_Two_Arrays_II {

    public int[] intersectBack(int[] nums1, int[] nums2) {

        List<Integer> tmp = new ArrayList<>();
        List<Integer> ret =  new ArrayList<>();

        for (int i =0 ; i< nums1.length; i++)
        {
            tmp.add(nums1[i]);
        }

        for (int i = 0 ; i< nums2.length; i++)
        {
            if (tmp.contains(nums2[i]))
            {
                ret.add(nums2[i]);
                int index = ret.indexOf(nums2[i]);
//                if (index > 0)
//                    index--;

            }
        }

        int[] retnum  = new int[ret.size()];
        for (int i =0; i< ret.size(); i++)
        {
            retnum[i] = ret.get(i);
        }
        return retnum;
    }

    /**
     * 用hash表存储原来的第一个数组的数量，遍历第二个去第一个表中取出来，
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2)
    {
        HashMap<Integer, AtomicInteger> map = new HashMap<>();
        List<Integer> ret = new ArrayList<>();
        for (int i:nums1)
        {
            if (map.containsKey(i))
                map.get(i).incrementAndGet();
            else
                map.put(i,new AtomicInteger(1));
        }

        for (int i : nums2)
        {
            if (map.containsKey(i))
            {
                if (map.get(i).get() >0) {
                    ret.add(i);
                    map.get(i).decrementAndGet();
                }
            }
        }
        int[] retnum  = new int[ret.size()];
        for (int i =0; i< ret.size(); i++)
        {
            retnum[i] = ret.get(i);
        }
        return retnum;
    }

    public static void main(String[] args)
    {
        int[] num1 = {9,1};
        int[] num2 = {9,1,7,8,3,9,0,0,9,1,5};
        Intersection_of_Two_Arrays_II in = new Intersection_of_Two_Arrays_II();
       System.out.println(in.intersect(num1, num2).length);
    }
}
