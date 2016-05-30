package Leetecode;

/**
 * Created by qinjiawei on 16-5-29.
 */
public class MultiplyStrings {

    /**
     * 大整数的乘法
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        // num2 是最长的字符串
        if (num1.length() > num2.length())
        {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        StringBuilder ret = new StringBuilder();
        for (int i =num1.length() -1; i >=0; i--)
        {
            int c =0;
            int tmpindex = num1.length() - i -1;
            for (int j =num2.length() -1; j >=0 ; j--)
            {
                int tmp = Integer.valueOf(num2.charAt(j) - '0') * Integer.valueOf(num1.charAt(i) -'0');
                /*
                注意这个取进位的地方,因为有可能是加上进位以后还要再一次的进位
                 */
                int cur = (tmp+c) % 10;
                c = (tmp +c) /10;
               if (i == num1.length() -1)
                ret.append(cur);
                else
                {
                    if (tmpindex > ret.length() -1)
                    {
                        ret.append(cur);
                        continue;
                    }
                    cur += Integer.valueOf(ret.charAt(tmpindex) -'0') ;

                    /*
                    大于10的情况  一定要用取余数的方法, 不能用减法，因为可能出现大于20的情况
                     */
                    if (cur >=10)
                    {
                        c += cur/10;
                        cur %=10;
                    }
                    ret.replace(tmpindex, tmpindex+1, String.valueOf(cur));
                    tmpindex++;
                }
            }
            if (c >0)
            ret.append(c);
        }
        return ret.reverse().toString();
    }

    public static void main(String[] args)
    {
        MultiplyStrings ms = new MultiplyStrings();
        ms.multiply("696", "30");
        String str = "123";
        System.out.println(Integer.valueOf(str.charAt(2) -'0'));
    }
}
