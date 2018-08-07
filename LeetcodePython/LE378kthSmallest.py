from heapq import *


class Solution:
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        if matrix is None or not matrix:
            return 0
        pq = []
        r, c = len(matrix), len(matrix[0])
        for i in range(r):
            heappush(pq, (matrix[i][0], i, 0))

        for _ in range(k - 1):
            cur = heappop(pq)
            if cur[2] == c - 1:
                continue
            heappush(pq, (matrix[cur[1]][cur[2] + 1], cur[1], cur[2] + 1))

        return pq[0][0]