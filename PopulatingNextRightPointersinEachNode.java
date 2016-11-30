package Leetecode;

/**
 * Created by qinjiawei on 16-11-26.
 */
public class PopulatingNextRightPointersinEachNode {

    /**
     * 116
     * 广度优先遍历
     * 巧妙的用到next指针
     */

    public void connect(TreeLinkNode root) {

        if(root==null)
            return;
        TreeLinkNode curnode ;
        //还有下一层
        while (root.left != null)
        {
            curnode = root;

            //同层的遍历
            while (curnode != null)
            {
                curnode.left.next = curnode.right;
                //该层还没有到达最后
                if (curnode.next != null)
                    curnode.right.next = curnode.next.left;
                curnode = curnode.next;
            }
            root = root.left;
        }

    }
}
