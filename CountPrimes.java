package Leetecode;

/**
 * Created by qinjiawei on 16-4-28.
 */
public class CountPrimes {

    /*
      快速计算素数个数
     */
    public int countPrimes(int n) {
        if(n <=2)
            return 0;
        int[] primes = new int[n];
        for(int i = 2; i*i <n ; i++)
        {
            if(primes[i] ==0)
            {
                for (int j =2; j*i < n; j++)
                    primes[i*j] = 1;
            }
        }
        int sum =0;
        for (int i =2 ; i !=n; i++)
            if(primes[i] == 0)
                sum++;

        System.out.println(sum);
        return sum;
    }
}
