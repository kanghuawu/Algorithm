class Solution:
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """
        if not head:
            return

        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        mid = slow.next
        slow.next = None
        prev = None
        while mid:
            nxt = mid.next
            mid.next = prev
            prev = mid
            mid = nxt

        dum = ListNode(0)
        it = dum
        while prev:
            it.next = head
            head = head.next
            it = it.next
            it.next = prev
            prev = prev.next
            it = it.next
        if head:
            it.next = head