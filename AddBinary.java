package Leetecode;

/**
 * Created by qinjiawei on 16-5-5.
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        String rest ="";
        if(a!=null && b!=null)
        {
            int lena = a.length()-1;
            int lenb = b.length()-1;
            int c = 0;
            while (lena>=0 && lenb >=0)
            {
                int ia = Integer.valueOf(String.valueOf(a.charAt(lena)));
                int ib = Integer.valueOf(String.valueOf(b.charAt(lenb)));

                int current = ia + ib + c;
                if(current>=2)
                {
                    c = 1;
                    current -=2;
                }
                else
                {
                    c =0;
                }

                res.append(current);
                rest += String.valueOf(current);
                lena--;
                lenb--;
            }
            while (lena>=0)
            {
                int ia = Integer.valueOf(String.valueOf(a.charAt(lena)));

                int current = ia + c;
                if(current>=2)
                {
                    c = 1;
                    current -=2;
                }
                else
                {
                    c =0;
                }

                res.append(current);
                rest += String.valueOf(current);
                lena--;
            }
            while (lenb>=0)
            {

                int ib = Integer.valueOf(String.valueOf(b.charAt(lenb)));

                int current =  ib + c;
                if(current>=2)
                {
                    c = 1;
                    current -=2;
                }
                else
                {
                    c =0;
                }

                res.append(current);
                rest += String.valueOf(current);
                lenb--;

            }
            if (c >=1)
                res.append(c);

        }
        return res.reverse().toString();
        //return rest.toString();
    }
}
