package Leetecode.BinarySearch;

import java.util.Arrays;

/**
 * Created by qinjiawei on 17-2-28.
 */
public class Heaters {
    /**
     * 475
     *  排序寻找每个屋子的最小半径，但是这个时候还有个问题就是，全局的最小的最大才是整体的最小。
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {

        // 考虑到可能是乱序的问题
        Arrays.sort(heaters);
        Arrays.sort(houses);

        int ans = 0;
        int ret = 0;
        int j;
        for (int i =0; i< houses.length; i++)
        {
            j =0;
            // 寻找房子i旁边的 火炉，所以就是找到刚好大于i的那个j的位置
            while (j < heaters.length && heaters[j]< houses[i])
            {
                j++;
            }
            // 表示房子i的右边没有加热器
            if (j == heaters.length)
            {
                ret = houses[i] - heaters[j-1];
            }
            // 房子没有加热气
            else if (j == 0)
            {
                ret = heaters[j] - houses[i];
            }
            else if (heaters[j] > houses[i])
            {
                ret = Math.min(heaters[j] - houses[i], houses[i] - heaters[j-1]);
            }
            ans = Math.max(ret, ans);
        }
        return ans;

    }
}
