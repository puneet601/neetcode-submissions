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
    class Result{
        int height;
        boolean balance;
        public Result(int height, boolean balance){
            this.height = height;
            this.balance = balance;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null)
        return true;
        Result res = height(root);
        return res.balance;
    }

    private Result height(TreeNode root){
        if(root==null)
        return new Result(0,true);
        Result left = height(root.left);
        Result right = height(root.right);
        if(Math.abs(left.height - right.height)>1)
        return new Result(left.height, false);
        if(left.balance==false || right.balance == false)
        return new Result(left.height, false);
        return new Result(Math.max(left.height, right.height)+1,true);
    }
}
