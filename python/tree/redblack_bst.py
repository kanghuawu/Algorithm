from node import Node
from bst import BST
import random

class RedBlackNode(Node):
	RED = True
	BLACK = False

	def __init__(self, key, val, color=RED):
		self.color = color
		super().__init__(key, val)

	def __str__(self):
		return "({},{},{})".format(self.key, self.val, "RED" if self.color else "BLACK")

	def __repr__(self):
		return "({},{},{})".format(self.key, self.val, "RED" if self.color else "BLACK")

class RedBlackBST(BST):
	def put(self, key, val):
		self.root = self.__put(self.root, key, val)

	def __put(self, node, key, val):
		if not node:
			return RedBlackNode(key, val)
		if node.key > key:
			node.left = self.__put(node.left, key, val)
		elif node.key < key:
			node.right = self.__put(node.right, key, val)
		else:
			node.val = val

		if self.__is_red(node.right) and not self.__is_red(node.left):
			node = self.__rotate_left(node)
		if self.__is_red(node.left) and self.__is_red(node.left.left):
			node = self.__rotate_right(node)
		if self.__is_red(node.left) and self.__is_red(node.right):
			self.__flip_color(node)
		return node

	def __rotate_left(self, node):
		assert self.__is_red(node.right) == True
		new_root = node.right
		node.right = new_root.left
		new_root.left = node
		new_root.color = node.color
		node.color = RedBlackNode.RED
		return new_root

	def __rotate_right(self, node):
		assert self.__is_red(node.left) == True
		new_root = node.left
		node.left = new_root.right
		new_root.right = node
		new_root.color = node.color
		node.color = RedBlackNode.RED
		return new_root

	def __flip_color(self, node):
		# assert self.__is_red(node) == False
		assert self.__is_red(node.left) == True
		assert self.__is_red(node.right) == True
		node.left.color = RedBlackNode.BLACK
		node.right.color = RedBlackNode.BLACK
		node.color = RedBlackNode.RED

	def __is_red(self, node):
		if not node:
			return False
		return node.color == RedBlackNode.RED


if __name__ == "__main__":
	rb_bst = RedBlackBST.build_random_tree(30)
	print(rb_bst.get_vertical_order())

