class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # similar to removeElement -- 2 pointers, one to keep track of seen vs unseen.
        # if left and right not same, iter both. if same, move right until found new.
        if not nums:
            return 0
            
        left, right = 0, 1

        while right < len(nums):
            # Compare the number at r with the number at l
            if nums[left] != nums[right]:
                # unique num
                left += 1
                nums[left] = nums[right]
            
            right += 1
        # left is the index of the last unique item so ret +1
        return left + 1

    