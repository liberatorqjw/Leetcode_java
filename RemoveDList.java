package Leetecode;

/**
 * Created by qinjiawei on 16-4-14.
 */
public class RemoveDList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p ,q;
        if (head == null || head.next == null)
            return head;
        p = head;
        q = head.next;
        while(q != null)
        {
            if(p.val == q.val) {
                p.next = q.next;
                q = p.next;
            }
            else {
                p = p.next;
                q= q.next;
            }

        }
        return head;
    }
}
