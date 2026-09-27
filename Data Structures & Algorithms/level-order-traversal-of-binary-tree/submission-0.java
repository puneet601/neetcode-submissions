/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> levels = new ArrayList<>();

        while(!queue.isEmpty()){
            int s = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode curr = queue.poll();
                if(curr==null)
                return levels;
                level.add(curr.val);
                if(curr.left!=null)
                queue.add(curr.left);
                if(curr.right!=null)
                queue.add(curr.right);
            }
            levels.add(level);
        }
        return levels;
    }
}
