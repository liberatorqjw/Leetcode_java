package Leetecode;

import java.util.*;

/**
 * Created by qinjiawei on 17-2-21.
 */
public class WordLadderII {

    /**
     * 126 那么就是先想到的就是广度优先搜索，但是这样好像会出现超时
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        HashSet<String> hash = new HashSet<>();

        if (beginWord == null || endWord == null || beginWord.length() != endWord.length())
        {
            return ans;
        }

        Queue queue = new LinkedList<Pair>();
        path.add(beginWord);
        hash.add(beginWord);

        Pair pair = new Pair(beginWord, path, hash);

        //记录到达目标所需要的最短修改距离
        int min_len = -1;
        queue.add(pair);

        while (!queue.isEmpty())
        {
            //出队列
            pair = (Pair) queue.poll();
            String str = pair.str;

            for (int i = 0 ; i< str.length(); i++)
            {
                char[] charstr = str.toCharArray();

                //保证每次都是只是修改一个字符
                for (char c = 'a'; c<='z'; c++)
                {
                    if (charstr[i] == c)
                        continue;

                    // 替换字符，然后形成一个新的字符串
                    charstr[i] = c;

                    String newword = new String(charstr);
                    // 表示已经找到了一个满足转换的
                    if(newword.equals(endWord))
                    {
                        path = pair.path;
                        path.add(newword);
                        // 修改最短的距离
                        if (min_len == -1)
                        {
                            min_len = path.size();
                        }
                        if (path.size()> min_len)
                        {
                            return ans;
                        }
                        if (path.size() < min_len)
                        {
                            min_len = path.size();
                        }
                        else
                        {
                            ans.add(path);
                            continue;
                        }
                    }
                    else
                    {
                        if (wordList.contains(newword) && !pair.hash.contains(newword))
                        {
                            path = new ArrayList<>(pair.path);
                            hash = new HashSet<>(pair.hash);

                            path.add(newword);
                            hash.add(newword);

                            Pair newnode = new Pair(newword, path,hash);
                            queue.add(newnode);
                        }
                    }
                }
            }
        }

        return ans;

    }


}

class Pair {
    String str;
    // 变换路径的ArrayList]
    List<String> path;
    //变换路径的hash表
    HashSet<String> hash;

    public Pair(String str, List<String> path, HashSet<String> hash) {
        this.str = str;
        this.path = path;
        this.hash = hash;
    }
}