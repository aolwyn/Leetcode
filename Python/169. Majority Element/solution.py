class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        elements = dict()
        majority_element = nums[0] # Assume first is winner initially
        max_count = 0

        for num in nums:
            # Handle the counting
            if num in elements:
                elements[num] += 1
            else:
                elements[num] = 1
            
            # Update the winner if current count beats the record
            if elements[num] > max_count:
                max_count = elements[num]
                majority_element = num 
                
        return majority_element