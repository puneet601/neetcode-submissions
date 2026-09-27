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
        return dfs(root, new ArrayList<>(), 0);
    }

    List<List<Integer>> dfs(TreeNode root, List<List<Integer>> levels, int depth) {
        if (root == null)
            return levels;
        List<Integer> level;

        if (levels.size() > depth) {
            level = levels.get(depth);
            level.add(root.val);
            levels.set(depth, level);
        } else {
            level = new ArrayList<>();
            level.add(root.val);
            levels.add(level);
        }

        levels = dfs(root.left, levels, depth + 1);
        levels = dfs(root.right, levels, depth + 1);
        return levels;
    }
}
