

class UF:
	def __init__(self, n):
		self.cnt = n
		self.parent = {k: k for k in range(n)}
		self.size = {k: 1 for k in range(n)}
	
	def find(self, node):
		while node != self.parent[node]:
			self.parent[node] = self.parent[self.parent[node]]
			node = self.parent[node]
		return node

	def connect(self, node1, node2):
		return self.find(node1) == self.find(node2)

	def union(self, node1, node2):
		p1 = self.find(node1)
		p2 = self.find(node2)
		if p1 == p2:
			return
		if self.size[p1] > self.size[p2]:
			self.parent[p2] = p1
			self.size[p1] += self.size[p2]
		else:
			self.parent[p1] = p2
			self.size[p2] += self.size[p1]
		self.cnt -= 1

'''
https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/
'''

class KruskalMST:
	def __init__(self, n):
		self.vertices = n
		self.graph = []

	def add_edge(self, u, v, w):
		self.graph.append([u, v, w])

	def get_mst(self):
		mst = []

		self.graph.sort(key=lambda x: x[2])

		uf = UF(self.vertices)

		for edge in self.graph:
			u, v, _ = edge
			if uf.connect(u, v):
				continue
			uf.union(u, v)
			mst.append(edge)

		for u, v, w in mst:
			print("{:2d} -- {:2d} == {:2d}".format(u, v, w))

from collections import defaultdict
from heapq import heappush, heappop

class PrimeLazyMST:
	def __init__(self, n):
		self.vertices = n
		self.graph = defaultdict(list)

	def add_edge(self, u, v, w):
		self.graph[u].append([v, w])
		self.graph[v].append([u, w])

	def get_mst(self):
		mst = []
		visited = set()
		pq = []
		self.visit(visited, pq, 0)
		while pq:
			w, u, v = heappop(pq)
			if u in visited and v in visted:
				continue
			mst.append([u, v, w])
			if v not in visited:
				self.visit(visited, pq, v)
			if u not in visited:
				self.visit(visited, pq, u)

		for u, v, w in mst:
			print("{:2d} -- {:2d} == {:2d}".format(u, v, w))

	def visit(self, visited, pq, u):
		for v, w in self.graph[u]:
			if v not in visited:
				heappush(pq, (w, u, v))
				visited.add(v)

if __name__ == '__main__':
	# g = KruskalMST(4) 
	# g.add_edge(0, 1, 10) 
	# g.add_edge(0, 2, 6) 
	# g.add_edge(0, 3, 5) 
	# g.add_edge(1, 3, 15) 
	# g.add_edge(2, 3, 4) 
	# g.get_mst() 

	g = PrimeLazyMST(4) 
	g.add_edge(0, 1, 10) 
	g.add_edge(0, 2, 6) 
	g.add_edge(0, 3, 5) 
	g.add_edge(1, 3, 15) 
	g.add_edge(2, 3, 4) 
	g.get_mst() 
