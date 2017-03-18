package Leetecode;

/**
 * Created by qinjiawei on 17-2-12.
 */
public class MiniParser {

    public NestedInteger deserialize(String s) {

        //如果是真的
        if (s.contains("[")) {
            NestedInteger ans=new NestedInteger();
            if (s.length()>2) {
                int begin=1;
                char[] cs=s.toCharArray();
                int count=0;
                for (int i = 1; i < s.length()-1; i++) {
                    if (cs[i]==','&&count==0) {
                        ans.add(deserialize(s.substring(begin,i)));
                        begin=i+1;
                    }
                    //[ 被92剪掉那么就会得到1 】得到的是-1  就是用count来判断是不是同一层的
                    if (cs[i]=='['||cs[i]==']') {
                        count+=(92-cs[i]);
                    }
                }
                ans.add(deserialize(s.substring(begin,s.length()-1)));
            }
            //表示存在的数据是空的
            return ans;
        }
        //原本的数据就是一个数
        return new NestedInteger(Integer.valueOf(s));
    }


}
