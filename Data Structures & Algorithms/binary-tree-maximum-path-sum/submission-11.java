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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int val = dfs(root);
        //  max = max > val ? max : val;
        return max;
    }

    int dfs(TreeNode root) {
       if(root==null){
       return 0;
       }
       if(root.left==null && root.right==null){
        max = max > root.val ? max : root.val;
        return root.val;
       }
       int left = Math.max(0,dfs(root.left));
       int right = Math.max(0,dfs(root.right));

       max = max > left+right+root.val ? max : left+right+root.val;

       return root.val+Math.max(left,right);

    }
}
