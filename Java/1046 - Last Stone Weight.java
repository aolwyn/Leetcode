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