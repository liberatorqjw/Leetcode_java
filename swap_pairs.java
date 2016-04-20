package Leetecode;

/**
 * Created by qinjiawei on 16-4-18.
 */
public class swap_pairs {
/*
    public ListNode swapPairs(ListNode head) {
        ListNode newhead =null;
        ListNode p;

        if(head == null)
            return newhead;
        while (head != null && head.next !=null )
        {
            ListNode t = head.next.next;
            if(newhead == null)
            {
                newhead = head.next;
                newhead.next = head;
                p = newhead.next.next;
            }
            else {
                p = head.next;
                p.next = head;
                p = p.next;
            }
            head = t;
        }
        if(head != null)
            p = head;
        return newhead;
    }

    */
    //只是交换节点
public ListNode swapPairs(ListNode head) {

    ListNode helper = new ListNode(0);
    helper.next = head;
    ListNode n1 = helper, n2 = head;

    while(n2 !=null && n2.next !=null)
    {
        ListNode tmp = n2.next.next;
        n2.next.next = n1.next;
        n1.next = n2.next;
        n2.next = tmp;
        n1 =n2;
        n2 =n1.next;
    }
    return helper.next;
}
}
