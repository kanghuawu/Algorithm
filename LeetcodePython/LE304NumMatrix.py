class NumMatrix:

    def __init__(self, matrix):
        """
        :type matrix: List[List[int]]
        """
        if not matrix or not matrix[0]:
            return
        m, n = len(matrix), len(matrix[0])
        self.dp = [[0 for j in range(n + 1)] for i in range(m + 1)]

        for i in range(0, m):
            for j in range(0, n):
                self.dp[i + 1][j + 1] = self.dp[i + 1][j] + self.dp[i][j + 1] - self.dp[i][j] + matrix[i][j]

    def sumRegion(self, row1, col1, row2, col2):
        """
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        area1 = self.dp[row1][col1]
        area2 = self.dp[row1][col2 + 1]
        area3 = self.dp[row2 + 1][col1]
        area4 = self.dp[row2 + 1][col2 + 1]

        return area4 - area2 - area3 + area1