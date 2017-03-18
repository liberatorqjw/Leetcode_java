package Leetecode;

/**
 * Created by qinjiawei on 17-1-7.
 */
public class LinkedListCycle {

    /**
     * 141 寻找一个链表中是否存在环， 不使用额外的空间
     *
     * 思路是两个指针，一个快 一个慢。 当慢的和快的相同了表示快的追上了快的, 那么就表示存在环
     */
    public boolean hasCycle(ListNode head) {

        if (head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null)
        {
            if (fast.next == null)
                return false;
            fast= fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
