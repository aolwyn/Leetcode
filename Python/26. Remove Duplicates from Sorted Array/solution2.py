class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # base case, empty
        if not nums:
            return 0
            
        # same solution + logic just with a for loop compared to sol 1.
        right = 1

        for i in range(1, len(nums)):
            
            if nums[i] != nums[i-1]:
                
                nums[right] = nums[i]
                right += 1
        
        return right