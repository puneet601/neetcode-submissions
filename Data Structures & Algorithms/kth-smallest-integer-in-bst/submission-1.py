# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        list=[]
        count=k
        def inOrder(root):
            nonlocal count
            if root.left:
                inOrder(root.left)
            
            list.append(root.val)
            count-=1
            if(count==0):
                return
            if root.right:
                inOrder(root.right)
        
        inOrder(root)
        return list[k-1]

            