package Leetecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qinjiawei on 16-12-15.
 */
public class SerializeandDeserializeBinaryTree {

    /**
     * 297
     * 序列化和反序列化
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "$,";
        return root.val + "," + serialize(root.left) + serialize(root.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");

        Queue<String> queue = new LinkedList<>();

        for (String value:tokens)
        {
            queue.add(value);
        }

        return dfs(queue);
    }

    public TreeNode dfs(Queue<String> queue)
    {
        String value = queue.remove();

        if (value.equals("&"))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }
}
