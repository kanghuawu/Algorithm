class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        re = int(str(abs(x))[::-1])
        return 0 if re > 2 ** 31 else re if x > 0 else re * -1
