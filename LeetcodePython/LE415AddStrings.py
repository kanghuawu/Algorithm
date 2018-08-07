class Solution:
    def addStrings(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        i, j = len(num1) - 1, len(num2) - 1
        carry = 0
        res = ""

        while i >= 0 or j >= 0 or carry > 0:
            total = 0
            if i >= 0:
                total += int(num1[i])
                i -= 1
            if j >= 0:
                total += int(num2[j])
                j -= 1
            total += carry
            res = str(total % 10) + res

            if total >= 10:
                carry = total // 10
            else:
                carry = 0
        return res