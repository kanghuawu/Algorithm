class SolutionIteration:
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        dummy = ListNode(0)
        dummy.next = head
        node = head

        while node and node.next:
            tmp = node.next
            node.next = tmp.next
            tmp.next = dummy.next
            dummy.next = tmp

        return dummy.next


class SolutionRecursion:
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next:
            return head

        next_node = head.next
        new_head = self.reverseList(head.next)
        next_node.next = head
        head.next = None
        return new_head