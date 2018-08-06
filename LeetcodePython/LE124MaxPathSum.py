class Solution:
    def __init__(self):
        self.max = float("-inf")

    def maxPathSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.recursion(root)
        return self.max

    def recursion(self, root):
        if root is None:
            return 0
        left = max(self.recursion(root.left), 0)
        right = max(self.recursion(root.right), 0)
        self.max = max(self.max, left + right + root.val)
        return max(left, right) + root.val