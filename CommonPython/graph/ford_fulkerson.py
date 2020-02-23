from collections import defaultdict, deque


class FordFulkerson:
	def __init__(self, capacity):
		self.residual_capacity = defaultdict(dict)
		for v, w, c in capacity:
			self.residual_capacity[v][w] = c
			if v not in self.residual_capacity[w]:
				self.residual_capacity[w][v] = 0

		print(self.residual_capacity)

	def has_augment_path(self, s, t, parent):
		
		visited = set()
		queue = deque()

		queue.append(s)
		visited.add(s)

		while queue and t not in visited:
			u = queue.popleft()

			for v, c in self.residual_capacity[u].items():
				if v not in visited and c > 0:
					queue.append(v)
					visited.add(v)
					parent[v] = u

		return t in visited
	def max_flow(self, s, t):

		parent = {}
		max_flow = 0

		while self.has_augment_path(s, t, parent):
			bottle = float('inf')
			u = t
			while u != s:
				bottle = min(bottle, self.residual_capacity[parent[u]][u])
				u = parent[u]
			
			max_flow += bottle
			u = t
			while u != s:
				tmp = parent[u]
				self.residual_capacity[tmp][u] -= bottle
				self.residual_capacity[u][tmp] += bottle
				u = tmp

			self.print_augment_paths(s, t, parent)

		return max_flow

	def print_augment_paths(self, s, t, parent):
		u = t
		tmp = []
		while u != s:
			tmp.append(u)
			u = parent[u]
		tmp.append(s)
		tmp.reverse()
		print("->".join(map(str, tmp)))

if __name__ == "__main__":
	
	capacity = [
		[0, 1, 16],
		[0, 2, 13],
		[0, 2, 13],
		[1, 2, 10],
		[1, 3, 12],
		[2, 1, 4],
		[2, 4, 14],
		[3, 2, 9],
		[3, 5, 20],
		[4, 3, 7],
		[4, 5, 4],
	]

	ff = FordFulkerson(capacity)
	print(ff.max_flow(0, 5))
	for u, nb in ff.residual_capacity.items():
		print("{}: {}".format(u, str(nb)))