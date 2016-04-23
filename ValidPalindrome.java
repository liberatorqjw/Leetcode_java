package Leetecode;

/**
 * Created by qinjiawei on 16-4-23.
 */
public class ValidPalindrome {
    //判断是不是回文，忽略其他字符
   // 字母的大小写
    public boolean isPalindrome(String s) {
        if(s == null)
            return true;
        int begin =0;
        int end = s.length()-1;
        String nums = "1234567890";
        String a = "qwertyuiopasdfghjklzxcvbnm";
        String A = "QWERTYUIOPASDFGHJKLZXCVBNM";
        while (begin < end)
        {
            char pre = s.charAt(begin);
            char tail = s.charAt(end);
            while (!isValid(pre) || !isNum(pre))
            {
                begin++;
                pre = s.charAt(begin);
            }
            while (!isValid(tail) || !isNum(tail))
            {
                end--;
                tail = s.charAt(end);
            }
            if (Character.toLowerCase(pre) != Character.toLowerCase(tail))
                return false;
            else {
                begin++;
                end--;
            }

        }
        return true;
    }
    boolean isValid(char s)
    {
        if((s >= 'a' && s <= 'z') ||(s>= 'A' && s <= 'Z'))
            return true;
        else
            return false;
    }
    boolean isNum(char s)
    {
        if(s >='0' && s<='9')
            return true;
        else
            return false;
    }



}
