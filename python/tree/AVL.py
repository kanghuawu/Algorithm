from node import Node
from bst import BST
import random

class AVLNode(Node):
	def __init__(self, key, val, height=1):
		self.height = height
		super().__init__(key, val)

	def __str__(self):
		return "({}, {})".format(self.key, self.height)

	def __repr__(self):
		return "({}, {})".format(self.key, self.height)



class AVLBST(BST):
	def __init__(self):
		super().__init__()

	def __rotate_left(self, node):
		new_root = node.right
		node.right = node.right.left
		new_root.left = node
		self.__update_height(node)
		self.__update_height(new_root)
		return new_root


	def __rotate_right(self, node):
		new_root = node.left
		node.left = node.left.right
		new_root.right = node
		self.__update_height(node)
		self.__update_height(new_root)
		return new_root


	def __update_height(self, node):
		if not node:
			return
		node.height = max([
			node.left.height if node.left else 0,
			node.right.height if node.right else 0
		]) + 1

	def __balance(self, node):
		if not node:
			return 0
		return (node.left.height if node.left else 0) \
			- (node.right.height if node.right else 0)

	def put(self, key, val):
		self.root = self.__put(self.root, key, val)

	def __put(self, node, key, val):
		if not node:
			return AVLNode(key, val)
		if node.val > key:
			node.left = self.__put(node.left, key, val)
		elif node.val < key:
			node.right = self.__put(node.right, key, val)
		else:
			node.val = val
		balance = self.__balance(node)
		if balance > 1:
			if self.__balance(node.left) > 0:
				node = self.__rotate_right(node)
			else:
				node.left = self.__rotate_left(node.left)
				node = self.__rotate_right(node)
		elif balance < -1:
			if self.__balance(node.right) < 0:
				node = self.__rotate_left(node)
			else:
				node.right = self.__rotate_right(node.right)
				node = self.__rotate_left(node)
		else:
			self.__update_height(node)
		return node


if __name__ == "__main__":
	random.seed(3)
	avl = AVLBST()
	for i in range(20):
		num = random.randint(0, 100)
		if i == 0:
			print("first rand: {}".format(num))
		avl.put(num, num)

	print(avl.get_inorder())
	print(avl.get_preorder())
	print(avl.get_vertical_order())