package Leetecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinjiawei on 16-4-23.
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        String[] nums = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L",
                "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        int cur=0;

        List<String> titles = new ArrayList<>();
        while (n !=0)
        {
            //注意这里的减去1的操作
            cur = (n-1)%26;
            titles.add(nums[cur]);
            //这里也要有减去1
            n = (n-1)/26;
        }
        String titlesret ="";
        for (int i=titles.size()-1; i>=0; i--)
            titlesret += titles.get(i);
        return titlesret;
    }
}
