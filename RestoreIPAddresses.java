package Leetecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinjiawei on 17-2-13.
 */
public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {

        ArrayList<String> ans = new ArrayList<>();
        if (s == null || s.length() <4 || s.length() >12)
        {
            return ans;
        }
        //存储单个结果
        StringBuilder tmp = new StringBuilder();

        depthfs(0, 0, s, tmp, ans);

        return ans;
    }

    public void depthfs (int count, int idex , String s, StringBuilder tmp, ArrayList<String> res)
    {
        //count =4 表示是最后一个数字段的计算了
        if (count == 4 && idex == s.length()) {
            res.add(tmp.toString().substring(0, tmp.length() - 1));
            return;
        }
        else
        {
            // i是表示增加字符串长度，单个数字的截取的时候
            for (int i=1; i<=3&& idex +i <=s.length(); i++)
            {
                String tmpstr = s.substring(idex, idex +i);

                //数字的大小符合ip地址的要求
                if(isValid(tmpstr))
                {
                    int bt = tmp.length();
                    int end = tmp.length() + tmpstr.length();

                    //构建ip地址
                    tmp.append(tmpstr).append(".");

                    depthfs(count + 1, idex + i, s, tmp, res);
                    // 还原成原来的字符串
                    tmp.delete(bt, end +1);

                }
            }
        }

    }

    public boolean isValid(String s)
    {
        if (s.charAt(0) == '0')
            return s.equals("0");

        return Integer.parseInt(s) >=0 && Integer.parseInt(s)<=255;
    }
}
