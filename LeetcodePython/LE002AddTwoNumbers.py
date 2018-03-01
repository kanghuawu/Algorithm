from utility.ListNode import ListNode


class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        inc = False
        dummy = ListNode(0)
        node = dummy
        while l1 or l2 or inc:
            tmp = 0

            if l1:
                tmp += l1.val
                l1 = l1.next
            if l2:
                tmp += l2.val
                l2 = l2.next

            if inc:
                tmp += 1
                inc = False
            if tmp >= 10:
                tmp %= 10
                inc = True
            node.next = ListNode(tmp)
            node = node.next
        return dummy.next

l1 = ListNode(1)
l2 = ListNode(2)
l3 = ListNode(3)
l4 = ListNode(4)
l1.next = l2
l2.next = l3
l3.next = l4
l11 = ListNode(1)
l12 = ListNode(2)
l13 = ListNode(3)
l14 = ListNode(6)
l11.next = l12
l12.next = l13
l13.next = l14


if __name__ == '__main__':
    test = Solution()
    l = test.addTwoNumbers(l1, l11)
    l.print()