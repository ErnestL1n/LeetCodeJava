# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#recursive
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        def inorder(res:List[int],root:TreeNode):
            if root:
                inorder(res,root.left)
                res.append(root.val)
                inorder(res,root.right)
        res=[]
        inorder(res,root)
        return res
        

#iteration stack

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        stk,res=[],[]
        while stk or root:
            while root:
                stk.append(root)
                root=root.left
            root=stk[-1]
            stk.pop()
            res.append(root.val)
            root=root.right
        return res