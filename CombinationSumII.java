package Leetecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qinjiawei on 16-5-29.
 */
public class CombinationSumII {

    List<List<Integer>> ret;
    List<Integer> item;

    /**
     * 深度优先遍历 注意要去掉重复
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

       ret = new ArrayList<>();
        item = new ArrayList<>();

        Arrays.sort(candidates);
        dfsSearch(0, candidates, target, 0);
        return ret;
    }


    public void dfsSearch(int curindex, int[] candidates, int target, int sum)
    {
        if (curindex > candidates.length  || sum >target)
            return;

        if (sum == target)
        {
            ret.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = curindex; i< candidates.length; i++)
        {
            item.add(candidates[i]);
            sum += candidates[i];

            dfsSearch(i + 1, candidates, target, sum);
            sum -= candidates[i];
            item.remove(item.size() -1);
            //去掉重复项，出现了就不再取
            while (i < candidates.length-1 && candidates[i] == candidates[i+1] )
                i++;
        }

    }

}
