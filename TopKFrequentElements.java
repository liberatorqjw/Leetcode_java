package Leetecode;

import java.util.*;

/**
 * Created by qinjiawei on 16-12-22.
 */
public class TopKFrequentElements {

    class  Node{
        int val;
        int fre;

        public Node(int val, int fre) {
            this.val = val;
            this.fre = fre;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length <1 || k ==0)
            return ans;

        for (int i =0; i< nums.length; i++)
        {
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) +1);
            else
                map.put(nums[i], 1);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(map.keySet().size(), new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.fre - o1.fre;
            }
        });
        for (int key:map.keySet())
        {
            Node node = new Node(key, map.get(key));
            queue.add(node);
        }
        while (!queue.isEmpty() && k >0)
        {
                ans.add(queue.poll().val);
              k--;

        }
        return ans;
    }

}
