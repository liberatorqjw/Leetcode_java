package Leetecode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qinjiawei on 16-5-13.
 */
public class ValidSudoku {

    /*
    最笨的方法是依次判断
    最简单的是一个二成循环
    board[i][j] 在 i j 位置的数值 所在的小的九宫格就是 i/3 *3 + j/3
     */
    public boolean isValidSudoku(char[][] board) {

        // 申请 10个这么大是因为  方法是判断数值1 -9 是不是存在 则要10个这么大否则9没空间存储
        int[][] cell = new int[10][10];

        //一共9个小的9宫格
        int[][] subboard = new int[10][10];

        for(int i =0 ; i< 9; i++)
        {
            int[] row = new int[10];
            for (int j =0; j<9 ; j++)
            {
                if (board[i][j] == '.')
                    continue;
                if (isNIne(row, board[i][j] - '0') || isNIne(cell[j], board[i][j] - '0')
                        || isNIne(subboard[i/3 * 3 + j/3], board[i][j] - '0'))
                    return false;
            }
        }
        return true;
    }

    public boolean isNIne(int[] board, int val)
    {
        if (board[val] ==1 )
            return true;
        else
            board[val] = 1;
        return false;
    }

}
