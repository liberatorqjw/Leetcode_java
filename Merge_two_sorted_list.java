package Leetecode;

/**
 * Created by qinjiawei on 16-4-18.
 */
public class Merge_two_sorted_list {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode p = head;

        while (l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                if(head == null)
                {
                    head = l1;
                    p = head;
                }
                else
                {
                    p.next = l1;
                    p = p.next;
                }
                l1 = l1.next;
            }
            else {
                if(head == null)
                {
                    head = l2;
                    p = head;
                }
                else
                {
                    p.next = l2;
                    p = p.next;
                }
                 l2 = l2.next;
            }
        }
        if(l1  !=null)
        {
            if(head == null)
            {
                head = l1;

            }
            else

              p.next= l1;
        }
        if(l2 != null)
        {
            if(head == null)
                head =l2;
            else
            p.next = l2;
        }

        return  head;
    }
}
