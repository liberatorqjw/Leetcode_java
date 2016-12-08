package Leetecode;

/**
 * Created by qinjiawei on 16-12-4.
 */
public class ConvertSortedArraytoBinarySearchTree {
    /**
     * 108
     *
     （1）、若它的左子树不为空，则左子树上所有结点的值均小于它的根结点的值；

     （2）、若它的右子树不为空，则右子树上所有结点的值均大于它的根结点的值；

     （3）、它的左、右子树也分别为二叉查找树。
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length < 1)
            return null;
        int start =0;

        start = (nums.length-1) /2;

        TreeNode root = new TreeNode(nums[start]);
        root.left =construct(0, start-1, start ,nums);
        root.right =construct(start+1, nums.length -1, start, nums);


        return  root;
    }

    public TreeNode construct(int start, int end , int medium ,int[] nums)
    {
        if(start >end || start<0 || end >= nums.length )
            return null;
        if(start == end)
            return  new TreeNode(nums[start]);

        //就是求中间点，不要那么复杂的考虑
        int Newmedium = start + (end -start)/2;
//        if(start > medium)
//         Newmedium = medium + (end-start +1) /2;
//        else
//        Newmedium = (end-start) /2 + start;

        TreeNode root = new TreeNode(nums[Newmedium]);
        if(start == end)
        {
            return  root;
        }

        root.left =construct(start, Newmedium-1, Newmedium, nums);
        root.right =construct(Newmedium+1, end, Newmedium, nums);
        return root;

    }
    public TreeNode SearchInsert(TreeNode root , int key)
    {
        TreeNode pnode = root;
        TreeNode snode = root;

        while (pnode != null)
        {
            //记录叶子节点
            snode = pnode;
            if(pnode.val == key)
                return  null;
            pnode = (key < pnode.val) ?pnode.left :pnode.right;
        }
        return snode;
    }

    public static void  main(String[] args)
    {
        int []nums ={0,1,2,3,4,5};
        ConvertSortedArraytoBinarySearchTree c = new ConvertSortedArraytoBinarySearchTree();
        c.sortedArrayToBST(nums);
    }


}
