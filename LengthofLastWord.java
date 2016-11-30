package Leetecode;

import com.sun.org.apache.xpath.internal.operations.*;

import java.lang.String;
import java.util.StringTokenizer;

/**
 * Created by qinjiawei on 16-5-8.
 */
public class LengthofLastWord {

    /*
    trim 的使用 可以去掉多余的空格 和回车符号等
     */
    public int lengthOfLastWord(String s) {
        if (s.trim().equals("")|| s.length() ==0)
            return 0;
        String[] str = s.trim().split(" ");
        return str[str.length-1].length();
    }
}
