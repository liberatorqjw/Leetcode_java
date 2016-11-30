package Leetecode;

/**
 * Created by qinjiawei on 16-5-5.
 */
public class PalindromeLinkedList {

    /*
    判断回文 O(n) time and O(1) space
    用快慢指针 把原来的链表进行拆分
    然后把其中的一个一半链表进行翻转
    然后两个一半的链表进行比较就好
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode middle = paridition(head);
        middle = reverse(middle);

        while (head != null && middle != null)
        {
            if (head.val != middle.val)
                return false;
            head = head.next;
            middle = middle.next;
        }
        return  true;
    }

    public ListNode paridition(ListNode head)
    {
        ListNode p = head;
        while (p.next !=null && p.next.next !=null)
        {
            //这样的交替进行，就会一奇数 偶数交替进行
            p = p.next.next;
            head = head.next;
        }
        p = head.next;
        head.next = null;

        return p;
    }

    /*
    head insert method
     */
    public ListNode reverse(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode cur = head.next;
        pre.next = null;
        ListNode ntx = null;

        while (cur != null)
        {
            ntx = cur.next;
            cur.next = pre;
            pre = cur;
            cur = ntx;
        }
        return pre;

    }

}
