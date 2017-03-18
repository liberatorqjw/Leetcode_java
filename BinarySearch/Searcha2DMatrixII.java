package Leetecode.BinarySearch;

/**
 * Created by qinjiawei on 17-2-26.
 */
public class Searcha2DMatrixII {

    /**
     * 240 的时候
     * @param matrix
     * @param target
     * @return
     */

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null|| matrix.length<1)
            return false;

        //列的数量
        int col = matrix[0].length;
        // 行的数量
        int row = matrix.length;
        int index_i=-1;
        int index_j=-1;

        //System.out.println(col);
        //System.out.println(row);

        for (int i =0;i < row; i++)
            for (int j =0; j< col; j++)
            {

                if (matrix[i][j] == target)
                {
                    index_i = i;
                    index_j = j;
                    break;
                }
            }

        if (index_i == -1 && index_j ==-1)
            return false;
        if (index_i !=-1) {
            //遍历列
            for (int i = 0; i < matrix[0].length - 1; i++) {
                if (matrix[index_i][i] > matrix[index_i][i + 1])
                    return false;

            }
        }
        if (index_j != -1) {
            //遍历行
            for (int i = 0; i < matrix.length - 1; i++) {
                if (matrix[i][index_j] > matrix[i + 1][index_j])
                    return false;
            }
        }
        return true;

    }
}
