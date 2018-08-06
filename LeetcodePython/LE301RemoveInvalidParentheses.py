class Solution:
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        rmL, rmR = 0, 0
        for c in s:
            if c == '(':
                rmL += 1
            elif c == ')':
                if rmL:
                    rmL -= 1
                else:
                    rmR += 1

        res = set()

        def recursion(s, i, rmL, rmR, open, st):
            if rmL < 0 or rmR < 0 or open < 0:
                return
            if i == len(s):
                if rmL == 0 and rmR == 0 and open == 0:
                    res.add(str(st))
                return
            if s[i] == '(':
                recursion(s, i + 1, rmL - 1, rmR, open, st)
                recursion(s, i + 1, rmL, rmR, open + 1, st + s[i])
            elif s[i] == ')':
                recursion(s, i + 1, rmL, rmR - 1, open, st)
                recursion(s, i + 1, rmL, rmR, open - 1, st + s[i])
            else:
                recursion(s, i + 1, rmL, rmR, open, st + s[i])

        recursion(s, 0, rmL, rmR, 0, "")
        return list(res)