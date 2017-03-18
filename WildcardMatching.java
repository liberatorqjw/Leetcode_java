package Leetecode;

/**
 * Created by qinjiawei on 17-2-20.
 */
public class WildcardMatching {

    /**
     * 44
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

        if (p.length() < 1 )
            return s.length() == 0;
        if (p.length() == 1)
        {
            if (p.charAt(0) == '*')
                return true;
            return (s.length() == 1 &&(s.charAt(0) == p.charAt(0) || p.charAt(0) == '?'));
        }

        int idxs =0;
        int idexp =0;
        int idxstar = -1;
        int idmatch = 0;

        while (idxs < s.length())
        {
            //字符匹配的时候
            if (idexp < p.length() && (s.charAt(idxs) == p.charAt(idexp) || p.charAt(idexp) == '?'))
            {
                idexp++;
                idxs++;
            }
            //字符不匹配，还没有？ 但是p中却是*
            else if (idexp < p.length() && p.charAt(idexp) == '*')
            {
                idxstar = idexp;
                idexp++;

                //遇到* 我们用idmatch 来记录s的位置
                idmatch = idxs;
            }
            //表示之前遇到过 * 的位置
            else if (idxstar != -1)
            {

                //上一个* 来匹配
                idexp = idxstar +1;

                // * 匹配的位置递增
                idmatch++;

                //s 回退
                idxs = idmatch;
            }
            else
                return false;
        }
        //s 已经匹配完毕了，那么遇到的*都没有用l
        while (idexp < p.length() && p.charAt(idexp) == '*')
        {
            idexp++;
        }
        return idexp == p.length();
    }
}
