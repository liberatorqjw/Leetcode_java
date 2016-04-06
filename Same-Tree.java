 public boolean isSameTree(TreeNode p, TreeNode q) {

        Boolean flag = false;
        if (p==null && q == null)
            return Boolean.TRUE;
        else if(p==null && q !=null)
            return Boolean.FALSE;
        else if(p != null && q == null)
            return Boolean.FALSE;
        if(p.val != q.val)
            return Boolean.FALSE;
        else if (p.val == q.val)
            flag = Boolean.TRUE;

        if(p.left !=null && q.left !=null)
            flag = isSameTree(p.left,q.left);
        else if((p.left == null && q.left != null )||(p.left !=null && q.left == null))
            return Boolean.FALSE;

        if(flag == Boolean.FALSE)
            return flag;

        if(p.right !=null && q.right !=null)
            flag = isSameTree(p.right, q.right);
        else if((p.right == null && q.right != null )||(p.right !=null && q.right == null))
            return Boolean.FALSE;

        if(flag == Boolean.FALSE)
            return flag;
        return Boolean.TRUE;
    }