class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """

        # have 2 arrays, nums1 holds len n, meant to hold the additions of nums2. 
        # if we have n spaces at the end starting as 0's, it means we can fill the array starting from the back

        nums1_pointer = m-1
        nums2_pointer = n-1

        array_pointer = m + n - 1

        while nums2_pointer >= 0:
            # If nums1 is not empty and has the bigger number...
            if nums1_pointer >= 0 and nums1[nums1_pointer] > nums2[nums2_pointer]:
                nums1[array_pointer] = nums1[nums1_pointer]
                nums1_pointer -= 1
            else:
                # Otherwise, nums2 has the bigger (or equal) number
                nums1[array_pointer] = nums2[nums2_pointer]
                nums2_pointer -= 1
            
            # Move the writer pointer backwards
            array_pointer -= 1

        