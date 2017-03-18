package Leetecode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qinjiawei on 17-1-4.
 */
public class MaxPointsOnaLine {

    /**
     * 149
     * 求出共线的最多点
     * 思路1  刚开始题意理解错误，只考虑了横线和竖线
     * 思路2  要用斜率这个概念，斜率相同必然是在一条直线上的
     */

    public int maxPoints(Point[] points)
    {

        Map<Double, Integer> map = new HashMap<>();
        int max = 0;
        for (int i =0; i< points.length; i++)
        {
            map.clear();
            int ide = 1; //重合点的个数
            for (int j =0; j< points.length; j++)
            {
                double slap = 0.0;
                if (i ==j)
                    continue;
                else if (points[i].x == points[j].x && points[i].y == points[j].y)
                {
                    ide++;
                    continue;
                }
                else if (points[i].x == points[j].x)
                {
                    slap = Integer.MAX_VALUE;

                }
                else
                {
                    slap = (points[j].y - points[i].y)/(points[j].x - points[i].x);
                }
                map.put(slap, map.containsKey(slap)?map.get(slap)+1:1);
            }

            if (map.keySet().size() ==0)
                max = ide >max?ide:max;
            else
            {
                for (double key : map.keySet())
                {
                    max = Math.max(ide + map.get(key), max);
                }
            }
        }
        return max;
    }
}
