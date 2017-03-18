package Leetecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qinjiawei on 16-12-15.
 */
public class SerializeandDeserializeBST {

    /**
     * 449  序列化和反序列化
     * 1.采用先序遍历的方式序列化，再采用同样的先序遍历反序列化,
     * 按照思路就是把整个树都构建出来, null也用特殊字符表示出来，然后再用先序遍历整回去
     * 2. 我刚开始的想法是处理成先序遍历和中序遍历的结果，然后反序列，但是会超时间
     * @param root
     * @return
     */

    public String serialize(TreeNode root) {

        if (root == null)
            return "$,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        String[] tokens = data.split(",");
        for (String str : tokens)
        {
            queue.add(str);
        }
        return dfs(queue);
    }


    public TreeNode dfs(Queue<String> queue)
    {
        String value = queue.remove();
        if (value.equals("$"))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }
    // Encodes a tree to a single string.
    public String serialize_back(TreeNode root) {
        String preorder = "";
        String inorder = "";
        if (root == null)
            return "-";
        List<String> preorderList = new ArrayList<>();
        List<String> inorderList = new ArrayList<>();

        preorder(root, preorderList);
         inOrder(root, inorderList);
        for (int i =0; i< preorderList.size(); i++)
        {
            if (i== preorderList.size()-1)
                preorder += preorderList.get(i);
            else
                preorder += preorderList.get(i) +",";
        }
        for (int j =0; j< inorderList.size(); j++)
        {
            if(j == inorderList.size() -1)
                inorder += inorderList.get(j);
            else
                inorder += inorderList.get(j) +",";

        }
        return preorder +"-"+inorder;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize_back(String data) {
        TreeNode root = null;
        String[] tokens = data.split("-");
        if (tokens[0].length()<1 || tokens[1].length() <1)
            return root;
        String[] preorder = tokens[0].split(",");
        String[] inorder = tokens[1].split(",");

        return constructTree(0,preorder.length-1,0, inorder.length -1, preorder,inorder);

    }

    public TreeNode constructTree( int pstart, int pend, int istart, int iend, String[] preorder, String[] inorder)
    {
        if(pstart >pend || istart >iend)
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(preorder[pstart]));
        if(pstart == pend || istart == iend)
            return root;
        int tmp= istart;
        while (istart< iend)
        {
            if (preorder[pstart].equals(inorder[istart]))
            {
                break;
            }
            istart++;
        }
        root.left = constructTree(pstart +1, pstart + (istart -tmp), tmp, istart-1,preorder, inorder);
        root.right = constructTree(pstart +(istart -tmp) +1, pend, istart+1, iend, preorder, inorder);
        return  root;

    }
    public void preorder(TreeNode root, List<String> ans)
    {
        if(root == null)
            return ;
//        ans += String.valueOf(root.val)+",";
        ans.add(String.valueOf(root.val));

        if(root.left != null)
             preorder(root.left, ans);
        if (root.right != null)
            preorder(root.right, ans);

    }
    public void inOrder(TreeNode root, List<String> ans)
    {
        if(root == null)
            return ;
        if(root.left != null)
            inOrder(root.left, ans);
//        ans += String.valueOf(root.val)+",";
        ans.add(String.valueOf(root.val));

        if (root.right != null)
            inOrder(root.right, ans);


    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        SerializeandDeserializeBST s = new SerializeandDeserializeBST();
        System.out.println(s.serialize(root));
    }
}
