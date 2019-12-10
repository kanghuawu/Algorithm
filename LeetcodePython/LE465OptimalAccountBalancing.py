from collections import defaultdict
from typing import List
class Solution:
    def minTransfersTLE(self, transactions: List[List[int]]) -> int:
        account = defaultdict(int)
        for p1, p2, t in transactions:
            account[p1] -= t
            account[p2] += t
        
        self.res = len(account)
        def dfs(acc, ind, visited, s, level, deduc):
            if len(visited) == len(acc):
                self.res = min(self.res, len(acc) - deduc)
                return
            
            for i, t in acc:
                if i in visited or s * t > 0:
                    continue
                visited.add(i)
                if s + t == 0:
                    dfs(acc, i + 1, visited, s + t, level + 1, deduc + 1)
                else:
                    dfs(acc, i + 1, visited, s + t, level + 1, deduc)
                visited.remove(i)
                    
        print(list(account.items()))
        dfs(list(account.items()), 0, set(), 0, 0, 0)
        return self.res

    def minTransfers(self, transactions: List[List[int]]) -> int:
        account = defaultdict(int)
        for p1, p2, t in transactions:
            account[p1] -= t
            account[p2] += t
        
        self.res = len(account)
        def dfs(acc, ind, trans):
            while ind < len(acc) and acc[ind][1] == 0:
                ind += 1
            if ind == len(acc):
                self.res = min(self.res, trans)
                return
            for i in range(ind + 1, len(acc)):
                if acc[ind][1] * acc[i][1] >= 0:
                    continue
                tmp = acc[i][1]
                acc[i][1] += acc[ind][1]
                dfs(acc, ind + 1, trans + 1)
                acc[i][1] = tmp
        
        # print(list(account.items()))
        dfs([[k, v] for k, v in account.items()], 0, 0)
        return self.res

s = Solution()
print(s.minTransfers([[1,8,1],[1,13,21],[2,8,10],[3,9,20],[4,10,61],[5,11,61],[6,12,59],[7,13,60]]))        