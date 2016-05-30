package Leetecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinjiawei on 16-5-23.
 */
public class LetterCombinationsofaPhoneNumber {

    /**
     * 由于要循环遍历  所以要深度优先遍历
     */
    public List<String> letterCombinations(String digits) {
        String[] strnums = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        List<String> ret = new ArrayList<>();
        if(digits.length() <1 || digits == null)
            return ret;
        //System.out.println(strnums[Integer.valueOf(String.valueOf(digits.charAt(0)))]);
        depPath(0, digits, strnums, "", ret);
        return  ret;
    }

    public void depPath(int dep, String digits, String[] strnums, String resitem, List<String> ret)
    {
        if(dep == digits.length())
        {
            ret.add(resitem);
            return;
        }

        for (int i = 0; i< strnums[Integer.valueOf(String.valueOf(digits.charAt(dep)))].length(); i++)
        {
            depPath(dep+1, digits, strnums, resitem + String.valueOf(strnums[Integer.valueOf(String.valueOf(digits.charAt(dep)))].charAt(i)), ret);
        }
    }

}
