class Solution:
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        m, n = len(s), len(p)
        if m < n:
            return []
        s_ar, p_ar = [0]*123, [0]*123
        for ch in p:
            p_ar[ord(ch)]+=1
        res = []
        for i in range(0, m):
            s_ar[ord(s[i])]+=1
            if s_ar == p_ar:
                res.append(i-n+1)
            if i-n+1 >= 0:
                s_ar[ord(s[i-n+1])]-=1
        return res