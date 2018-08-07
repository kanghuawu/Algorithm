# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        li = []
        def dfs(s, root):
            if not root.left and not root.right:
                li.append(int(s+str(root.val)))
                return
            if root.left:
                dfs(s+str(root.val), root.left)
            if root.right:
                dfs(s+str(root.val), root.right)
        dfs("", root)
        sum = 0
        for s in li:
            sum += int(s)
        return sum