class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        if stones is None or len(stones) == 0:
            return 0
        
        # we can use a max heap and at each turn, if a == b, dont add back,
        # if x != y, x--> 0 & y --> y-x
        # only 1 stone left at end but if no stone then ret 0

        # for a max heap we need to mult by -1 because heapq defaults to min heap.
        # can also do:
        # max_heap = [-x for x in a]
        # heapq.heapify(max_heap)
        max_heap = []
        for stone in stones:
            heapq.heappush(max_heap,-1*stone)
        
        while len(max_heap) > 1:
            stone_a = -heapq.heappop(max_heap)
            stone_b = -heapq.heappop(max_heap)
            
            if stone_a > stone_b:
                heapq.heappush(max_heap, -(stone_a - stone_b))
            
        if len(max_heap) == 0:
            return 0
        else:
            return -max_heap[0]



        

        