
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

    def print(self):
        while self != None:
            print(str(self.val))
            self = self.next