package Leetecode;

/**
 * Created by qinjiawei on 16-4-20.
 */
public class PlusOne {
    // 数字用数组表示  然后作加1操作
    public int[] plusOne(int[] digits) {

        int tmp =0;
        int addone = 0;
        boolean isfirst =true;

        for(int i= digits.length-1; i>=0; i--)
        {
            if(isfirst) {
                tmp = digits[i] + 1 + addone;
                isfirst = false;
            }else
            tmp = digits[i] + addone;
            if (tmp >=10) {
                digits[i] = tmp -10;
                addone =1;
            }
            else {
                addone =0;
                digits[i] = tmp;
            }

        }
        if(addone ==1)
        {
            int[] newdigits = new int[digits.length+1];
            newdigits[0] = 1;
            for (int i=0; i< digits.length; i++)
                newdigits[i+1] = digits[i];
            return newdigits;
        }
        return digits;
    }
}
