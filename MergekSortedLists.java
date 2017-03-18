package Leetecode;

/**
 * Created by qinjiawei on 17-1-18.
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length ==0)
            return null;
        return helper(lists, 0, lists.length -1);
    }

    private ListNode helper(ListNode[] lists, int l, int r)
    {
        if (l < r)
        {
            int m = (l+r) /2;
            return merge(helper(lists, l, m), helper(lists, m+1, r));
        }
        return lists[l];
    }

    public ListNode merge(ListNode l, ListNode r)
    {
        ListNode dumpy =new ListNode(0);
         dumpy.next = l;
        ListNode cur = dumpy;

        while ( l != null && r != null)
        {
            if (l.val < r.val)
            {
                l = l.next;
            }
            else
            {
                ListNode next = r.next;
                cur.next = r;
                //默认l的队列就是小的,所以把l再接上
                r.next = l;
                r = next;
            }
            cur = cur.next;
        }
        if (r != null)
            cur.next = r;
        return dumpy.next;
    }
}
