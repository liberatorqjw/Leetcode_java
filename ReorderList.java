package Leetecode;

/**
 * Created by qinjiawei on 17-1-18.
 */
public class ReorderList {

    /**
     * 143
     * 其实题目的本意就是把一个字符串重新排序，可以理解成两个字符串插入操作
     * 这两个字符串就可以看成是 原始字符串的前后两个部分。
     * @param head
     */
    public void reorderList(ListNode head) {

        if (head == null || head.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;

        // fast 每次移动两个， slow每次移动一个，这样就会形成最后的分成两个
        while (fast.next != null)
        {
            fast = fast.next;
            if (fast.next !=null)
                fast = fast.next;
            else
                break;
            slow = slow.next;
        }

        ListNode head1 = head;
        ListNode head2 = slow.next;

        slow.next = null;

        ListNode cur = head2;
        ListNode post = head2.next;
        cur.next = null;
        //翻转第二个链表
        while (post != null)
        {
            ListNode tmp = post.next;
            post.next = cur;
            cur = post;
            post = tmp;

        }
        head2 = cur;

        //两个链表合并
        ListNode node1 = head1;
        ListNode node2 = head2;

        while (node2 != null)
        {
            ListNode tmp1 = node1.next;
            ListNode tmp2 = node2.next;

            node1.next = node2;
            node2.next = tmp1;

            node1 = tmp1;
            node2 = tmp2;
        }
    }
}
