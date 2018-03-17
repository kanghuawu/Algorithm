class Solution:
    def ladderLength(self, bw, ew, li):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        from collections import deque
        from string import ascii_lowercase

        uniq = set(li)
        if not bw or not ew or not ew in uniq:
            return 0

        q = deque()
        q.append(bw)
        lev = 1
        while q:
            nxt = deque()
            for s in q:
                for i in range(len(s)):
                    for ch in ascii_lowercase:
                        tmp = s[:i] + ch + s[i + 1:]
                        if tmp == bw:
                            continue
                        if tmp == ew:
                            return lev + 1
                        if tmp in uniq:
                            uniq.discard(tmp)
                            nxt.append(tmp)
            lev += 1
            q = nxt
        return 0
