
class IntervalNode(object):
	def __init__(self, lo, hi):
		self.lo = lo
		self.hi = hi
		self.max = hi
		self.left = None
		self.right = None

	def __str__(self):
		return "Node({}, {}, {})".format(self.lo, self.hi, self.max)

class IntervalTree(object):
	def __init__(self):
		self.root = None

	def insert(self, lo, hi):
		if self.root is None:
			self.root = IntervalNode(lo, hi)
			return self.root

		self.insert_helper(self.root, lo, hi)

	def insert_helper(self, node, lo, hi):
		if node is None:
			return IntervalNode(lo, hi)

		if lo < node.lo:
			node.left = self.insert_helper(node.left, lo, hi)
		else:
			node.right = self.insert_helper(node.right, lo, hi)

		node.max = max(node.hi, hi)
		return node

	def is_overlap(self, lo, hi):
		return self.is_overlap_helper(self.root, lo, hi)

	def is_overlap_helper(self, node, lo, hi):
		if node is None:
			return None

		if lo < node.hi and node.lo < hi:
			return node

		if node.left and node.left.max > lo:
			return self.is_overlap_helper(node.left, lo, hi)
		else:
			return self.is_overlap_helper(node.right, lo, hi)

if __name__ == '__main__':
	it = IntervalTree()
	it.insert(10, 15)
	it.insert(11, 13)
	it.insert(18, 21)
	it.insert(20, 25)
	it.insert(0, 7)

	print(it.is_overlap(8, 9))
	print(it.is_overlap(17, 17))
	print(it.is_overlap(21, 22))
	print(it.is_overlap(21, 22))
	print(it.is_overlap(12, 18))
	print(it.is_overlap(24, 26))

