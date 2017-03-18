package Leetecode;

/**
 * Created by qinjiawei on 16-12-13.
 */
public class UniqueBinarySearchTrees {

    /**
     * 95  求二叉查找树的数量
     * 这类问题。类是于括号的组合数量，他们通称为卡特兰数问题
     * 卡特兰数有自己的递推公式
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if(n <1)
            return 0;
        int[] ans = new int[n+1];
        ans[0] = ans[1] = 1;

        // 用卡特兰数的递推公式
        for (int i =2; i<=n; i++)
        {
            //此时的i就是内层循环的最大n
            for (int j =0; j< i; j++)
                ans[i] += ans[j] * ans[i-j-1];
        }

        return ans[n];
    }
}
