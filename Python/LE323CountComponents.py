class Solution(object):
    def countComponents(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: int
        """
        graph = {e: [] for e in range(n)}

        for e1, e2 in edges:
            graph[e1].append(e2)
            graph[e2].append(e1)

        visited = [False] * n

        res = 0
        for i in range(n):
            if not visited[i]:
                self.dfs(i, graph, visited)
                res += 1

        return res

    def dfs(self, idx, graph, visited):
        if visited[idx]:
            return
        visited[idx] = True
        for nb in graph[idx]:
            self.dfs(nb, graph, visited)

if __name__ == '__main__':
    test = Solution()
    print(test.countComponents(5, [[0,1],[1,2],[3,4]]))