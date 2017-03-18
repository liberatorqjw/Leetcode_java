package Leetecode;

/**
 * Created by qinjiawei on 16-12-19.
 */
public class IslandPerimeter {
    /**
     * 463
     * 1. 思路1 深度广度优先遍历，是土地就查看四周是不是水或则边界--这样的结果加1.
     *    刚开始的思路是想着深度优先遍历，其实不用直接一个个的找下去就好了
     */
    public int islandPerimeter(int[][] grid) {

        if(grid.length <1)
            return 0;

        int ans =0;

        int width = grid.length;
        int length = grid[0].length;
        int[] wd = new int[]{0,0,1,-1};
        int[] hd = new int[]{1,-1,0,0};

        for (int i =0; i< width; i++)
            for (int j =0; j< length; j++)
            {
                //是陆地
                if (grid[i][j] == 1)
                {
                    for (int k =0 ;k<4;k++)
                    {
                        int widex = i +wd[k];
                        int hidex = j + hd[k];
                        if (widex< 0 || widex>=width ||hidex <0 || hidex>=length || grid[widex][hidex] == 0)
                            ans++;
                    }
                }
            }
        return ans;
    }
}
