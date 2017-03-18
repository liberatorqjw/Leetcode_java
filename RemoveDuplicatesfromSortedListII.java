package Leetecode;

/**
 * Created by qinjiawei on 17-1-15.
 */
public class RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates_II(ListNode head) {

        if(head == null)
            return head;

        ListNode pre = head;
        ListNode next = head.next;

//        while (next != null)
//        {
//            if (pre.val == next.val)
//            {
//                pre = pre.next;
//                next = next.next;
//            }
//            else
//            {
//
//            }
//        }
        while (head.next != null && head.next.next != null)
        {
            if (head.next.val == head.val)
            {
                int val = head.val;
                while (head.next != null && head.next.val == val)
                {
                    head = head.next;
                }

            }
            else if (head.next.val == head.next.next.val)
            {
                int val = head.next.val;
                while (head.next != null && head.next.val == val)
                {
                    head.next = head.next.next;
                }

            }
            else
            {
                head = head.next;
            }
        }
        return pre;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }
}
