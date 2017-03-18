package Leetecode.BinarySearch;

/**
 * Created by qinjiawei on 17-3-2.
 */
public class H_IndexII {

    /**
     * 275 在一个递增的序列中寻找到一个数组
     * ，即一个人在其所有学术文章中有N篇论文分别被引用了至少N次，他的H指数就是N。
     * ans 可以先计算大于的数量 然后当它大于其中一个数字的时候（它就是大于了后续的所有小的值了）那么它就是这个至少的个数了
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {

        if (citations == null || citations.length <1)
            return 0;

        int left = 0;
        int right = citations.length -1;
        int total = citations.length;

        int ans =0;
        for (int i = citations.length -1; i>=0; i--)
        {
            if (ans >=citations[i])
                return ans;
            ans++;

        }
        return ans;

    }
}
