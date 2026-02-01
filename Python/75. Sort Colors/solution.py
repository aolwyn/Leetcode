class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # there are 3 possibilites for a given value, 0,1,2.
        # in theory this means if we sort 2 the last should be done.
        # we are to do this without .sort()

        # approach is to use 2 pointers and a curr index. 
        # Dutch National Flag problem :)
        #alternatively, we can just do counting sort.
        

        c0 = nums.count(0)
        c1 = nums.count(1)
        c2 = nums.count(2)
        
        for i in range(len(nums)):
            if i < c0:
                nums[i] = 0
            elif i < c0 + c1:
                nums[i] = 1
            else:
                nums[i] = 2
