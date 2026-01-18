class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        # have an input arr (sorted) and a target
        # need indices s.t. index i + index j 's elements = target
        # Note: 1 INDEXED.
        # can only use extra space

        if len(numbers) == 2:
            return [1,2]

        left, right = 0, len(numbers) - 1

        while left<= right:
            if (numbers[left] + numbers[right]) == target:
                return [left+1, right+1]
            
            elif (numbers[left] + numbers[right]) > target:
                right-=1
            
            else:
                left+=1
                

        