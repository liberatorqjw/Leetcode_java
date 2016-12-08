package Leetecode;

/**
 * Created by qinjiawei on 16-12-4.
 */
public class ConstructBinaryTreefromInorderandPostorder {


    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder.length <1 || postorder.length <1)
            return null;
        int instart = 0;
        int inend = inorder.length -1;
        int poststart = 0;
        int postend = postorder.length -1;

        return constructTree(instart, inend, poststart, postend, inorder, postorder);

    }

    public TreeNode constructTree(int instart, int inend , int poststart, int postend , int[] inorder, int[] postorder)
    {

        if(instart >inend || poststart > postend)
            return  null;
        TreeNode root = new TreeNode(postorder[postend]);

        if(instart == inend || poststart == postend)
            return root;

        int tmp = instart;
        while (instart != inend)
        {
            //找相等的俄时候注意
            if(inorder[instart] == postorder[postend])
                break;
            instart++;
        }

        //注意位置的选取，就是下一个数组的长度的选取
        root.left = constructTree(tmp,instart-1, poststart ,poststart +(instart - tmp)-1, inorder,postorder);
        root.right = constructTree(instart +1,inend, poststart +(instart - tmp), postend -1, inorder,postorder);

        return  root;
    }
}
