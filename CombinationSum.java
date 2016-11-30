package Leetecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qinjiawei on 16-5-27.
 */
public class CombinationSum {

    List<List<Integer>> ret ;
    List<Integer> item ;

    /**
     * 深度优先遍历问题，但是这里存在的问题是，深度优先遍历的是要有回退的
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ret = new ArrayList<>();
        item = new ArrayList<>();
        Arrays.sort(candidates);
        dfs_search(target, candidates, 0, 0);
        return ret;
    }

    public void dfs_search(int target, int[] candidates, int sum, int i)
    {
        if (i > candidates.length-1 || i <0 || sum >target)
            return;
        if (sum  == target)
        {
            //item的对象不变，但是赋值到list的要是个新对象
            ret.add(new ArrayList<Integer>(item));

            return;
        }
        //把所有可能都循环遍历一遍
        for (int j = i; j < candidates.length; j++)
        {
            item.add(candidates[j]);
            sum += candidates[j];
            dfs_search(target, candidates, sum, j);
            sum -= candidates[j];
            if (item.size() >0)
            item.remove(item.size()-1);
        }

    }

}
