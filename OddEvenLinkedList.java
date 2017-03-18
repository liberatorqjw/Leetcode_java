package Leetecode;

/**
 * Created by qinjiawei on 17-1-7.
 */
public class OddEvenLinkedList {

    /**
     * 328 把链表分成奇数偶数两个部分，这里的奇数偶数说的是节点的位置，不是节点里面的数字
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        int count =1;
        ListNode node = head.next;
        ListNode p = node;
        ListNode q = head;
        ListNode cur = node.next;
        node.next = null;

        while (cur != null)
        {
            // 奇数个节点
            if (count %2 ==1)
            {
                q.next =cur;
                q = cur;
//                cur = cur.next;
            }
            else
            {
                p.next = cur;
                p = cur;
            }
            cur = cur.next;
            count++;
        }
        p.next = null;
        q.next = node;


        return head;
    }
    public static void main(String[] args)
    {
        OddEvenLinkedList od = new OddEvenLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        od.oddEvenList(head);
    }
}
