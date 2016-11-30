package Leetecode;

/**
 * Created by qinjiawei on 16-10-22.
 */
public class LinkedListRandomNode {

    ListNode head = null;

    int len =0;
    //很关键的随机因子
    public static int randomMax = 32767;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
    }

    public int getRandom()
    {
        int rd = (int) (Math.random() * randomMax % len);
        int index =0;
        ListNode p = head;
        while (index <rd)
        {
            p = p.next;
            index++;
        }
        return p.val;
    }

    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        LinkedListRandomNode linkedListRandomNode = new LinkedListRandomNode(head);
        for (int i =0; i< 100; i++)
        {
           System.out.println(linkedListRandomNode.getRandom());
        }
    }
}
