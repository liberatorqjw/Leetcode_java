package Leetecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by qinjiawei on 17-2-14.
 */
public class SimplifyPath {

    /**
     * 细节处理题目，
     * @param path
     * @return
     */
    public String simplifyPath(String path) {

        if (path == null || path.length() <1)
            return path;

        String[] paths = path.substring(1).split("/");

        Stack<String> ans = new Stack<>();

        for (String s : paths)
        {
            if (s.equals("."))
                continue;
            else if (s.equals(".."))
            {
                if(ans.isEmpty())
                    continue;
                ans.pop();
            }
            else{
                if(s.length()<1)
                    continue;
                ans.push(s);
            }

        }
        List<String> tmp = new ArrayList<>();
        while (!ans.isEmpty())
        {
            tmp.add(ans.pop());
        }

        StringBuilder res = new StringBuilder();
        res.append("/");

        for (int i = tmp.size()-1; i>=0;i--)
        {
            res.append(tmp.get(i));
            if(i-1 >=0)
                res.append("/");
        }
        return res.toString();

    }
}
