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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        
        return findRoot(root,subRoot);

    }

    private boolean findRoot(TreeNode root, TreeNode subRoot){
    
        if(root==null && subRoot==null)
        return true;

        if(root==null)
        return false;

        if(root.val == subRoot.val && isSameTree(root,subRoot))
         return true;

        boolean left = findRoot(root.left,subRoot);
        boolean right = findRoot(root.right, subRoot);

        return left || right;

    }

    private boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null && q==null)
        return true;
        if(p==null || q==null)
        return false;
        if(p.val!=q.val)
        return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
