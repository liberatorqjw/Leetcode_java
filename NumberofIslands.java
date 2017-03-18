package Leetecode;

/**
 * Created by qinjiawei on 16-12-8.
 */
public class NumberofIslands {

    /**
     * 200. 求连续的一块数
     * 找到一个1 以后就去找相邻的1 然后把它都变成0
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        int count = 0;
        if (grid == null || grid.length <1)
            return count;

        int weight = grid.length;
        int height = grid[0].length;

        for (int i =0; i< weight; i++)
        {
            for (int  j = 0 ; j < height; j++)
            {

                if(grid[i][j] == '0')
                    continue;
               if(grid[i][j] == '1') {
                   searchLand(grid, i, j);
                   count++;
               }
            }
        }

        return count;
    }

    /**
     * b把周围的1 全部变成0
     * @param grid
     * @param w
     * @param h
     */
    public void  searchLand(char[][] grid, int w, int h)
    {
        if(w<0 || w >= grid.length || h<0 || h>=grid[0].length || grid[w][h] != '1')
            return;
        grid[w][h] = '0';
        searchLand(grid, w-1, h);
        searchLand(grid, w+1, h);
        searchLand(grid, w, h-1);
        searchLand(grid, w, h+1);

    }
    public boolean isIand(char[][] grid, int w, int h, int weight, int height)
    {
        boolean w1 = false;
        boolean w2 = false;
        boolean h1 = false;
        boolean h2 = false;

        if(w - 1 < 0)
            w1 = true;
        else if(grid[w-1][h] == '1')
            w1 = false;
        else if(grid[w-1][h] == '0')
            w1 = true;

        if(w+1 >=weight)
            w2 = true;
        else if(grid[w+1][h] == '1')
            w2 = false;
        else if(grid[w+1][h] == '0')
            w2 = true;

        if(h  - 1 < 0)
            h1 = true;
        else if(grid[w][h-1] == '1')
            h1 = false;
        else if(grid[w][h-1] == '0')
            h1 = true;

        if(h  + 1 >= height)
            h2 = true;
        else if(grid[w][h+1] == '1')
            h2 = false;
        else if(grid[w][h+1] == '0')
            h2 = true;

        if(w1 && w2 && h1 && h2)
            return true;
        else
            return false;

    }

}
