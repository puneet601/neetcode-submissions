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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return isCommonAncestor(root,p,q);
        
    }

    TreeNode isCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root.val<p.val && root.val>q.val)
        return root;

        if(root.val>p.val && root.val<q.val)
        return root;

        if(root == p)
        return root;

        if(root==q)
        return root;

        if(root.val<p.val && root.val <q.val)
        return isCommonAncestor(root.right,p,q);

        if(root.val>p.val && root.val >q.val)
        return isCommonAncestor(root.left,p,q);

        return null;

    }
}
