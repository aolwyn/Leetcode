class Solution:
    def validPalindrome(self, s: str) -> bool:
        left, right = 0, len(s) - 1
        
        while left < right:
            if s[left] == s[right]:
                left += 1
                right -= 1
            else:
                # Mismatch found, have 1 chance (can delete at most 1)
                # possibility 1: Delete character at 'left' (check range left+1 to right)
                # possibility2: Delete character at 'right' (check range left to right-1)
                
                # Create the two potential substrings
                skip_left = s[left + 1 : right + 1]
                skip_right = s[left : right]
                
                # Check if either one works
                return (skip_left == skip_left[::-1]) or (skip_right == skip_right[::-1])
        
        return True