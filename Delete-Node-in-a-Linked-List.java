   /*
    delete  node from the list
    change value  and  to delete the next node
     */

    public void deleteNode(ListNode node) {
        if(node == null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }