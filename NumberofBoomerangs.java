package Leetecode;

import java.util.HashMap;

/**
 * Created by qinjiawei on 16-12-21.
 */
public class NumberofBoomerangs {

    /**
     * 447 在一堆点中找出 i到j 的距离等于 i 到k的距离。
     * 思路  就是从 距离相等的点中选出两个，（同时需要注意的就是 顺序） 所以数序中的排列组合应该是 An 2 = n*(n-1)
     * 所以先把距离相等的归类
     */
    public int numberOfBoomerangs(int[][] points) {

        int ans =0;


        for (int i =0; i< points.length; i++) {
            //当前点 i 到其余点的距离中找出相等的
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++)
            {
                if (i ==j)
                    continue;
//                求出各个点之间的距离
                int distance = distance(points, i, j);
                if (map.containsKey(distance))
                {
                    map.put(distance, map.get(distance) +1);
                }
                else
                    map.put(distance, 1);
            }
            //当前相等的点中找出两个满足题意的
            for (Integer value: map.values())
            {
                //数序排列组合的公式
                ans += value * (value -1);
            }
        }

        return ans;
    }
    public int distance(int[][] points, int i, int j)
    {
        int x1 = points[i][0];
        int y1 = points[i][1];

        int x2 = points[j][0];
        int y2 = points[j][1];

        return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2-y1);
    }

   public static void  main(String[] args)
   {
       int[][] points = new int[][]{{0,0},{1,0},{2,0}};
       NumberofBoomerangs n = new NumberofBoomerangs();
       n.numberOfBoomerangs(points);
   }
}
