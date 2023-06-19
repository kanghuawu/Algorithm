from math import ceil, log

class SegmentTree(object):
	def __init__(self, arr):
		self.arr = arr
		self.n = len(arr)
		self.size = 2 * 2 ** int(ceil(log(len(arr), 2))) - 1
		self.st = [0] * self.size
		self.construct(arr, self.st, 0, self.n - 1, 0)
		# print(self.st)

	def construct(self, arr, st, s, e, pos):
		if s == e:
			st[pos] = arr[s]
			return
		mid = (s + e) // 2
		self.construct(arr, st, s, mid, 2 * pos + 1)
		self.construct(arr, st, mid + 1, e, 2 * pos + 2)
		st[pos] = st[2 * pos + 1] + st[2 * pos + 2]
				
		
	def get_sum(self, qs, qe):
		if qs < 0 or qe >= self.n:
			raise Exception()

		return self.get_sum_helper(qs, qe, 0, self.n - 1, 0)

	def get_sum_helper(self, qs, qe, ss, se, pos):
		if qe < ss or qs > se:
			return 0

		if qs <= ss and se <= qe:
			return self.st[pos]

		mid = (ss + se) // 2
		return self.get_sum_helper(qs, qe, ss, mid, 2 * pos + 1) +\
			self.get_sum_helper(qs, qe, mid + 1, se, 2 * pos + 2)

	def update(self, idx, val):
		if idx < 0 or idx >= self.n:
			raise Exception()
		delta = val - arr[idx]
		self.update_helper(idx, idx, delta, 0, self.n - 1, 0)

	def update_range(self, qs, qe, delta):
		if qe < qs or qe < 0 or qs >= self.n:
			raise Exception()
		self.update_helper(qs, qe, delta, 0, self.n - 1, 0)			

	def update_helper(self, qs, qe, delta, ss, se, pos):
		# no overlap
		if ss > se or qe < ss or se < qs:
			return

		# at leaf
		if ss == se:
			self.st[pos] += delta
			return

		mid = (ss + se) // 2
		self.update_helper(qs, qe, delta, ss, mid, 2 * pos + 1)
		self.update_helper(qs, qe, delta, mid + 1, se, 2 * pos + 2)
		self.st[pos] = self.st[2 * pos + 1] + self.st[2 * pos + 2]

class SegmentTreeLazy(SegmentTree):
	def __init__(self, arr):
		super().__init__(arr)
		self.lazy = [0] * self.size

	def get_sum_helper(self, qs, qe, ss, se, pos):
		if qe < ss or qs > se:
			return 0
		
		if self.lazy[pos] != 0:
			self.st[pos] += (qe - qs + 1) * self.lazy[pos]
			if ss != se:
				self.lazy[2 * pos + 1] += self.lazy[pos]
				self.lazy[2 * pos + 2] += self.lazy[pos]
			self.lazy[ss] = 0

		# at leaf
		if ss == se:
			return self.st[pos]

		# total overlap
		if qs <= ss <= se <= qe:
			return self.st[pos]

		mid = (ss + se) // 2
		return self.get_sum_helper(qs, qe, ss, mid, 2 * pos + 1) +\
			self.get_sum_helper(qs, qe, mid + 1, se, 2 * pos + 2)


	def update_helper(self, qs, qe, delta, ss, se, pos):
		# no overlap
		if ss > se or qe < ss or se < qs:
			return

		if self.lazy[pos] != 0:
			self.st[pos] += (qe - qs + 1) * self.lazy[pos]
			if ss != se:
				self.lazy[2 * pos + 1] += self.lazy[pos]
				self.lazy[2 * pos + 2] += self.lazy[pos]
			self.lazy[ss] = 0
		
		# at leaf
		if ss == se:
			self.st[pos] += self.lazy[pos]
			return

		# total overlap
		if qs <= ss <= se <= qe:
			self.st[pos] += (qe - qs + 1) * self.lazy[pos]
			if ss != se:
				self.lazy[2 * pos + 1] += delta
				self.lazy[2 * pos + 2] += delta
			return

		mid = (ss + se) // 2
		self.update_helper(qs, qe, delta, ss, mid, 2 * pos + 1)
		self.update_helper(qs, qe, delta, mid + 1, se, 2 * pos + 2)
		self.st[pos] = self.st[2 * pos + 1] + self.st[2 * pos + 2]


if __name__ == "__main__":
	arr = [1, 3, 5, 7, 9, 11]
	st = SegmentTree(arr)
	# print(st.get_sum(1, 3))
	assert st.get_sum(1, 3) == 15

	st.update(1, 10)
	assert st.get_sum(1, 3) == 22

	st = SegmentTreeLazy(arr)
	assert st.get_sum(1, 3) == 15

	st.update_range(1, 5, 10)
	assert st.get_sum(1, 3) == 45
