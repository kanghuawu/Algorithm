from heapq import *


class Solution:
    def kSmallestPairs(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[List[int]]
        """
        if not nums1 or not nums2:
            return []

        pq = []
        for i in range(min(k, len(nums1))):
            heappush(pq, (nums1[i] + nums2[0], nums1[i], nums2[0], 0))

        res = []
        for _ in range(k):
            if not pq:
                break
            cur = heappop(pq)
            res.append([cur[1], cur[2]])
            if cur[3] == len(nums2) - 1:
                continue
            heappush(pq, (cur[1] + nums2[cur[3] + 1], cur[1], nums2[cur[3] + 1], cur[3] + 1))

        return res