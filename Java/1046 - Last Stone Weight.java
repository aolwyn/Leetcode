class Solution {
    public int lastStoneWeight(int[] stones) {
        /*Algorithm: 
        - we use a priority queue (max heap) in order to get highest values.
        - populate the max heap with the values first, then while size > 1, we can do the smash
        */
    if(stones.length == 1) return stones[0];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add all the stones to the max-heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // hulk: SMASH
        while (maxHeap.size() > 1) {
            int heaviest1 = maxHeap.poll();
            int heaviest2 = maxHeap.poll();

            int diff = heaviest1 - heaviest2;

            // Add the result of smashing back to the max-heap
            if (diff > 0) {
                maxHeap.offer(diff);
            }
        }

        // If there's no stone left, return 0; otherwise, return the last stone's weight
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();

    }
}

/*
class Solution {
    public int lastStoneWeight(int[] stones) {
        /*Algorithm:
        - populate a priority queue
        - in the pq, pop last 2 and then compute the smash.
        - for the pq, add the neg stone value because it prioritizes 'lower' valued things.
        

        if(stones.length == 0)
            return 0;
        if(stones.length ==1)
            return stones[0];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int stone : stones){
            pq.offer(-stone);
        }

        while(pq.size()>1){
           
            int num1 = pq.poll();
            int num2 = pq.poll();
            if(num1 != num2){
                pq.offer(num1-num2);
            }
        }

        if(pq.size()==1){
            return -pq.poll();
        }

        return 0;


    }
}
 */