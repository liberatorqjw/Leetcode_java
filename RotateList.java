package Leetecode;

/**
 * Created by qinjiawei on 17-1-19.
 */
public class RotateList {

    /**
     * 61 题目意思就是在链表中循环文件
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight_(ListNode head, int k) {

        if (head == null || k ==0)
            return  head;

        int len = 0;
        //翻转整体
        ListNode cur = head;
        ListNode post = head.next;

        len +=1;
        while (post != null)
        {
            ListNode tmp =post.next;
            post.next = cur;
            cur = post;
            post = tmp;

            len++;
        }
        head = cur;

        ListNode head1 = head;
        ListNode head2 = null;
        ListNode node  = head1;

        k = k %len;
        if (k ==0)
        {
             cur = head;
             post = head.next;

            len +=1;
            while (post != null)
            {
                ListNode tmp =post.next;
                post.next = cur;
                cur = post;
                post = tmp;

                len++;
            }
            head = cur;
            return head;
        }
        else {
            while (k >= 0 && node != null) {
                node = node.next;
                k--;
            }
            ListNode tmp = node.next;

        }

        return null;
    }

    /**
     * 思路就是快 慢指针
     * 快的间隔就是要走的 间隔 k
     * 这个时候快的到达尾了，那么慢的走到的就是要翻转的间隔。
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k ==0)
        {
            return  head;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode countlen = head;

        ListNode newhead = new ListNode(0);

        int len = 0;
        //求长度
        while (countlen != null)
        {
            len++;
            countlen = countlen.next;
        }


        k = k % len;
        if (k ==0)
            return head;

        for (int i =0; i< k; i++)
            fast = fast.next;

        while (fast.next != null)
        {
            slow = slow.next;
            fast = fast.next;
        }

        newhead = slow.next;
        fast.next = head;
        slow.next = null;
        return  newhead;

    }

}
