# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        dummy = ListNode(0)
        node = dummy
        inc = False
        newval = 0
        while l1 != None or l2 != None or inc :
        	newval = 1 if inc else 0
        	if l1 != None:
        		newval += l1.val
        		l1 = l1.next
        	if l2 != None:
        		newval += l2.val
        		l2 = l2.next
        	inc = True if newval >= 10 else False
        	node.next = ListNode(newval % 10)
        	# print str(node.val)
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

def printList(node):
	while node != None:
		print str(node.val),
		node = node.next

test = Solution()
printList(test.addTwoNumbers(l1, l11))