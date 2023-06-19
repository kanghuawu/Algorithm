from node import Node
from bst import BST
from redblack_bst import RedBlackBST

class MorrisTraversal(object):
	@staticmethod
	def inorder(root):
		res = []
		cur = root
		while cur:
			if not cur.left:
				res.append(cur)
				cur = cur.right
			else:
				pre = cur.left
				while pre.right and pre.right != cur:
					pre = pre.right

				if not pre.right:
					pre.right = cur
					cur = cur.left
				else:
					res.append(cur)
					cur = cur.right
					pre.right = None
		return res

	@staticmethod
	def preorder(root):
		res = []
		cur = root
		while cur:
			if not cur.left:
				res.append(cur)
				cur = cur.right
			else:
				pre = cur.left
				while pre.right and pre.right != cur:
					pre = pre.right

				if not pre.right:
					pre.right = cur
					res.append(cur)
					cur = cur.left
				else:
					cur = cur.right
					pre.right = None
		return res

	@staticmethod
	def postorder(root):
		res = []
		dummy = Node(0, 0)
		dummy.left = root
		cur = dummy
		while cur:
			if not cur.left:
				cur = cur.right
			else:
				pre = cur.left
				while pre.right and pre.right != cur:
					pre = pre.right

				if not pre.right:
					pre.right = cur
					cur = cur.left
				else:
					tmp = []
					pre = cur.left
					while pre.right != cur:
						tmp.append(pre)
						pre = pre.right
					tmp.append(pre)
					tmp.reverse()
					res.extend(tmp)
					pre.right = None
					cur = cur.right
		return res

if __name__ == "__main__":
	print("====== Checking Inorder =========")
	rb_bst = RedBlackBST.build_random_tree(30)
	assert MorrisTraversal.inorder(rb_bst.get_root()) == rb_bst.get_inorder()

	print("====== Checking Preorder ========")
	assert MorrisTraversal.preorder(rb_bst.get_root()) == rb_bst.get_preorder()

	print("====== Checking Prostorder ======")
	assert MorrisTraversal.postorder(rb_bst.get_root()) == rb_bst.get_postorder()

	# bst = BST().build_random_tree(30)
	# MorrisTraversal.inorder(bst.get_root())

