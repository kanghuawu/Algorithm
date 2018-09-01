class Solution:
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return 0
        from collections import deque

        stack = deque()
        i = 0
        sign = '+'
        n = len(s)
        for j in range(n + 1):
            if j < n and (s[j].isdigit() or s[j].isspace()):
                continue

            if sign == '+':
                stack.append(int(s[i:j]))
            elif sign == '-':
                stack.append(-int(s[i:j]))
            elif sign == '*':
                stack.append(stack.pop() * int(s[i:j]))
            else:
                tmp = stack.pop()
                num = int(s[i:j])
                if tmp // num < 0 and tmp % num != 0:
                    stack.append(tmp // num + 1)
                else:
                    stack.append(tmp // num)

            if j < n:
                sign = s[j]
                i = j + 1

        return sum(stack)
