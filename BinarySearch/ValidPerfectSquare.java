package Leetecode.BinarySearch;

/**
 * Created by qinjiawei on 17-2-26.
 */
public class ValidPerfectSquare {

    /**
     * 367
     * 判断一个数num，是不是另一个数b的平方,如果存在b那么就返回true
     * 数学性质，完全平方数是一系列奇数之和
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {

        for (int i =1; num>=0;i+=2)
        {
            num-=i;
        }
        return num == 0;
    }

    public static void main(String[] args) {
        int i = 46340;
        System.out.println(i>>1);
    }
}
