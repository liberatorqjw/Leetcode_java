package Leetecode.BinarySearch;

/**
 * Created by qinjiawei on 17-2-27.
 */
public class Searcha2DMatrix {
    /**
     * 74 寻找一个目标数
     * @param matrix
     * @param target
     * @return
     */
    public  static boolean searchMatrix(int[][] matrix, int target) {

       if (matrix == null||matrix.length <1|| matrix[0].length<1)
           return false;


        int left =0;
        int right = matrix.length-1;

        while (left<=right)
        {
            int mid = (left+right)/2;

            if (matrix[mid][0] == target)
                return true;
            if (matrix[mid][0] < target)
            {
                left = mid+1;
            }
            else if (matrix[mid][0] > target)
            {
                right = mid-1;
            }

        }
        int row = right;
        if (row <0)
            return false;
        //开始在行中寻找
        left = 0;
        right = matrix[0].length -1;

        while (left <= right)
        {
            int mid = (left+right)/2;
            if (matrix[row][mid] == target)
                return true;
            if (matrix[row][mid] <target)
                left = mid+1;
            else
                right = mid-1;
        }

        return false;


    }

    public static void main(String[] args) {
        int[][] mar = new int[][]{{},{},{}};
        searchMatrix(mar, 3);
    }
}
