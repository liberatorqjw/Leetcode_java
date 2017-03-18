package Leetecode.DivideandConquer;

import Leetecode.IntegertoEnglishWords;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinjiawei on 17-2-22.
 */
public class DifferentWaystoAddParentheses {

    /**
     * 241 递归的思想  大的问题分成小的问题
     * 加括号的思路不就是转换成先计算哪个的问题吗
     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute(String input) {

        List<Integer> ans = new ArrayList<>();

        for (int i =0; i< input.length(); i++)
        {
            if (input.charAt(i) == '+' || input.charAt(i)== '*' || input.charAt(i) == '-')
            {
                //符号的位置分成两个部分了
                List<Integer> leftans = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightans = diffWaysToCompute(input.substring(i+1));

                //分开后的结果还要做一下整合
                for (int j = 0; j<leftans.size(); j++)
                {

                    for (int k =0; k< rightans.size(); k++)
                    {
                        if (input.charAt(i) == '+')
                        {
                            ans.add(leftans.get(j) + rightans.get(k));
                        }
                        else if (input.charAt(i) == '-')
                        {
                            ans.add(leftans.get(j) - rightans.get(k));
                        }
                        else if (input.charAt(i) == '*')
                        {
                            ans.add(leftans.get(j) * rightans.get(k));
                        }
                    }
                }
            }
        }
        // 当没有记录结果的时候，那么就表示此时只是一个单独的数字，那么就需要记录下来了。
        if (ans.size() <1)
            ans.add(Integer.valueOf(input));
        return ans;
    }

    public static void main(String[] args) {
        String input = "2-1-1";
        DifferentWaystoAddParentheses d = new DifferentWaystoAddParentheses();
        System.out.println(d.diffWaysToCompute(input));
    }
}
