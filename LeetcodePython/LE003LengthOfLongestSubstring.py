class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        dic = {}
        res = 0
        j = 0
        for i in range(n):
            ch = s[i]
            if ch in dic:
                res = max(i - j, res)
                j = max(dic[ch] + 1, j)
            dic[ch] = i
        return max(res, len(s) - j)
