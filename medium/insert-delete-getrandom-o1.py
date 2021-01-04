class RandomizedSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.data = {}
        self.list =[]

    def insert(self, val: int) -> bool:
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        """
        if val in self.data:
            return 0
        
        self.data[val] = len(self.list)
        self.list.append(val)        
        
        return 1

    def remove(self, val: int) -> bool:
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        """
        
        
        if val in self.data:
            del self.data[val]
            self.list.remove(val)
            return 1
        
        

        

    def getRandom(self) -> int:
        """
        Get a random element from the set.
        """
        return random.choice(self.list)
        
        
        


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
