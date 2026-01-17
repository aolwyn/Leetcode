class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 2:
            return [0,1]
        
        seen = dict()

        for i, n in enumerate(nums):
            curr = target - n

            if curr in seen:
                return [seen.get(curr), i]
            else:
                seen[n] = i
