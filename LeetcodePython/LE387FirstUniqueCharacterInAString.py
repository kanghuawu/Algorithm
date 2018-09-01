class Solution:
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        from collections import defaultdict
        cnt = defaultdict(int)
        for i in range(len(s)):
            cnt[s[i]]+=1

        for i in range(len(s)):
            if cnt[s[i]] == 1:
                return i
        return -1
