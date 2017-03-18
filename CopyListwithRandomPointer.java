package Leetecode;

/**
 * Created by qinjiawei on 17-1-13.
 */
public class CopyListwithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null)
            return head;

        RandomListNode node = head;

        //第一遍的扫描是把新的节点插入到节点中间
        while (node != null)
        {
            RandomListNode newnode = new RandomListNode(node.label);
            newnode.next = node.next;
            node.next = newnode;
            node = newnode.next;
        }

        //第二遍的扫描是连接随机节点
        node = head;
        while (node != null)
        {
            if (node.random != null)
                node.next.random = node.random.next;
            node = node.next.next;
        }

        //第三遍的扫描是把新的拷贝节点复制出来
        RandomListNode newhead = head.next;
        node = head;
        while (node != null)
        {
            RandomListNode newnode = node.next;
            node.next = newhead.next;
            if (newnode.next != null)
                newhead.next = newhead.next.next;
            node = node.next;
        }

        return newhead;

    }
}
