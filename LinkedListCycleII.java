package Leetecode;

/**
 * Created by qinjiawei on 17-1-7.
 */
public class LinkedListCycleII {
    /**
     * 142 找到一个链表是否存在环，若是存在那么找出环的第一个节点
     * 解析 http://blog.sina.com.cn/s/blog_6f611c300101fs1l.html
     * 主要是定理一样
     * 因为fast的速度是slow的两倍，所以fast走的距离是slow的两倍，有 2(a+b) = a+b+c+b，可以得到a=c（这个结论很重要！）。
     * 由于a =c 那么找到相遇的点以后， 一个点从头开始遍历，另一个从相遇的点开始遍历，这样两个再相遇的时候就是开始的点。
     */
    public ListNode detectCycle(ListNode head) {
        if (head== null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null)
        {
            if (fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
            {
                while (head!= slow)
                {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;

            }
        }

        return null;
    }
}
