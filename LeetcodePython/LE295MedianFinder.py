from heapq import *


class MedianFinder:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.big = []
        self.small = []
        self.len = 0

    def addNum(self, num):
        """
        :type num: int
        :rtype: void
        """
        self.len += 1
        heappush(self.small, -heappushpop(self.big, -num))
        if len(self.small) > len(self.big):
            heappush(self.big, -heappop(self.small))

    def findMedian(self):
        """
        :rtype: float
        """
        if self.len % 2 == 1:
            return -self.big[0]
        else:
            return (self.small[0] - self.big[0]) / 2.0

# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()