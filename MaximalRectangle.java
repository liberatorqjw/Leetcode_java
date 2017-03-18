package Leetecode;

import java.util.Stack;

/**
 * Created by qinjiawei on 16-12-29.
 */
public class MaximalRectangle {


    public int maximalRectangle(char[][] matrix) {
        int max = 0;

        if (matrix == null || matrix.length <1)
            return max;

        int col = matrix.length;
        int row = matrix[0].length;
        Stack<Integer> stack = new Stack<>();
        int[] height = new int[row+1];
        int leftarea = 0;
        int rightarea = 0;

        for (int i =0 ; i< col; i++) {

            // 每次开始新的计算都要先清空栈
            while (!stack.isEmpty()) {
                stack.pop();
            }

            for (int j = 0; j< row; j++)
            {
                if (matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] =0;
            }

            // 按照波浪型的 矩阵进行计算，
            //计算此时的面积 ，由于此时在数据的最后多放了一个0 ，所以遍历的时候长度要加上1
            for (int j =0; j<=row; j++)
            {
                while (!stack.isEmpty() && height[stack.peek()] > height[j])
                {
                    int tmp = stack.pop();
                    leftarea = (stack.isEmpty()?tmp+1:tmp-stack.peek()) * height[tmp];
                    rightarea = (j-tmp-1) * height[tmp];
                    if (leftarea + rightarea > max)
                        max = leftarea + rightarea;
                }
                stack.push(j);
            }
        }
        return max;
    }
}
