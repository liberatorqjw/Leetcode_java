package Leetecode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by qinjiawei on 16-11-8.
 */
public class LargestNumber {

    /**
     * 数组中的数字组合成最大的数字
     * 思路就是比较的时候,采用相同位数的比较, 5 与34  比较,那我用55与34比较
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {

        int n = nums.length;
        if(n<1) return "";

        String[] str = new String[n];
        for (int i =0; i< nums.length; i++)
        {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, new Cmp());

        String ret = "";
        for(int i= n-1; i>=0; i--)
        {
            ret = ret.concat(str[i]);
        }

        //去掉0
        int i =0;
        while(i<n && ret.charAt(i)=='0')
        {
            i++;
        }
        if(i==0)
            return "0";
        return ret.substring(i);
    }

}
//递增
class Cmp implements Comparator<String>{

    @Override
    public int compare(String a, String b) {
        String ab = a.concat(b);
        String ba = b.concat(a);
        return ab.compareTo(ba);
    }
}