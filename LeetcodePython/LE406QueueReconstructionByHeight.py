class Solution:
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        if not people:
            return []
        from collections import defaultdict
        dic = defaultdict(list)
        for p in people:
            dic[p[0]].append(p[1])

        height = []
        for k in dic:
            dic[k].sort()
            height.append(k)

        height.sort(reverse=True)
        ans = []
        for h in height:
            for p in dic[h]:
                ans.insert(p, (h, p))

        return ans
