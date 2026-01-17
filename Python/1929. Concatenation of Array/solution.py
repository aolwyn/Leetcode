class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        length = len(nums)

        ans = [0] * (2 * length)

        for i, n in enumerate(nums):
            ans[i] = n
            ans[length+i] = n
        
        return ans