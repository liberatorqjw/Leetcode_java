package Leetecode;

/**
 * Created by qinjiawei on 16-5-6.
 */
public class BullsandCows {

    /*
      A 是正确位置上的数字
      B 是数字存在 但是位置并不存在
     */
    public String getHint(String secret, String guess) {

        char[] se_ch = secret.toCharArray();
        char[] guess_ch = guess.toCharArray();

        int[] sec_int = new int[10];
        int[] guess_int = new int[10];
        int A =0;
        int B = 0;
        int total =0;
        for (int i =0 ; i< secret.length(); i++)
        {
            sec_int[se_ch[i] - '0'] ++;
            guess_int[guess_ch[i] - '0'] ++;
            if (se_ch[i] == guess_ch[i])
                A++;

        }
        for (int i =0; i<10; i++)
        {
            //因为存在这个数字 则相同的就是最小的数字，否则就是不存在  就是最小的0
            total+=Math.min(sec_int[i], guess_int[i]);
        }
        B = total - A;
        String ans = A + "A" + B + "B";
        return ans;
    }
}
