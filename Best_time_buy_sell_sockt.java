package Leetecode;

/**
 * Created by qinjiawei on 16-4-15.
 */
public class Best_time_buy_sell_sockt {
    /*
    动态规划法。从前向后遍历数组，记录当前出现过的最低价格，
    作为买入价格，并计算以当天价格出售的收益，作为可能的最大收益，
    整个遍历过程中，出现过的最大收益就是所求。
     */
    public int maxProfit(int[] prices) {
        if(prices.length <2)
       return 0;
        int curprice = prices[0];
        int maxprice =0;

        for(int i=0; i< prices.length; i++)
        {
            curprice = Math.min(prices[i],curprice);
            maxprice = Math.max(maxprice, prices[i] - curprice);
        }
        return maxprice;
    }
}
