package Leetecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinjiawei on 16-12-8.
 */
public class PacificAtlanticWaterFlowII {
    /**
     * 417  广度优先遍历
     *
     */

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
            searchDST(i, 0, p1,matrix);
            searchDST(i, height-1,p2,matrix);
        }
        for (int i =0; i< height; i++)
        {
            searchDST(0, i, p1,matrix);
            searchDST(weight-1, i, p2, matrix);

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

    public void  searchDST(int x, int y, int[][] p, int[][]matrix)
    {
        if(x< 0|| x>= p.length || y<0 || y>= p[0].length)
            return;
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
    public static void main(String[] args)
    {
        int[][] a = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        int[][] p = new int[3][3];

        System.out.println(a.length);
        System.out.println(a[0].length);
        System.out.println(p[0][0]);

        PacificAtlanticWaterFlowII pa = new PacificAtlanticWaterFlowII();
//        System.out.println(pa.pacificAtlantic(a));
    }

}
