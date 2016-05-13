package Leetecode;

import javax.swing.event.ListDataEvent;

/**
 * Created by qinjiawei on 16-5-10.
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        if(head == null)
            return head;
        while (head.val == val)
        {
            head = head.next;
            if(head == null)
                return head;
        }

        ListNode pre =head;
        ListNode next = null;

        if(head.next != null)
            next = head.next;
        while (next != null)
        {
            if(next.val == val)
            {
                pre.next = next.next;
                next = pre.next;
            }
            else
            {
                pre = pre.next;
                next = next.next;
            }
        }
        return head;
    }
}
