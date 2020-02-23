# https://www.geeksforgeeks.org/shortest-uncommon-subsequence/
# https://www.geeksforgeeks.org/longest-uncommon-subsequence/

def shortest_seq(s, t):
	if len(s) == 0:
		return float('inf')

	if len(t) <= 0:
		return 1

	k = 0
	while k < len(t) and s[0] == t[k]:
		k += 1

	if k == len(t):
		return 1

	return min(shortest_seq(s[1:], t), 1 + shortest_seq(s[1:], t[k+1:]))

def shortest_seq_top_down(s, t, cache):
	if len(s) == 0:
		return float('inf')

	if len(t) <= 0:
		return 1

	if (s, t) in cache:
		return cache[(s, t)]

	k = 0
	while k < len(t) and s[0] == t[k]:
		k += 1

	if k == len(t):
		return 1
	cache[(s, t)] = min(shortest_seq(s[1:], t), 1 + shortest_seq(s[1:], t[k+1:]))

	return cache[(s, t)]

def shortest_seq_bottom_up(s, t):
	m, n = len(s), len(t)

	dp = [[0] * (n + 1) for _ in range(m + 1)]

	# for i in range(m + 1):
	# 	dp[i][0] = 1

	for i in range(n + 1):
		dp[0][i] = float('inf')

	for i in range(1, m + 1):
		for j in range(1, n + 1):

			k = j - 1
			while k >= 0 and t[k] != s[i - 1]:
				k -= 1

			if k == -1:
				dp[i][j] = 1
			else:
				dp[i][j] = min(dp[i - 1][j], dp[i - 1][k] + 1)

	for a in dp:
		print(a)

	return dp[m][n] if dp[m][n] < float('inf') else -1


if __name__ == '__main__':
	s = "babab"
	t = "babba"
	
	ans = shortest_seq(s, t)
	print(ans)

	ans = shortest_seq_top_down(s, t, {})
	print(ans)

	ans = shortest_seq_bottom_up(s, t,)
	print(ans)