package Leetecode;

/**
 * Created by qinjiawei on 16-11-10.
 */
public class SortList {

    public ListNode getMiddle(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null )
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return  head;

        ListNode middle = getMiddle(head);
        ListNode next = middle.next;
        middle.next = null;

        return  merge(sortList(head), sortList(next));

    }

    public ListNode merge(ListNode a, ListNode b)
    {
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        while (a != null && b != null)
        {
            if(a.val < b.val)
            {
                cur.next = a;
                a = a.next;
            }
            else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = a != null?a:b;
        return head.next;
    }
}
