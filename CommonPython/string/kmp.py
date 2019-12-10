

class KMP(object):
	R = 256
	def __init__(self, pat):
		self.n = len(pat)
		self.dfa = [[0] * self.n for _ in range(KMP.R)]
		self.dfa[ord(pat[0])][0] = 1
		pt = 0
		for col in range(1, self.n):
			for row in range(KMP.R):
				self.dfa[row][col] = self.dfa[row][pt]
			self.dfa[ord(pat[col])][col] = col + 1
			pt = self.dfa[ord(pat[col])][pt]

		# for i, arr in enumerate(self.dfa):
		# 	if i < ord("a") or i > ord("z"):
		# 		continue
		# 	print("\t".join(map(str, arr)))

	def search(self, txt):
		i, j, m = 0, 0, len(txt)
		while i < m and j < self.n:
			j = self.dfa[ord(txt[i])][j]
			i += 1
		if j == self.n:
			return i - self.n
		return -1


if __name__ == "__main__":
	kmp = KMP("ababc")
	print(kmp.search("ababababb"))
