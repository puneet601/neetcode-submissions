/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode top = q.poll();
            if (top != null) {
                str.append(top.val);
                q.add(top.left);
                q.add(top.right);
            } else
                str.append("N");
            str.append(",");
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String list[] = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode head = new TreeNode(Integer.valueOf(list[0]));
        q.add(head);
        int i = 1;
        while (i < list.length) {
            TreeNode node = q.poll();
            if (!list[i].equals("N")) {
                node.left = new TreeNode(Integer.valueOf(list[i]));
            }
            i++;
            if (!list[i].equals("N"))
                node.right = new TreeNode(Integer.valueOf(list[i]));
            i++;
            if(node.left!=null)
            q.add(node.left);
            if(node.right!=null)
            q.add(node.right);
        }
        return head;
    }

   
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));