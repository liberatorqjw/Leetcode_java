package Leetecode;

/**
 * Created by qinjiawei on 16-12-17.
 */
public class CountCompleteTreeNodes {

    /**
     * 222 计算完全二叉树的节点数量
     * 1 思路1 是叶子节点单独计算，其他的用数学公式计算 但是很不幸，超过时间了
     * 2. 思路2 递归的方式,首先查找树的最左边点的深度，再查找树的最右边的点的深度，一旦两个数值相等，表明没有多余的叶子节点。
     * 直接用公式计算即可。
     *   一旦不相等，那么就需要再计算，该节点的个个子树的节点个数，子树的节点计算依据同样的道理，因为最差的情况就是该子树只有一个节点了，
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        TreeNode nodeL = root;
        TreeNode nodeR = root;
        int countL = 0;
        while (nodeL!= null)
        {
            nodeL = nodeL.left;
            countL++;
         }

         int countR =0;
         while (nodeR!= null)
        {
            nodeR = nodeR.right;
            countR++;
        }

        //左边和右边全部相等，那么代表完全二叉树
        if(countL == countR)
            return (1<< countL) -1;
        // 1表示的是根节点，
        return countNodes(root.left) + countNodes(root.right) +1;


    }
    public   int levelsNum(TreeNode root, int count,int cur)
    {
        int ans = 0;
        if (root == null)
            return 0;
        if (root.left == null && root.right == null && cur ==count)
            return 1;
        ans +=levelsNum(root.left, count, cur+1);
        ans += levelsNum(root.right,count, cur+1);
        return ans;
    }
    public static void  main(String[] args)
    {
        CountCompleteTreeNodes c = new CountCompleteTreeNodes();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);


        System.out.println(c.countNodes(root));
    }
}
