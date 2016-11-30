package Leetecode;

/**
 * Created by qinjiawei on 16-11-11.
 */
public class InsertionSortList {


    /**
     * 插入排序
     * 从小到大排序
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {

        if(head == null|| head.next == null)
            return head;

        ListNode newhead = new ListNode(-1);
        newhead.next = null;

        ListNode cur = null;
        ListNode tmp = null;
        ListNode pre;
        ListNode next;


        //两层循环, 先去一个节点，然后找到位置，进行插入操作，找到小的就直接插入到新的队列中,
        while (head != null)
        {
////             cur = newhead;
//            pre =newhead;
//            next = newhead.next;
//
             tmp = head.next;
//
//            while (next!=null&&next.val<=head.val);
//            {
//                pre = next;
//                next = next.next;
//            }

             pre = searchForInsertPos(newhead, head.val);

            head.next = pre.next;
            pre.next = head;

            //恢复新的头结点
            head = tmp;
        }
        return newhead.next;
    }
    static  ListNode  searchForInsertPos(ListNode head, int val) {
        ListNode pre  = head;
        ListNode next = head.next;
        while(next!=null&&next.val<=val) {
            pre  = next;
            next = next.next;
        }
        return pre;
    }
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        insertionSortList(head);
    }
}
