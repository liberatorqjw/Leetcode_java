package Leetecode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinjiawei on 17-3-15.
 */
public class N_QueensII {

    /**
     * 52 n 皇后的问题
     * 合法性的检查
     * 我们只需要检查当前行和前面行是否冲突即可。检查是否同列很简单，检查对角线就是行的差和列的差的绝对值不要相等就可以
     */
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        helper(n, 0, new int[n],ans);
        return ans;
    }

    /**
     *
     * @param n 代表目标的行数
     * @param row  当前的行
     * @param columnrow 一列的
     * @param ans  结果字符串
     */
    public void helper(int n, int row, int[] columnrow, List<List<String>> ans)
    {

        if (row == n)
        {
            List<String> item = new ArrayList<>();

            for (int j =0; j< n; j++)
            {

                StringBuilder rowans = new StringBuilder();

                for (int i =0; i< n; i++)
                {
                    if (columnrow[j] == i)
                        rowans.append("Q");
                    else
                        rowans.append(".");
                }
                item.add(rowans.toString());
            }

            ans.add(item);
            return;
        }

        for (int i =0; i< n; i++)
        {
            columnrow[row] = i;
            //当前行满足条件就进行下一行
            if (checkValid(row, columnrow))
            {
                helper(n, row+1, columnrow, ans);
            }
        }
    }

    /**
     *
     * @param row
     * @param columnrow
     * @return
     */
    public boolean checkValid(int row, int[] columnrow)
    {
        for (int i =0; i < row; i++)
        {
            // 统一列   或对角线相同则不能满足条件              列差                               行差
            if (columnrow[row] == columnrow[i] || Math.abs(columnrow[row] - columnrow[i]) == row-i)
            {
                return false;
            }
        }
        return true;
    }
}
