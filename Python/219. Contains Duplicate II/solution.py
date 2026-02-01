class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        # looking at an array and a int k
        # if 2 distinct indices i and j have same value, and abs i-j <= k, return true
        # can solve using a dictionary keeping track of last occurrence, should be able to solve in 1 pass

        if len(nums) == 0 or nums is None:
            return False
        
        seen = dict()

        for i, num in enumerate(nums):
            
            if num in seen:
                if i - seen[num] <= k:
                    return True
            
            seen[num] = i

        return False
        