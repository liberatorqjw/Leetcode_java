package Leetecode;

/**
 * Created by qinjiawei on 17-2-9.
 */
public class RepeatedSubstringPattern {

    /**
     * 459 计算判断字符串是不是重复的
     * @param str
     * @return
     */
    public boolean repeatedSubstringPattern(String str) {
        int len = str.length();

        // i是平均分的长度
        for (int i = len/2; i>=1; i--)
        {
            if (len %i == 0)
            {
                // 平均分的分数
                int m = len/i;
                String substr = str.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j =0; j< m; j++)
                {
                    sb.append(substr);
                }
                if (sb.toString().equals(str))
                    return true;
            }
        }
        return  false;
    }
}
