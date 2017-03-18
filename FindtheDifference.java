package Leetecode;

/**
 * Created by qinjiawei on 16-12-20.
 */
public class FindtheDifference {
    /**
     * 389
     * 思路，还是用到异或运算,因为两个字符串必须会有相同的，相同的异或运算以后就会得到0
     * 而不同的字符串就是多出的那个，也就是运算以后的得到的结果
     */

    public char findTheDifference(String s, String t) {

        int ans = 0;
        int count =0;
        while (count <s.length() && count < t.length())
        {
            ans = ans ^s.charAt(count) ^t.charAt(count);
            count++;

        }
        while (count < s.length())
        {
            ans = ans ^s.charAt(count);
            count++;
        }
        while (count < t.length())
        {
            ans = ans ^t.charAt(count);
            count++;
        }
        return (char)ans;

    }

    public static void  main(String[] args)
    {
        FindtheDifference f = new FindtheDifference();
        System.out.println(f.findTheDifference("abcd", "abcde"));
    }
}
