class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        merged = ""

        word1_length = len(word1)
        word2_length = len(word2)

        min_length = min(word1_length,word2_length)
        for i in range(min_length):
            merged += word1[i]
            merged += word2[i]
        
        
        if word1_length > min_length:
            merged += word1[min_length:]
            
        
        if word2_length > min_length:
            merged += word2[min_length:]
            
        return merged