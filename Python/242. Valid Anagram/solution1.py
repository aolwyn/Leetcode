class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        s_letters = {}
        t_letters = {}

        for letter in s:
            if letter in s_letters:
                s_letters[letter] += 1
            else:
                s_letters[letter] = 1
    
        for letter in t:
            if letter in t_letters:
                t_letters[letter] += 1
            else:
                t_letters[letter] = 1
    
        for key in s_letters:
            if key not in t_letters:
                return False
            
            if s_letters[key] != t_letters[key]:
                return False

        return True