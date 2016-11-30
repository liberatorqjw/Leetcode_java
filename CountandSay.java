package Leetecode;

/**
 * Created by qinjiawei on 16-5-10.
 */
public class CountandSay {

    public String countAndSay(int n) {



        String result = "1";
        int i =1;
        while (i <n)
        {

            result = countCount(result);
            i++;
        }
        return result;
    }

    public String countCount(String nums)
    {
        char tmp = nums.charAt(0);

        StringBuilder result = new StringBuilder();
        int count =1;
        for (int i = 1; i< nums.length(); i++)
        {
            if(nums.charAt(i) == tmp)
            {
                count++;
                continue;  //用的比较好的地方
            }
            result.append(count);
            result.append(tmp);
            count =1;
            tmp = nums.charAt(i);
        }
        result.append(count);
        result.append(tmp);

        return result.toString();
    }
}
