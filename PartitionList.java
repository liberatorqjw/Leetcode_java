package Leetecode;

/**
 * Created by qinjiawei on 17-1-13.
 */
public class PartitionList {


    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return head;

        ListNode pre = null;
        ListNode p= null;

        ListNode tail= null;
        ListNode t= null;


        while (head != null)
        {
            if (head.val < x)
            {
                if (pre == null)
                {
                    pre = head;
                    p = pre;

                }
                else {
                    p.next = head;
                    p = head;
                }

                head = head.next;
                p.next = null;
            }
            else
            {
                if (tail == null)
                {
                    tail = head;
                    t = tail;

                }
                else {
                    t.next = head;
                    t = head;
                }

                head = head.next;
                t.next = null;
            }

        }
        if (pre != null)
        {
            p.next = tail;
            return pre;
        }
        else
            return tail;
    }
}
