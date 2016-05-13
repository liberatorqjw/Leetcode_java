package Leetecode;

/**
 * Created by qinjiawei on 16-5-12.
 */
public class IntersectionofTwoLinkedLists {

    /*
    找到交叉节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        int lenA = getLinkLength(headA);
        int lenB = getLinkLength(headB);

        int lenx =0;
        int i =0;
        if (lenA >lenB) {
            lenx = lenA - lenB;
            while (i <lenx)
            {
                headA = headA.next;
                i++;
            }
        }
        else {
            lenx = lenB - lenA;
            while (i < lenx)
            {
                headB = headB.next;
                i++;
            }
        }

        while (headA != null && headB != null)
        {
            if(headA.val == headB.val)
                return headA;
            headA = headA.next;
            headB = headB.next;

        }
        return null;
    }
    public int getLinkLength(ListNode head)
    {
        int len =0;
        while (head!=null)
        {
            len++;
            head = head.next;
        }
        return len;
    }
}
