package Leetecode;

/**
 * Created by qinjiawei on 17-2-16.
 */
public class IntegertoEnglishWords {


        public  String numberToWords(int num)
        {
            if (num == 0)
                return "Zero";

            String[] v1 = new String[]{"Thousand", "Million", "Billion"};
            String res = converHundred(num %1000);

            for (int i =0; i< 3; i++)
            {
                num /= 1000;

                res = num %1000 >0? converHundred(num %1000) + " " + v1[i] + " " + res:res;

            }
            int len = res.length();
            while (len-1>=0)
            {
                if (res.charAt(len-1) == ' ')
                    len--;
                else
                    break;

            }
            res = res.substring(0, len);
            return res;
        }

        String converHundred(int num)
        {
            //Ð¡ÓÚ20µÄÊý
            String[] v1 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
            // 10 µÄ±¶Êý
            String[] v2 = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

            String ans ="";
            int a = num/100;
            int b = num%100;
            int c = num %10;

            //ÏÈ×é×°µÍÁœÎ»
            ans = b< 20? v1[b]:v2[b/10] + (c>0? " " + v1[c]:"");
            if (a >0)
                ans = v1[a] + " Hundred" + (b>0? " " + ans:"");
            return ans;

        }



    public static void main(String[] args) {
        String res = "1234";
        System.out.println(2<<30 -1);
        System.out.println(123%10);
        System.out.println(res.substring(4));

        IntegertoEnglishWords i = new IntegertoEnglishWords();
        System.out.println(i.numberToWords(1234567));
    }
}
