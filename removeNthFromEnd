  public class ListNode {
           int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int length =0;
        if(head == null)
            return head;
        ListNode p = head;

        if(p !=null)
        {
            length +=1;
            p = p.next;
        }

        int m = length -n;
        m +=1;
        if(m==1)
            return head.next;

        int index =0;
        p = head;
        while(p!=null)
        {
            index +=1;
            if(index ==m-1)
            {
                p.next = p.next.next;
            }
            p = p.next;
        }

        return  head;

    }