class Solution:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s) < 2:
            return s

        max_len = 1
        res = s[0]
        for i in range(len(s)):
            check_even = s[i - max_len:i + 1]
            check_odd = s[i - max_len - 1:i + 1]
            if i - max_len >= 0 and check_even == check_even[::-1]:
                res = check_even
                max_len += 1
            if i - max_len >= 1 and check_odd == check_odd[::-1]:
                res = check_odd
                max_len += 2
        return res
