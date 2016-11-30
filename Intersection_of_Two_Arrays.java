package Leetecode;

import org.w3c.dom.ls.LSException;

import java.util.*;

/**
 * Created by qinjiawei on 16-10-31.
 */
public class Intersection_of_Two_Arrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> result = new ArrayList<>();
        HashSet<Integer> ret = new HashSet<>();
        for (int i =0;i< nums1.length; i++)
        {
            if (result.contains(nums1[i]))
                continue;
            result.add(nums1[i]);
        }
        for (int i = 0; i< nums2.length;i++)
        {
            if (result.contains(nums2[i]))
                ret.add(nums2[i]);
        }
        int[] num = new int[ret.size()];
        Iterator<Integer> t = ret.iterator();
        int i =0;
        while (t.hasNext())
            num[i++] = t.next();
        return  num;
    }
}
