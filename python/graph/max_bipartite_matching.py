"""
https://www.geeksforgeeks.org/maximum-bipartite-matching/
"""

class MaximumBipartiteMatching:
	def __init__(self, graph):
		self.graph = graph
		self.ppl = len(graph)
		self.jobs = len(graph[0])

	def max_match(self):
		self.match = [-1] * self.jobs

		max_match = 0

		for i in range(self.ppl):
			seen = set()
			if self.has_augment_path(i, self.match, seen):
				max_match += 1

		return max_match


	def has_augment_path(self, u, match, seen):

		for v in range(self.jobs):
			if self.graph[u][v] and v not in seen:
				seen.add(v)

				if match[v] == -1 \
					or self.has_augment_path(match[v], match, seen):
					match[v] = u

					return True

		return False


if __name__ == "__main__":
	graph = [
		[0, 1, 1, 0, 0, 0], 
	    [1, 0, 0, 1, 0, 0], 
	    [0, 0, 1, 0, 0, 0], 
	    [0, 0, 1, 1, 0, 0], 
	    [0, 0, 0, 0, 0, 0], 
	    [0, 0, 0, 0, 0, 1]
	]

	mbm = MaximumBipartiteMatching(graph)
	print(mbm.max_match())
	print(mbm.match)
