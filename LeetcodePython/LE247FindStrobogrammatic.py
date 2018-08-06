class Solution:
    def findStrobogrammatic(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        dic = {'0': '0', '1': '1', '6': '9', '8': '8', '9': '6'}
        li = []

        def recursion(s, i, buf):
            if i == (n + 1) // 2:
                li.append(''.join(buf))
                return
            if i == 0 and n > 1:
                num = '1689'
            elif n % 2 == 1 and i == n // 2:
                num = '018'
            else:
                num = '01689'

            for ch in num:
                buf[i] = ch
                buf[n - 1 - i] = dic[ch]
                recursion(n, i + 1, buf)

        recursion(n, 0, [''] * n)

        return li