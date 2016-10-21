class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        result = []
        for index in range(len(nums)) :
            if target - nums[index] in (nums[:index] + nums[index+1:]):
                result.append(index)

        return result


print(Solution().twoSum([2,3,4,7], 6) == [0,2])