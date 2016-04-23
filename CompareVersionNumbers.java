package Leetecode;

/**
 * Created by qinjiawei on 16-4-23.
 */
public class CompareVersionNumbers {

    //按照位数比较
    public int compareVersion(String version1, String version2) {
        if(version1 == null || version2 == null)
            return 0;

        String[] nums =version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        int n1 = nums.length;
        int n2 = nums2.length;

        int i=0;

        while(i < n1 || i < n2)
        {
            // 可以处理掉 01 情况
            int x1 = i < n1 ? Integer.parseInt(nums[i]):0;
            int x2 = i < n2 ? Integer.parseInt(nums2[i]):0;
            if(x1 > x2) return 1;
            else if(x1 < x2) return -1;
            i++;

        }

        return 0;
    }
}
