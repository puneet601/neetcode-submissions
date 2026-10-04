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
        String listStr = data.substring(1,data.length()-1);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(listStr.split(",")));
        Queue<TreeNode> q = new LinkedList<>();
        if(list.get(0)=="[]"||list.get(0)=="")
        return null;
        TreeNode head = new TreeNode(Integer.valueOf(list.get(0)));
        q.add(head);
        int i=1;
        while(i<list.size()){
            TreeNode node = q.poll();
           if(node==null)continue;
            if(!list.get(i).trim().equals("null")){
            node.left = new TreeNode(Integer.valueOf(list.get(i).trim()));
            }
            i++;
            if(!list.get(i).trim().equals("null"))
            node.right = new TreeNode(Integer.valueOf(list.get(i).trim()));
            i++;
            if(node!=null)
            q.add(node.left);
            if(node!=null)
            q.add(node.right);
        }
        return head;
    }

    String levelOrderTraversal(TreeNode root){
        if(root==null)
        return "[]";
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode top = q.poll();
            if(top!=null)
            list.add(top.val);
            else
            list.add(null);
            if(top!=null){
                q.add(top.left);
                q.add(top.right);
            }
        }
    return list.toString();
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));