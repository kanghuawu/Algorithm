import collections
import queue

class Solution:
    def findItinerary(self, tickets):
        """
        :type tickets: List[List[str]]
        :rtype: List[str]
        """
        dic = collections.defaultdict(list)
        for k, v in sorted(tickets, key=lambda x: x[1], reverse=True):
            dic[k].append(v);

        # print(dic)
        stack = ['JFK']
        queue = []
        while stack:
            start = stack.pop()
            while dic[start]:
                print(start)
                stack.append(start)
                start = dic[start].pop()

            queue.append(start)
        return queue[::-1]


if __name__ == '__main__':
    test = Solution()
    tickest = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    print(test.findItinerary(tickest))