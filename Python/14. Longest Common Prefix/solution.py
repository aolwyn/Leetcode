class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 0 or not strs:
            return ""
        
        if len(strs) == 1:
            return strs[0]
        # take the prefix of the first word (letter by letter, increment with i)
        # then iterate through each of the word in the list; if we're at the boundary of the current word being checked or if the letter doesn't match the first, return the substrign
        for i in range(len(strs[0])):
            letter = strs[0][i]

            for words in strs:
                if i == len(words) or words[i] != letter:
                    return strs[0][:i]
        
        return strs[0]

