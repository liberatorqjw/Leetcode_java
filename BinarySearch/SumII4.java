package Leetecode.BinarySearch;

import java.util.HashMap;

/**
 * Created by qinjiawei on 17-2-23.
 */
public class SumII4 {

    /**
     * 454
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount_(int[] A, int[] B, int[] C, int[] D) {

        int ans = 0;
        for (int i =0; i < A.length; i++)
            for (int j =0; j< B.length; j++)
                for (int k =0; k< C.length; k++)
                    for (int p =0; p<D.length; p++)
                    {
                        if (A[i] + B[j] + C[k] + D[p] == 0)
                            ans++;
                    }
        return ans;
    }

    /**
     * 主要是不能4层循环，可以分成两层，把结果保存起来
     * 后两层做和判断相反数就好
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D)
    {
        int res =0;
        int len = A.length;
        if (len ==0 )
            return 0;
        HashMap<Integer, Integer> ans = new HashMap<>();
        for (int i:A)
            for (int j :B)
            {
                if (ans.containsKey(i+j))
                   ans.put(i+j,ans.get(i+j) +1);
                else
                    ans.put(i+j, 1);
            }
        for (int i:C)
            for (int j:D)
            {
                int tmp = i+j;
                if (ans.containsKey(-tmp))
                    res+= ans.get(-tmp);
            }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,2};
        int[] B = {-2,-1};
        int[] C = {-1,2};
        int[] D = {0,2};
        SumII4 s = new SumII4();
        System.out.println(s.fourSumCount(A, B,C,D));

    }
}
