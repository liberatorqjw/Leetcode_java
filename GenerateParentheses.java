package Leetecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinjiawei on 16-5-24.
 */
public class GenerateParentheses {

    /**
     * 卡特兰数字问题
     * 由于要遍历所有结果，想到深度优先比遍历
     * 但是情况是括号的匹配问题, 剩余的左括号多余右括号的话,那么就不能打印右边括号,否者可以打印右边括号
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        generateDepth(n, n, "", result);
        return  result;
    }

    public void generateDepth(int leftnum, int righrnum, String s, List<String> ret)
    {
        if(leftnum ==0 && righrnum==0)
            ret.add(s);
        if (leftnum >0)
            generateDepth(leftnum - 1, righrnum, s + "(", ret);
        if (righrnum >0 && leftnum < righrnum)
            generateDepth(leftnum, righrnum-1, s + ")", ret);

    }

}
