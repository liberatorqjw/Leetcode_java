package Leetecode;

/**
 * Created by qinjiawei on 16-12-3.
 */
public class ConstruBinarTreefromPreorderandInorder {

    /**
     * 105
     * 用一个二叉树的前前序和中序来获取构建一个明确的二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length < 1 || inorder.length < 1)
            return null;

        int pstart = 0;
        int pend = preorder.length -1;
        int istart = 0;
        int iend = inorder.length -1;

        return  constructTree(pstart,pend,istart,iend, preorder, inorder);
    }

    public TreeNode constructTree(int pstart, int pend, int istart,int iend,int[] preorder, int[] inorder)
    {
        if (pstart > pend || istart> iend)
            return  null;
        TreeNode root = new TreeNode(preorder[pstart]);
        if (pstart == pend || istart == iend)
            return  root;
        int tmp = istart;
        while (istart != iend)
        {
            if(preorder[pstart] == inorder[istart])
                break;
            istart++;
        }
        // 此时求出的istart 就是root点再中序遍历中出现的位置
        //下面做出拆分，左子树的放在一起，右子树的放在一起
        // 一定注意位置的划分是  pstart + (istart - tmp) //一定要加上pstart, 因为后面求出 的只是差距，还要加上其实位置才能确定真正的位置

        root.left = constructTree(pstart+1, pstart + (istart - tmp) , tmp, istart-1, preorder,inorder);
        root.right = constructTree(pstart +(istart - tmp) +1, pend, istart+1, iend, preorder,inorder);

        return root;
    }
}
