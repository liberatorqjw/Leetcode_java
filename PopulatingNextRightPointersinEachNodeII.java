package Leetecode;

/**
 * Created by qinjiawei on 16-11-26.
 */
public class PopulatingNextRightPointersinEachNodeII {
    /**
     * 117
     * 整体思路是按照上一层来控制下一层
     */
    public void connectBack(TreeLinkNode root) {
        if(root== null)
            return;
        TreeLinkNode cur;
        TreeLinkNode next;
        TreeLinkNode start;

        while (root != null)
        {
            start = findStartNode(root);
            cur = start;
            next = findNextNode(root, start);

            while (next != null)
            {
                cur.next = next;
                cur = next;
                next = findNextNode(root, cur);
            }

            root = start;
        }

    }

    /**
     *
     * @param curnode 当前节点
     * @param curNextLecNode 下一层的当前节点
     * @return
     */
    TreeLinkNode findNextNode(TreeLinkNode curnode, TreeLinkNode curNextLecNode)
    {
        if (curnode.left == curNextLecNode && curnode.right != null)
            return curnode.right;
        else {
            while (curnode.next != null) {
                curnode = curnode.next;
                if (curnode.left != null && curnode.left != curNextLecNode)
                    return curnode.left;
                 if (curnode.right != null && curnode.right != curNextLecNode)
                    return curnode.right;


            }
        }
        return null;
    }

    /**
     * 找到下一层的首个节点
     * @param curnode
     * @return
     */
    TreeLinkNode findStartNode(TreeLinkNode curnode)
    {
        if(curnode == null)
            return null;
         if (curnode.left != null)
            return curnode.left;
         return findNextNode(curnode, curnode.left);
    }

    public  void connect(TreeLinkNode root)
    {
        //     第一层节点               下一层的头结点
        TreeLinkNode levelhead =root, nextLevelHead = null;

        while (levelhead != null)
        {
            TreeLinkNode node = levelhead;
            TreeLinkNode tail = null;
//            对下一层的节点进行连接
            while (node != null)
            {
                if(node.left != null && node.right != null)
                {
                    node.left.next = node.right;
                }
                TreeLinkNode sub;
                if(node.left != null)
                    sub = node.left;
                else if(node.right != null)
                    sub = node.right;
                else
                    sub = null;

                if(sub != null)
                {
                    //确定下一层的俄起点
                    if(nextLevelHead == null)
                    {
                        nextLevelHead = sub;
                        tail = sub;
                    }
                    //不是第一个节点，那么就继续向下链接
                    else
                    {
                        tail.next = sub;
                    }
                    while (tail.next != null)
                        tail = tail.next;
                }
                //由于node是上一层的节点，那么它就能找到next的节点，
                node = node.next;
            }
            //向下走一层
            levelhead = nextLevelHead;
            nextLevelHead = null;
        }
    }
}
