package Leetecode;

import java.util.*;

/**
 * Created by qinjiawei on 16-12-9.
 */
public class RemoveInvalidParentheses {

    /**
     * 301
     * 广度优先遍历，字符串的各个位置循环改变
     * 注意是移动 "最少"  的 字符数量，所以当找到的时候，就不需要继续寻找下去了
     *
     */
    public List<String> removeInvalidParentheses(String s) {


        List<String> ans = new ArrayList<>();

        Queue<String> queue  = new LinkedList<>();

        if(s == null)
            return ans;

        if (isValid(s))
        {
            ans.add(s);
            return ans;
        }
        queue.offer(s);
        Map<String,Integer> visit = new HashMap<>();

        visit.put(s,1);
        boolean hasfound = false;
        while (!queue.isEmpty())
        {

            String item = queue.poll();

            if(isValid(item))
            {
                hasfound = true;
                ans.add(item);
            }
            if(hasfound)
                continue;

            // 截取某一个字符 然后相当于删除某一个字符
            // 因为这个是循环的，所以下一次再寻找的话 那就是相当于字符减少了2个 依次递减.
            for (int i =0; i< item.length(); i++)
            {
                if(item.charAt(i) != '(' && item.charAt(i) != ')')
                    continue;
                String t = item.substring(0, i) + item.substring(i+1);
                if(!visit.containsKey(t))
                {
                    visit.put(t,1);
                    queue.offer(t);
                }
            }


        }

        return ans;
    }

    public boolean isValid(String s)
    {
        int count = 0;
        for (int i =0; i< s.length(); i++)
        {
            if (s.charAt(i) == '(')
                count++;
            else if(s.charAt(i)==')' && count-- == 0)
                return false;
        }

        return count==0?true:false;
    }

    public static void main(String[] args)
    {
        String s = "()())()";

        RemoveInvalidParentheses re = new RemoveInvalidParentheses();
        System.out.println(re.removeInvalidParentheses(s));

        s = "()()()";
        System.out.println(re.isValid(s));
    }
}
