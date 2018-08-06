class Solution:
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        i, j = 0, len(numbers)-1
        while i < j:
            if i > 0 and numbers[i] == numbers[i-1]:
                i+=1
                continue
            if numbers[i] + numbers[j] > target:
                j-=1
            elif numbers[i] + numbers[j] < target:
                i+=1
            else:
                return [i+1, j+1]
        return None