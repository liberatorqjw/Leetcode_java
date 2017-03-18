package Leetecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qinjiawei on 16-12-11.
 */
public class SurroundedRegions {

    /**
     * 130
     * 题目的意思是把所有  被包围的 'o'字符转换成 'x'
     * 然后使用
     * @param board
     */
    public void solve(char[][] board) {

        if (board == null || board.length < 1)
            return;

        int weight = board.length;
        int height = board[0].length;



        //行
        for (int i = 0; i < weight; i++) {

            if(board[i][0] == 'O')
//            construct(i, 0, board);
            bfs(board, i, 0);

        }


        //列
        for (int i = 0; i < height; i++)
        {
            if(board[0][i] == 'O')
//            construct(0, i , board);
            bfs(board, 0, i);


        }
        for (int i = 0; i< weight; i++)
        {
            if(board[i][height -1] == 'O')
//                construct(i, height-1, board);
            bfs(board, i , height -1);
        }

        for (int i = 0; i< height; i++)
        {
            if(board[weight-1][i] == 'O')
//                construct(weight-1, i , board);
              bfs(board, weight -1, i);
        }

//        for (int i =0; i< weight; i++)
//            for (int j =0; j< height; j++)
//            {
//                if (p[i][j] == 1)
//                    board[i][j] = 'O';
//                else
//                    board[i][j] = 'X';
//            }
        for (int i =0; i< weight; i++)
            for (int j =0; j< height; j++)
            {
                if (board[i][j] == 'W')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }


    }

    /**
     * 深度优先遍历出现了 内存溢出
     * @param x
     * @param y
     * @param board
     */
    public void construct(int x, int y, char[][] board)
    {
        if(x < 0|| x>= board.length || y<0 || y>=board[0].length || board[x][y] != 'O' || board[x][y] == 'X')
            return;
        board[x][y] = 'W';

        construct(x-1,y , board);

        construct(x+1,y, board);

        construct(x,y-1 , board);

        construct(x,y+1 , board);

    }

    public void bfs(char[][] board, int x, int y)
    {
        int m = board.length;
        int n = board[0].length;

        int index = x * n + y;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        board[x][y] = 'W';

        while (!queue.isEmpty()){
            int top = queue.poll();
            int i = top /n;
            int j = top %n;

            if(i-1 >=0 && board[i-1][j] == 'O') {
                board[i-1][j] = 'W';
                queue.offer((i - 1) * n + j);
            }
                if(i+1 <m && board[i+1][j] == 'O') {
                    board[i+1][j] = 'W';
                    queue.offer((i + 1) * n + j);
                }
            if(j-1 >=0 && board[i][j-1] == 'O') {
                board[i][j-1] = 'W';
                queue.offer(i * n + j - 1);
            }
            if(j+1 <n && board[i][j+1] == 'O') {
                board[i][j+1] = 'W';
                queue.offer(i * n + j + 1);
            }

        }
    }
    public static void  main(String[] args)
    {
        char[][] board = new char[4][4];
        board[0][0] = 'O';
        board[0][1] = 'O';
        board[0][2] = 'O';
        board[0][3] = 'O';


        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(board);
    }
}
