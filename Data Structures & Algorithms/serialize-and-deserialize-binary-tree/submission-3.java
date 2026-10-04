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
        return levelOrderTraversal(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(data.split(",")));
        Queue<TreeNode> q = new LinkedList<>();
        if (list.get(0).equals(""))
            return null;
        TreeNode head = new TreeNode(Integer.valueOf(list.get(0)));
        q.add(head);
        int i = 1;
        while (i < list.size()) {
            TreeNode node = q.poll();
            if (node == null)
                continue;
            if (!list.get(i).equals("N")) {
                node.left = new TreeNode(Integer.valueOf(list.get(i)));
            }
            i++;
            if (!list.get(i).equals("N"))
                node.right = new TreeNode(Integer.valueOf(list.get(i)));
            i++;
            q.add(node.left);
            q.add(node.right);
        }
        return head;
    }

    String levelOrderTraversal(TreeNode root) {
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
        System.out.println(str);
        return str.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));