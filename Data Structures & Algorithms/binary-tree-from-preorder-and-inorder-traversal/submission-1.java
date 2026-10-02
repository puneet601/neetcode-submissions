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
    int pin = 0;
    int in = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder,inorder,Long.MAX_VALUE);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, long limit) {

        if(pin == preorder.length)
        return null;

        if(inorder[in]==limit){
            in++;
        return null;
        }

        TreeNode root = new TreeNode(preorder[pin++]);
        root.left = dfs(preorder,inorder,root.val);
        root.right = dfs(preorder,inorder,limit);
        
        return root;
    }
}
