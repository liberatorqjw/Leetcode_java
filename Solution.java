package Leetecode;

import java.util.*;

/**
 * Created by liberator on 16-3-30.
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length <=0)
            return "";
        String prefix = strs[0];
        for(int i=0;i<strs.length;i++)
        {
            if(prefix.length()==0 || strs[i].length()==0)
                return "";
            int len = prefix.length()<strs[i].length()?prefix.length():strs[i].length();
            int j;
            for(j=0; j<len;j++)
            {
                if(strs[i].charAt(j) != prefix.charAt(j))
                {
                    break;
                }
            }
            prefix = prefix.substring(0,j);
        }


        return prefix;
    }
    /*
    19
     */
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
    /*
    20. Valid Parentheses
     */

    public boolean isValid(String s) {


        if(s.length() ==0)
            return Boolean.TRUE;
        int i =0;

        Stack stack = new Stack();
        if(s.length() % 2 !=0)
            return Boolean.FALSE;
        while(i < s.length()) {
            char c1 = s.charAt(i);

            if (c1 == '('||c1 == '[' || c1=='{')
            {
                stack.push(c1);
            }
            else {
                if (stack.isEmpty())
                    return Boolean.FALSE;
                char c2 = (char)stack.pop();
                if (c2 == '(')
                {
                    if (c1 != ')')
                        return Boolean.FALSE;
                }
                else if(c2 == '[')
                {
                    if(c1!= ']')
                        return Boolean.FALSE;
                }
                else if(c2 == '{')
                {
                    if(c1 != '}')
                        return Boolean.FALSE;
                }
            }
            i++;
        }
        if (!stack.isEmpty())
            return Boolean.FALSE;
        return Boolean.TRUE;
    }

    /*
    258
    dr(n) = n - 9*[(n-1)/9]
     */
    public int addDigits(int num) {
           int m = (num -1)/9;
           m *=9;
        return num - m;

    }
    /*

     */
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int maxDepth(TreeNode root) {


        if (root == null)
            return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return l>r ?l+1:r+1;

    }
    /*
    226
     */
    public TreeNode invertTree(TreeNode root) {
            if(root == null)
                return root;
         TreeNode p = root;
        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right);
        p.left = r;
        p.right =l;
        return p;

    }
    /*
     two two compare
     */
    public void moveZeroes(int[] nums) {
          int index =0;
        int length = nums.length;
        for (int i=0; i< length;i++)
        {
            if (nums[i] !=0)
            {
                nums[index++] = nums[i];
            }
        }
        for (;index<length; index++)
            nums[index] =0;

    }
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
    /*

     */
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
    /*
     242. Valid Anagram
     anagram
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return Boolean.FALSE;

        List<Character> list = new ArrayList<>();
        List<Character> list1 = new ArrayList<>();
        for(int i =0; i<s.length();i++)
        {
            list.add(s.charAt(i));
            list1.add(t.charAt(i));
        }
        Collections.sort(list);
        Collections.sort(list1);
        for (int i=0 ; i < list.size(); i++)
        {
            if(list.get(i) != list1.get(i))
                return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    /*
    171. Excel Sheet Column Number
    26 hexadecimal number
     */
    public int pow(int num, int ite){
        for (int i =0; i<ite;i++)
            num *= 26;
        return num;
    }
    public int titleToNumber(String s) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.put("C", 3);
        hashMap.put("D", 4);
        hashMap.put("E", 5);
        hashMap.put("F", 6);
        hashMap.put("G", 7);
        hashMap.put("H", 8);
        hashMap.put("I", 9);
        hashMap.put("J", 10);
        hashMap.put("K", 11);
        hashMap.put("L", 12);
        hashMap.put("M", 13);
        hashMap.put("N", 14);
        hashMap.put("O", 15);
        hashMap.put("P", 16);
        hashMap.put("Q", 17);
        hashMap.put("R", 18);
        hashMap.put("S", 19);
        hashMap.put("T", 20);
        hashMap.put("U", 21);
        hashMap.put("V", 22);
        hashMap.put("W", 23);
        hashMap.put("X", 24);
        hashMap.put("Y", 25);
        hashMap.put("Z", 26);

        int sum =0;
        int j =0;
        for(int i = s.length()-1; i>=0; i--)
        {
            int temp = hashMap.get(String.valueOf(s.charAt(i)));
            sum +=pow(temp, j);
            j++;
        }
        return sum;
    }

}
