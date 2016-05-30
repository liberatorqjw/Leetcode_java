package Leetecode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qinjiawei on 16-5-19.
 */
public class IntegertoRoman {
    /**
     *罗马字符串
     * 规则就像正常阅读一样几千 几百 几十 几 然后顺序求得这些数字就可
     */
    public String intToRoman(int num) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");

        String[][] romnum = {
                {"","I", "II","III","IV","V","VI","VII","VIII","IX"},
                {"", "X", "XX", "XXX", "XL","L", "LX", "LXX", "LXXX", "XC"},
                {"", "C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"", "M","MM","MMM"}
        };

        StringBuilder roman = new StringBuilder();
        roman.append(romnum[3][num /1000 % 10]);
        roman.append(romnum[2][num /100 % 10]);
        roman.append(romnum[1][num /10 % 10]);
        roman.append(romnum[0][num % 10]);

        return roman.toString();
    }
}
