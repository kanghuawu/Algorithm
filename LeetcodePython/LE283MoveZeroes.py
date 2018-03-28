class Solution:
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        i = 0
        j = 0
        n = len(nums)
        while i < n and j < n:
            while i < n and nums[i] != 0:
                i += 1
            while j < n and nums[j] == 0:
                j += 1

            if i < j < n:
                tmp = nums[i]
                nums[i] = nums[j]
                nums[j] = tmp

            j += 1
