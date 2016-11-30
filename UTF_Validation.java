package Leetecode;

/**
 * 393
 * Created by qinjiawei on 16-9-4.
 */
public class UTF_Validation {

//    判断数组中的数字是不是符合utf8的编码规则
    public boolean validUtf8(int[] data) {

        boolean result = false;
        int item = data[0];
        item = (item & 248) >>>3;
        System.out.println(item);
        int count =0;
        int sum =0;
        if (item <=15 && item >=0)
            sum =0;
        else if (item< 28 && item >=24)
            sum = 1;
        else if (item<30 && item>=28)
            sum = 2;
        else if (item==30)
            sum = 3;
        else
        return false;

        if (sum ==0 && data.length==1)
            return true;
        System.out.println(sum);
        for (int i =1; i< data.length; i++)
        {
              item = (data[i] & 192) >>>6;
              System.out.println(item);
            if (item ==0)
            {
                if (sum>0)
                {
                    result = false;
                    break;
                }
                else
                {
                    result =true;
                    break;
                }
            }
            else if (item == 2)
            {
                if (sum >0)
                    sum--;
                else
                {
                    result = false;
                    break;
                }

            }
            else
            {
                if (sum > 0)
                {
                    result = false;
                    break;
                }
                if (sum ==0)
                {
                    result = true;
                    break;
                }

            }
            if (sum ==0 && i==data.length-1)
                result = true;

        }

        return result;
    }

    public int intTobit(int num)
    {
        int[] data = new int[8];
        int count =7;
        while (num/2 !=0)
        {
            data[count--] = num%2;
            num /=2;
        }
        if (num >0)
            data[count] =1;

        int sum =0;
        //连续的1个数
        for (int j =0; j<data.length; j++)
        {

            if (data[j] == 1)
                sum++;
            else
                break;
        }
        return sum;
    }

    public static void main(String[] args)
    {
        System.out.println(240 & 255);

        int[] data = {39,89,227,83,132,95,10,0};
        UTF_Validation u = new UTF_Validation();
        System.out.println(u.validUtf8(data));
//        System.out.println(u.intTobit(240));
    }


}
