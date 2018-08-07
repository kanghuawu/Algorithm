class Solution:
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        cnt = [0] * 128
        for ch in T:
            cnt[ord(ch)] += 1

        res = ''
        for ch in S:
            if cnt[ord(ch)]:
                res += ch * cnt[ord(ch)]
                cnt[ord(ch)] = 0

        for i in range(128):
            if cnt[i]:
                res += chr(i) * cnt[i]
        return res