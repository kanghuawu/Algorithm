from heapq import heappush, heappop, heapify
from collections import defaultdict
from sortedcontainers import SortedDict

# https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/BinaryMinHeap.java

class Node:
    def __init__(self, wght, key):
        self.wght = wght
        self.key = key

    def __str__(self):
        return "{}: {}".format(self.key, self.wght)

    def __hash__(self):
        return hash(self.key)

class MinHeap:
    def __init__(self):
        self.nodes = []
        self.node_key_pair = {}

    def add(self, wght, key):
        node = Node(wght, key)
        self.nodes.append(node)
        size = len(self.nodes)
        self.node_key_pair[key] = size - 1
        self.swim(node)

    def decrease_key(self, key, wght):
        idx = self.node_key_pair[key]
        node = self.nodes[idx]
        node.wght = wght
        self.swim(node)

    def swim(self, node):
        cur_idx = self.node_key_pair[node.key]
        parent_idx = (cur_idx - 1) // 2
        while parent_idx >= 0:
            parent = self.nodes[parent_idx]
            cur = self.nodes[cur_idx]
            if parent.wght > cur.wght:
                self.swap(parent, cur, parent_idx, cur_idx)
                parent_idx, cur_idx = (parent_idx - 1) // 2, parent_idx
            else:
                break

    def get_min(self):
        return self.nodes[0].key

    def pop_min(self):
        min_node = self.nodes[0]
        max_node = self.nodes[-1]
        self.swap(min_node, max_node, 0, len(self.nodes) - 1)
        self.nodes.pop()
        self.node_key_pair.pop(min_node.key)
        if self.nodes:
            self.sink(max_node)
        return min_node.key

    def sink(self, node):
        cur_idx = self.node_key_pair[node.key]
        while 2 * cur_idx + 1  < len(self.nodes):
            child_idx = 2 * cur_idx + 1
            if child_idx + 1 < len(self.nodes) and self.nodes[child_idx].wght > self.nodes[child_idx + 1].wght:
                child_idx += 1
            if self.nodes[cur_idx].wght < self.nodes[child_idx].wght:
                break
            self.swap(self.nodes[cur_idx], self.nodes[child_idx], cur_idx, child_idx)
            cur_idx = child_idx


    def swap(self, node1, node2, idx1, idx2):
        self.nodes[idx1], self.nodes[idx2] = self.nodes[idx2], self.nodes[idx1]
        self.node_key_pair[node1.key] = idx2
        self.node_key_pair[node2.key] = idx1

    def __contains__(self, key):
        return key in self.node_key_pair

    def __len__(self):
        return len(self.nodes)

    def __str__(self):
        return ", ".join([str(node) for node in self.nodes])

# https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
# https://www.geeksforgeeks.org/dijkstras-algorithm-for-adjacency-list-representation-greedy-algo-8/

class Dijkestra:
    def __init__(self, n):
        self.vertices = n
        self.graph = defaultdict(list)

    def add_edge(self, u, v, w):
        self.graph[u].append([v, w])
        self.graph[v].append([u, w])

    def get_min_dist(self, s):
        parent = {s: None}
        dist = {i: float('inf') for i in range(self.vertices)}
        dist[s] = 0
        pq = MinHeap()
        pq.add(0, s)
        while pq:
            cur = pq.pop_min()
            for nxt, wght in self.graph[cur]:
                self.relax(cur, nxt, wght, dist, parent, pq)

        print(sorted(parent.items()))
        print(sorted(dist.items()))

    def relax(self, cur, nxt, wght, dist, parent, pq):
        if dist[cur] + wght < dist[nxt]:
            dist[nxt] = dist[cur] + wght
            parent[nxt] = cur
            if nxt in pq:
                pq.decrease_key(nxt, dist[nxt])
            else:
                pq.add(dist[nxt], nxt)


if __name__ == '__main__':
    # heap = MinHeap()
    # heap.add(3, "A")
    # heap.add(4, "B")
    # heap.add(8, "C")
    # heap.add(10, "D")
    # heap.add(5, "E")
    # heap.add(6, "F")
    # heap.add(2,"G")
    # heap.decrease_key("D", 1)
    # print(heap)
    # print(sorted(heap.node_key_pair.items(), key=lambda it: it[1]))
    # print(heap.get_min())
    # print(heap.pop_min())
    # print(heap)
    # print(sorted(heap.node_key_pair.items(), key=lambda it: it[1]))
    d = Dijkestra(9)
    d.add_edge(0, 1, 4)
    d.add_edge(0, 7, 8)
    d.add_edge(1, 7, 11)
    d.add_edge(7, 8, 7)
    d.add_edge(7, 6, 1)
    d.add_edge(1, 2, 8)
    d.add_edge(2, 8, 2)
    d.add_edge(8, 6, 6)
    d.add_edge(2, 3, 7)
    d.add_edge(2, 5, 4)
    d.add_edge(6, 5, 2)
    d.add_edge(3, 2, 14)
    d.add_edge(3, 4, 9)
    d.add_edge(3, 5, 14)
    d.add_edge(5, 4, 10)
    d.get_min_dist(0)
