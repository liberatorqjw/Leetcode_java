package Leetecode;

import java.util.Stack;

/**
 * Created by liberator on 16-4-7.
 */


public class Reverse_Linked_List {

  public ListNode reverseList(ListNode head) {
        if(head== null)
            return head;
        Stack<ListNode> stack = new Stack<>();
        while (head !=null)
        {
            stack.push(head);
            head = head.next;
        }
        ListNode p =null;
        ListNode tmp =null;
        head =p;
        while (!stack.isEmpty())
        {
            tmp = stack.pop();
            if(p==null)
            {
                p = tmp;
                head =p;
            }
            else {
                p.next = tmp;
                p= tmp;
            }
        }
      //take care of this
      p.next=null;
        return head;

    }
}
