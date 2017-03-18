package Leetecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qinjiawei on 16-12-10.
 */
public class MinimumHeightTrees {

    /**
     * 310. Minimum Height Trees
     * 思路： 构建一颗树，寻找高度最小的根节点的个数
     * 当选择叶子节点的时候一定不符合, 因为h = h+1
     * 所以满足条件的节点只能出现在中间节点中。
     * 寻找的方法就是找到叶子节点删除，然后再找叶子节点，这样的直到最后剩下不超过两个节点为最终的答案
     *
     * 为什么不能是三个节点，可以反正如果3个节点的选择其中任何一个使得树的高度都一致，那么这三个点一定是孤立的点
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> ret = new ArrayList<>();
        if (edges.length <1 || edges == null)
        {
            ret.add(n-1);
            return ret;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indicates = new int[n];

        for (int i =0; i< n;i++)
            graph.put(i, new ArrayList<Integer>());

        for (int[] edge: edges)
        {
            //图的构建      list其实就是出度
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);

            indicates[edge[0]]++;
            indicates[edge[1]]++;

        }

        //记录一下叶子节点
        for (int i=0; i<n;i++)
        {
            //叶子节点的度应该是 1   不是0
            if(indicates[i] ==1)
                ret.add(i);
        }


        //因为最后只能剩下小于两个点满足条件
        while (n >2)
        {
            List<Integer> newleaves = new ArrayList<>();
            for (int item:ret)
            {
                //叶子节点减少一
                n--;

                //邻居节点的入读剪掉1
                for (int nb : graph.get(item))
                {
                    //邻居节点中删除这个叶子节点，因为叶子节点已经删除了
//                    graph.get(nb).remove(item);  //其实这个不删也没有关系，因为信的叶子节点已经记录了
                    //r入读减少1
                    if(--indicates[nb] == 1)
                        newleaves.add(nb);  // 新的叶子节点
                }
            }
            ret = newleaves;
        }
        return ret;


    }

    public static void main(String[] args)
    {
        int n =4;
        int[][] edges = new int[][]{{1,0},{1,2},{1,3}};
        MinimumHeightTrees m = new MinimumHeightTrees();
        m.findMinHeightTrees(n, edges);
    }



}
