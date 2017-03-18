package Leetecode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by qinjiawei on 17-1-13.
 */
public class ReverseLinkedListII {

    /**
     * 92 题目的意思是给定两个链表的位置 m n
     * 然后调转链表的位置，是把m到n之间的所有节点都变换一下。
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null)
            return head;

        ListNode node = head;
        ListNode p = null;
        ListNode q = null;

        Stack<ListNode> stack =  new Stack<>();
        int count =1;
        while (head != null)
        {
            if (count == m-1)
                p = head;
            if (count == n+1)
                q = head;
            if(count >= m && count <= n)
                stack.add(head);
            count++;
            head = head.next;
        }
        ListNode tmp = null;
        ListNode pre = null;
        while (!stack.isEmpty())
        {
            if (tmp == null)
            {
                tmp = stack.pop();
                pre = tmp;
                pre.next = null;
            }
            else
            {
                pre.next = stack.pop();
                pre = pre.next;
                pre.next = null;
            }
        }
        if (p == null && q == null)
            return tmp;
         if (p == null)
         {
             pre.next = q;
             return tmp;
         }
        else
         {
             p.next = tmp;
             pre.next = q;
             return node;
         }


    }

    public static void main(String[] args) {

        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
//        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(5);

        ReverseLinkedListII  r = new ReverseLinkedListII();

        r.reverseBetween(l, 1, 2);
    }
}
