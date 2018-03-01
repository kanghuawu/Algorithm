class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        store = {}
        for idx, num in enumerate(nums):
            if num in store:
                return [store[num], idx]
            else:
                store[target-num] = idx;
        return []