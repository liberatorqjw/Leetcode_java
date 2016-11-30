package Leetecode;

/**
 * 392
 * Created by qinjiawei on 16-9-4.
 *
 * problem
 * Given a string s and a string t, check if s is subsequence of t.

 You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

 Example 1:
 s = "abc", t = "ahbgdc"

 Return true.

 Example 2:
 s = "axc", t = "ahbgdc"

 Return false.
 */
public class Is_Subsequence {

    public boolean isSubsequence(String s, String t) {

        if (s.length()<1)
            return true;
        else if (s.length()>1 && t.length()<1)
            return false;

        boolean result = false;
        int j =0;
        char sc = s.charAt(j);

        for(int i =0; i< t.length();i++)
        {
            char tc = t.charAt(i);

            if (tc == sc)
            {
                j++;
                if (j >s.length()-1)
                    break;
                sc = s.charAt(j);
            }

        }
        if (j == s.length())
            result = true;

        return  result;

    }

    public static void main(String[] args)
    {
        Is_Subsequence is = new Is_Subsequence();
        String s = "axc";
        String t ="ahbgdc";
        System.out.println(is.isSubsequence(s,t));
    }
}
