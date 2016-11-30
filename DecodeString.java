package Leetecode;

/**
 * Created by qinjiawei on 16-11-17.
 */
public class DecodeString {
    /**
     * 394. Decode String
     * 字符串编码
     */

    public static int index =0;
    public String decodeString(String s) {

        StringBuilder ans = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        if(s == null || s.length()<1)
            return  null;
        index =0;

        return GetDecode(s);

    }

    public String GetDecode( String s)
    {

        StringBuilder tmp = new StringBuilder();
        StringBuilder ans = new StringBuilder();
//        for (int i =0; i< s.length(); i++)
        int len = s.length();
        String res = "";
        while (index < len && s.charAt(index) != ']')
        {
            if(s.charAt(index) < '0' || s.charAt(index) >'9')
            {
                res += s.charAt(index);
                index++;
            }
            else {
                int cns = 0;
                //考虑到非个位数字
                while (index < len && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                    int chr = s.charAt(index);
                    //循环的数字
                    cns =  (cns * 10 + (chr-48));
                    index++;
                }

                //滤过[
                index++;
                String t = GetDecode(s);
                //滤过]
                index++;
                System.out.println(cns);
                while (cns-->0)
                {
                    res += t;
                }
            }

        }
        return res;
    }

    public static void main(String[] args)
    {
        DecodeString decodeString = new DecodeString();
        String str = "3[a]2[bc]";
        str = "3[a2[c]]";
        str = "100[leetcode]";
        System.out.println(decodeString.decodeString(str));
    }


}
