package Leetecode;

import com.sun.deploy.util.SyncAccess;

import java.util.Stack;

/**
 * Created by qinjiawei on 17-2-21.
 */
public class ReverseWordsinaString {


    /**
     * 151 翻转字符串
     * (1) 用到两次翻转的思想，但是得特殊考虑空格的条件
     * (2) 两个栈的思想
     * @param s
     * @return
     */
    public String reverseWords(String s) {

        Stack<Character> word = new Stack<>();
        Stack<Character> sequence = new Stack<>();

        for (int i = 0; i <=s.length(); i++)
        {
            // 考虑到当字符中只有‘ ’ 的时候，那么就不应该放在结果中
            //只所以要考虑到 s.length 就是考虑到s遍历结束得时候，word中的字符还不是空，那么就要把它拿出来放到sequence中
            if (i == s.length() || s.charAt(i) == ' ')
            {
                if (!word.empty())
                {
                    if (!sequence.empty())
                    {
                        sequence.push(' ');
                    }
                }
                while (!word.empty())
                {
                    sequence.push(word.pop());
                }

            }
            else
            {
                word.push(s.charAt(i));
            }
        }
        StringBuilder ans  = new StringBuilder();
        while (!sequence.empty())
        {
            ans.append(sequence.pop());
        }

        return ans.toString();
    }

    public String revers(String s)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() -1; i>=0; i--)
            sb.append(s.charAt(i));

        return sb.toString();
    }
}
