package Leetecode.BinarySearch;

import Leetecode.IntegertoEnglishWords;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by qinjiawei on 17-2-23.
 */
public class KthSmallestElementinaSortedMatrix {

    /**
     * 378
     * 大顶堆的思想
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
//            public int compare(Integer a0, Integer a1) {
//                if(a0>a1){
//                    return -1;
//                }else if(a0<a1){
//                    return 1;
//                }
//                return 0;
//            }
//        });
     PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i =0; i < matrix.length; i++)
            for (int j =0; j< matrix[0].length; j++)
            {
                if (i * matrix.length + j >=k)
                {
                    if (matrix[i][j] < queue.peek())
                    {
                        queue.poll();
                        queue.offer(matrix[i][j]);
                    }
                }
                else
                {
                    queue.offer(matrix[i][j]);
                }
            }
        return queue.peek();
    }
}
