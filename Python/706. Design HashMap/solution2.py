class MyHashMap:

    def __init__(self):
        # Initialize 1000 empty buckets (lists, though 1k is usually a prime #)
        # Choosing a prime number like 2069 is technically better for collisions, ...

        self.size = 1000
        self.buckets = [[] for _ in range(self.size)]

    def put(self, key: int, value: int) -> None:
        # Calculate which bucket index (0-999)
        index = key % self.size
        bucket = self.buckets[index]
        
        # Check if key already exists in this bucket
        for i, (k, v) in enumerate(bucket):
            if k == key:
                # update or continue
                bucket[i] = [key, value]
                return
        
        # If loop finishes and we didn't return, key is new. Append it.
        bucket.append([key, value])

    def get(self, key: int) -> int:
        index = key % self.size
        bucket = self.buckets[index]
        
        # Search the bucket for the key
        for k, v in bucket:
            if k == key:
                return v
        
        # If not found
        return -1

    def remove(self, key: int) -> None:
        index = key % self.size
        bucket = self.buckets[index]
        
        # Search for the key to remove it
        for i, (k, v) in enumerate(bucket):
            if k == key:
                # Delete the pair from the list
                del bucket[i]
                return