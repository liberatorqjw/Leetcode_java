package Leetecode;

/**
 * Created by qinjiawei on 16-12-14.
 */
public class KthSmallestElementinaBST {


    public int count =1;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k <1)
            return 0;
        int[] p = new int[k+1];

        construct(root, p);

        return p[k];
    }

    public void construct(TreeNode root, int[] k)
    {
        if(root == null)
            return;
        if(root.left != null)
        {
            construct(root.left, k);
        }

        if (count < k.length)
             k[count++] = root.val;

        if (root.right != null)
        {
            construct(root.right, k);
        }
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        KthSmallestElementinaBST k = new KthSmallestElementinaBST();
        k.kthSmallest(root,1);
    }
}
