package Leetecode;

/**
 * Created by qinjiawei on 16-12-5.
 */
public class ConvertSortedListtoBinarySearchTree {

    //保证全局性
    public ListNode currentNode = null;

    public TreeNode sortedListToBST(ListNode head) {

        if(head == null)
            return null;
        ListNode node = head;

        int len =0;
        while (node != null)
        {
            len++;
//            head= head.next;
            node = node.next;
        }
        currentNode = head;

        return constructTree(0, len-1);
    }

    public TreeNode constructTree( int start, int end)
    {
        if (start > end)
            return  null;
        int mid = start + (end- start)/2;

        //中序遍历构造二叉树
        //先是 左---中---右
        TreeNode left = constructTree(start, mid-1);
        TreeNode curRoot = new TreeNode(currentNode.val);
        curRoot.left = left;
        //关键点在于保证他的全局性，这样才能保证不重复
        currentNode = currentNode.next;
        TreeNode right = constructTree( mid+1, end);
        curRoot.right = right;
        return  curRoot;

    }

    public static void main(String[] args)
    {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(8);
        head.next.next.next =null;

        ConvertSortedListtoBinarySearchTree c = new ConvertSortedListtoBinarySearchTree();
        c.sortedListToBST(head);
    }
}
