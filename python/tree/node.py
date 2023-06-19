import functools
import random

@functools.total_ordering
class Key(object):
	def __init__(self, key):
		self.key = key

	def __lt__(self, other):
		return self.key < other.key

	def __eq__(self, other):
		return self.key == other.key

	def __str__(self):
		return str(self.key)

@functools.total_ordering
class Val(object):
	def __init__(self, val):
		self.val = val

	def __lt__(self, other):
		return self.val < other.val

	def __eq__(self, other):
		return self.val == other.val

	def __str__(self):
		return str(self.val)

class Node(object):
	def __init__(self, key, val):
		self.key = key
		self.val = val
		self.left = None
		self.right = None

	def __str__(self):
		return "Node({},{})".format(self.key, self.val)

	def __repr__(self):
		return "Node({},{})".format(self.key, self.val)


if __name__ == "__main__":
	a = Key("a")
	b = Key("b")
	print(a == b)
	print(a < b)

	c = Key(1)
	d = Key(2)
	print(c == d)
	print(c < d)

	n1 = Node(1, 2)
	n2 = Node(3, 4)
	print(n1, n2)