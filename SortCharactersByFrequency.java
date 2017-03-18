package Leetecode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by qinjiawei on 16-12-21.
 */
public class SortCharactersByFrequency {

    /**
     * 451  按照词频排序字符串
     * 思路： 主要是要借助到java 中的PriorityQueue (它是把数据放在队列中实现的自动排列)
     */

    class Node{
        char c;
        int frequent;

        public Node(char c, int frequent) {
            this.c = c;
            this.frequent = frequent;
        }
    }
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        StringBuilder ans = new StringBuilder();

        if(s.length()<1)
            return ans.toString();

        for (int i =0; i< s.length(); i++)
        {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i)) +1);
            else
                map.put(s.charAt(i), 1);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(map.keySet().size(), new Comparator<Node>() {

            // 递减序列
            @Override
            public int compare(Node o1, Node o2) {
                return o2.frequent - o1.frequent;
            }
        });

        for (Character c : map.keySet())
        {
            Node node = new Node(c, map.get(c));
            queue.offer(node);
        }

        while (!queue.isEmpty())
        {
            Node node = queue.poll();
            int fre = node.frequent;
            while (fre>0)
            {
                ans.append(node.c);
                fre--;
            }

        }
        return ans.toString();

    }
}
