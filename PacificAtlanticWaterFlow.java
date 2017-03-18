package Leetecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinjiawei on 16-12-9.
 */
public class PacificAtlanticWaterFlow {
    int[] dx = new int[]{0,0,-1,1};
    int[] dy = new int[]{-1,1,0,0};

    public List<int[]> pacificAtlantic(int[][] matrix) {

        List<int[]> ans = new ArrayList<>();
        if(matrix == null || matrix.length < 1)
            return ans;

        int weight = matrix.length;  //行
        int height = matrix[0].length; //列

        int[][] p1 = new int[weight][height];
        int[][] p2 = new int[weight][height];

        for (int i=0; i< weight; i++)
        {
            flow(i, 0, p1, matrix);
            flow(i, height - 1, p2, matrix);
        }
        for (int i =0; i< height; i++)
        {
            flow(0, i, p1, matrix);
            flow(weight-1, i, p2, matrix);

        }

        for (int i =0; i< weight ;i++)
            for (int j =0; j< height; j++)
            {
                if(p1[i][j] ==1 && p2[i][j] == 1)
                {
                    int[] item = new int[2];
                    item[0] = i;
                    item[1] = j;
                    ans.add(item);
                }
            }
        return ans;
    }

    public void flow(int x, int y, int[][]p , int[][]matrix)
    {
        p[x][y] = 1;
        for (int i =0; i<4; i++)
        {
            //移动后的坐标
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >=0 && nx< p.length && ny >=0 && ny <p[0].length)
            {
                //由于要寻找的点是 流向两个海洋。所以要找的点应该比它高。
                //这里用到方向寻找的思想
                if(p[nx][ny] ==0 && matrix[nx][ny]>= matrix[x][y])
                    searchDST(nx,ny, p, matrix);
            }


        }
    }
    public void   searchDST(int x, int y, int[][] p, int[][]matrix)
    {
        if(x< 0|| x>= p.length || y<0 || y>= p[0].length)
            return ;
        if(p[x][y] == 1)
            return;
        if(p[x][y] != 1)
            p[x][y] =1;

        if(x-1 >=0)
        {
            if(matrix[x][y] >=matrix[x-1][y])
                searchDST(x-1, y, p, matrix);
        }
        if(x+1<p.length)
        {
            if(matrix[x][y] >=matrix[x+1][y])
                searchDST(x+1, y, p, matrix);
        }
        if(y-1>=0)
        {
            if(matrix[x][y] >=matrix[x][y-1])
                searchDST(x, y-1, p, matrix);
        }
        if(y+1 < p[0].length)
        {
            if(matrix[x][y] >=matrix[x][y+1])
                searchDST(x, y+1, p, matrix);
        }

    }
}
