package Leetecode;

/**
 * Created by qinjiawei on 16-5-15.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        /*
        数值作和
         */
        int var =0;
        int cur =0;

        ListNode head = l1;
        ListNode p = head;
        if(l1 != null)
        {
            head = l1;
            p = head;
        }
        else if (l2 != null)
        {
            head = l2;
            p = head;
        }
        while (l1 != null && l2 != null)
        {
            cur =  var + l1.val + l2.val;
            if (cur >=10)
            {
                cur -=10;
                var =1;
            }
            else
            var =0;
            l1.val = cur;
            p = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null)
        {
            cur = l1.val + var;
            if (cur >=10)
            {
                cur -=10;
                var =1;
            }
            else
                var =0;
            l1.val = cur;
            p =l1;
            l1 = l1.next;
        }
        while (l2 != null)
        {
            cur = l2.val + var;
            if (cur >=10)
            {
                cur -=10;
                var =1;
            }
            else
                var =0;
            ListNode node = new ListNode(cur);
            p.next = node;
            p = node;
            l2 = l2.next;
        }
        if(var ==1)
        {
            ListNode node = new ListNode(var);
            p.next = node;
            p = node;
        }
        return head;
    }
}
