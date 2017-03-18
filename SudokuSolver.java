package Leetecode;

/**
 * Created by qinjiawei on 16-12-27.
 */
public class SudokuSolver {

    /**
     * 37 数独问题，也是个np问题
     * 可以调用模型方法，循环处理子问题
     * 对于每一个空格带入9个数字，判断是否符合定义，如果符合就继续向向着下一个格子处理。知道所有的，
     * 但是注意的是带入的格子数字每次出来的时候要处理清空
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length <9 || board[0].length < 9)
            return;
        helper(board, 0,0);
    }

    public boolean helper(char[][] booard, int i ,int j)
    {
        //由于显示横排添加，那么一行结束开始进行下一个行
        if (j >=9)
            return helper(booard, i+1,0);
        //最后一行已经结束,
        if (i==9)
            return true;
        if (booard[i][j] == '.')
        {
            for (int k =1; k<=9; k++)
            {

                booard[i][j] = (char)(k + '0');
                if (isValid(booard, i , j))
                    if( helper(booard, i, j+1))
                        return true;
                booard[i][j] = '.'; // 清空
            }
        }
        else
        {
            return helper(booard, i,j+1);
        }
        return false;
    }

    /**
     * 判断当前是否符合定义的数独规则
     * i j 这个位置上的数字是新放进去的，判断他是否符合要求
     * @param board
     * @return
     */
    public boolean isValid(char[][]board, int i , int j)
    {
        //横
        for (int k =0; k< 9; k++)
        {
            if (k != j && board[i][k] == board[i][j])
                return false;
        }
        for (int k =0; k < 9; k++)
        {
            if (k != i && board[k][j] == board[i][j])
                return false;
        }

        //区域
        for (int col = i /3 *3 ; col < i/3 * 3 +3; col++)
            for (int row = j/3*3; row < j/3*3 +3; row++)
            {
                if (col != i && row!=j && board[col][row]==board[i][j])
                    return false;
            }
        return true;
    }
}
