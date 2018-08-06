class Solution:
    def isStrobogrammatic(self, num):
        """
        :type num: str
        :rtype: bool
        """
        i, j = 0, len(num) - 1
        pair = {'0': '0', '1': '1', '6': '9', '8': '8', '9': '6'}
        while i <= j:
            if num[i] in pair and pair[num[i]] == num[j]:
                i += 1
                j -= 1
            else:
                return False

        return True
