class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        right = 0
        # 2 pointer; 1 keeps track of the last "valid" number. the other iterates through.
        #logic is, if current isn't the val we're removing, we're ok; it's valid. so we can put a "safe" value at the next index.
        # however, if we get a val, it's not safe -- so we want to keep looking for next "safe" value. 
        for i in range(len(nums)):
            if nums[i] != val:
                nums[right] = nums[i]
                right+=1
        
        return right
        