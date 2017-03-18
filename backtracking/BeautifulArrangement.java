package Leetecode.backtracking;

/**
 * Created by qinjiawei on 17-3-3.
 */
public class BeautifulArrangement {

    /**
     * 526  找到一个序列，判断这个序列的每个位置i上的数字n 是不是都满足（i 整除n 或者n整除i）
     * @param N
     * @return
     */
    int ans =0;

    public int countArrangement(int N) {

        boolean[] visit = new boolean[N+1];
        dfs(N, visit);
        return ans;
    }

    public void dfs(int n, boolean[] visit)
    {
        // 遍历到了i那么就表示这个序列是满足条件的 n 表示下标
        if (n == 1)
        {
            ans++;
            return;
        }

        // i就表示下次从第几个开始的下标序列
        for (int i =1; i< visit.length; i++)
        {
            if(visit[i] == false && (i%n == 0 || n%i ==0))
            {
                visit[i] = true;
                // n-1 表示当前的数字减少了1 即当前下标减少了1
                dfs(n -1, visit);
                visit[i] = false;
            }
        }

    }
}
