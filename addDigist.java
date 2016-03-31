   /*
    258
    dr(n) = n - 9*[(n-1)/9]
     */  
public int addDigits(int num) {
           int m = (num -1)/9;
           m *=9;
        return num - m;

    }