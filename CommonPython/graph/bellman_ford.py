"""
https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
"""

from collections import defaultdict

class BellmanFord:
    def __init__(self, n):
        self.vertices = n
        self.graph = []

    def add_edge(self, u, v, w):
        self.graph.append([u, v, w])

    def get_min_dist(self, s):
        if not 0 <= s < self.vertices:
            raise Exception("Invalid source")

        dist = {i: float('inf') for i in range(self.vertices)}
        parent = {i: None for i in range(self.vertices)}
        dist[s] = 0

        for _ in range(self.vertices - 1):
            for u, v, w in self.graph:
                if dist[v] > dist[u] + w:
                    dist[v] = dist[u] + w
                    parent[v] = u

        for u, v, w in self.graph:
            if dist[v] > dist[u] + w:
                raise Exception("Has cycle")

        print(sorted(dist.items()))
        print(sorted(parent.items()))

if __name__ == '__main__':
    b = BellmanFord(5)
    b.add_edge(0, 1, -1) 
    b.add_edge(0, 2, 4) 
    b.add_edge(1, 2, 3) 
    b.add_edge(1, 3, 2) 
    b.add_edge(1, 4, 2) 
    b.add_edge(3, 2, 5) 
    b.add_edge(3, 1, 1) 
    b.add_edge(4, 3, -3)
    b.get_min_dist(0) 

    # has cycle
    b = BellmanFord(5)
    b.add_edge(0, 1, 1)
    b.add_edge(1, 2, 3)
    b.add_edge(2, 3, 2)
    b.add_edge(3, 1, -6)
    b.get_min_dist(0) 
