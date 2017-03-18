package Leetecode;

import java.util.Stack;

/**
 * Created by qinjiawei on 17-2-19.
 */
public class LongestValidParentheses {

    /**
     * 32
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {

        Stack<parte> stack = new Stack<>();
        int ans = 0;
        boolean flag = false;
        for (int i =0; i< s.length(); i++)
        {
            char c = s.charAt(i);

            if (stack.isEmpty()) {
                parte p = new parte(i, c);
                stack.push(p);
            }
            else
            {

                // 判断字符
                 if (c == ')')
                {
                    if (stack.peek().c == '(') {

                        stack.pop();
                        int curlen =0;
                        if (stack.isEmpty())
                        {
                            curlen = i +1;
                        }else
                        {
                            curlen = i - stack.peek().i;
                        }
                        ans = Math.max(ans, curlen);
                    }
                    //别忘记了不满足条件的时候，入队列中
                    else
                    {
                        parte p = new parte(i, c);
                        stack.push(p);
                    }
                }

                else
                {
                   parte p = new parte(i, c);
                    stack.push(p);
                }
            }

        }
        return ans;
    }

    //做一个位置的记录
    class parte{
        int i;
        char c;

        public parte(int i, char c) {
            this.i = i;
            this.c = c;
        }
    }
}
