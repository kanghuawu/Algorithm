class Solution:
    def checkInclusion(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        m, n = len(s1), len(s2)
        s1_ar, s2_ar = [0] * 128, [0] * 128
        for ch in s1:
            s1_ar[ord(ch)] += 1

        for i in range(n):
            s2_ar[ord(s2[i])] += 1
            if i - m >= 0:
                s2_ar[ord(s2[i - m])] -= 1

            if s1_ar == s2_ar:
                return True

        return False