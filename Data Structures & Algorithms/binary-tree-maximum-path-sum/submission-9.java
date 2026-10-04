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
        5
    4.     8
 11.     13. 4   
7.  2.
     1         
 *     }
 * }
 */

class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // dfs(root);
        // return max;
        if (root == null)
            return 0;

        int curr = getMax(root);

        max = max > curr ? max : curr;

        return max == Integer.MIN_VALUE ? 0 : max;
    }

    int getMax(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null) {
            max = max > root.val ? max : root.val;
            return root.val;
        }

        int left = getMax(root.left);
        int right = getMax(root.right);

        int curr = root.val;

        curr = curr > left + curr ? curr : left + curr;
        curr = curr > right + curr ? curr : right + curr;
        max = max > curr ? max : curr;
        return Math.max(Math.max(left,right)+root.val,root.val);
    }

    // void dfs(TreeNode root){
    //     if(root==null)
    //     return;

    //     int left = getMax(root.left);
    //     int right = getMax(root.right);

    //     int curr = root.val + left+right;

    //     max = max>curr ? max : curr;

    //     return
    // }
}
