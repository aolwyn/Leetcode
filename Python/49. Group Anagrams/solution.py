class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        # looking to group anagrams, meaning, if string[1] has same chars as string[2], they are anagrams
        # we can do this by making a hashmap of chars in a given string and then "sorting" the given word and seeing if its in map
        # if in the map, append to the mapping (the original string), otherwise, put the sorted letters as key + add the value as curr

        # Note: python lists are mutable, so sorting a str --> ate --> a, t, e
        # so need to use sorted(string) because strings dont have a .sort() function

        anagram_map = dict()

        for word in strs:
            # make sorted word then append
            sorted_word = "".join(sorted(word))
            
            if sorted_word not in anagram_map:
                anagram_map[sorted_word] = [word] # Make sure to do the initial mapping as a list, [string] --> [] otherwise overwrite val
            else:
                anagram_map[sorted_word].append(word)

        return list(anagram_map.values())
       