package Leetecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinjiawei on 16-4-21.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows ==0)
            return res;
        List<Integer> tmp = new ArrayList();
        tmp.add(1);
        res.add(tmp);
        if(numRows ==1)
            return res;
        for(int i=1; i<numRows; i++)
        {
            List<Integer> item = new ArrayList<>();
            for (int j=0; j<i+1; j++)
            {
                int pre=0;
                int fro =0;
                if (j==0)
                    item.add(1);
                else if (j==i)
                    item.add(1);
                else {
                    pre = res.get(i-1).get(j-1);
                    fro = res.get(i-1).get(j);
                    item.add(pre+fro);
                }
            }
            res.add(item);
        }
        return res;

    }
}
