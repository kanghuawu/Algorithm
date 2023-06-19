from node import Node
from collections import deque
from random import randint

class BST(object):
	def __init__(self):
		self.root = None

	def get_root(self):
		return self.root
		
	def put(self, key, val):
		self.root = self.__put(self.root, key, val)
		

	def __put(self, node, key, val):
		if not node:
			return Node(key, val)
		if node.key > key:
			node.left = self.__put(node.left, key, val)
		elif node.key < key:
			node.right = self.__put(node.right, key, val)
		return node

	def get(self, key):
		node = self.root
		while node:
			if node.key > key:
				node = node.left
			elif node.key < key:
				node = node.right
			else:
				return node
		return node

	def floor(self, key):

		return

	def ceiling(self, key):
		return

	def get_inorder(self):
		res = []
		def dfs(node, lis):
			if not node:
				return
			if node.left:
				dfs(node.left, lis)
			lis.append(node)
			if node.right:
				dfs(node.right, lis)
		dfs(self.root, res)
		return res

	def get_preorder(self):
		res = []
		def dfs(node, lis):
			if not node:
				return
			lis.append(node)
			if node.left:
				dfs(node.left, lis)
			if node.right:
				dfs(node.right, lis)
		dfs(self.root, res)
		return res

	def get_inorder(self):
		res = []
		def dfs(node, lis):
			if not node:
				return
			if node.left:
				dfs(node.left, lis)
			lis.append(node)
			if node.right:
				dfs(node.right, lis)
		dfs(self.root, res)
		return res

	def get_postorder(self):
		res = []
		def dfs(node, lis):
			if not node:
				return
			if node.left:
				dfs(node.left, lis)
			if node.right:
				dfs(node.right, lis)
			lis.append(node)
		dfs(self.root, res)
		return res

	def get_vertical_order(self):
		res = []
		queue = deque()
		queue.append(self.root)
		while queue:
			tmp = deque()
			level = []
			while queue:
				node = queue.popleft()
				if node.left:
					tmp.append(node.left)
				if node.right:
					tmp.append(node.right)
				level.append(node)
			queue = tmp
			res.append(level)
		return res

	@classmethod
	def build_random_tree(cls, n, lo=0, hi=100):
		assert n > 0
		bst = cls()
		for _ in range(n):
			rand = randint(lo, hi)
			bst.put(rand, rand)
		return bst


	# def delete(key):
if __name__ == "__main__":
	bst = BST()
	for _ in range(10):
		num = randint(0, 100)
		bst.put(num, num)

	print(bst.get_inorder())



