class Solution:
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        # 2: to be deleted
        # 3: to be created
        if not board or not board[0]:
            return
        m, n = len(board) - 1, len(board[0]) - 1

        def nbs(board, i, j):
            nb = 0
            for r in range(-1, 2):
                for c in range(-1, 2):
                    if i + r < 0 or i + r > m or j + c < 0 or j + c > n or (r == 0 and c == 0):
                        continue
                    if board[i + r][j + c] in [1, 2]:
                        nb += 1
            return nb

        for i in range(m + 1):
            for j in range(n + 1):
                cnt = nbs(board, i, j)
                # print(i, j, cnt)
                if board[i][j] == 1 and cnt <= 1:
                    board[i][j] = 2
                elif board[i][j] == 1 and cnt > 3:
                    board[i][j] = 2
                elif board[i][j] == 0 and cnt == 3:
                    board[i][j] = 3

        for i in range(m + 1):
            for j in range(n + 1):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1


if __name__ == '__main__':
    import random
    li = []
    for _ in range(10):
        li.append((random.randint(0, 20), random.randint(0, 20)))
    print(li)
    li.sort(key=lambda k: -k[1])
    print(li)
