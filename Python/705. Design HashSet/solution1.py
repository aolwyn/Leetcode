class MyHashSet:
    # the cheese way to do it is to make a binary array of max size of the constraints and check accordingly.
    # otherwise just make a list.
    #NOTE: can't call functions inside other functions
    def __init__(self):
        self.hashset = []
        

    def add(self, key: int) -> None:
        if key not in self.hashset:
            self.hashset.append(key)


        

    def remove(self, key: int) -> None:
        if key in self.hashset:
            self.hashset.remove(key)
        

    def contains(self, key: int) -> bool:
        return key in self.hashset
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)