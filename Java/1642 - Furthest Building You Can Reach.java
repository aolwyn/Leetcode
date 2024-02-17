class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        /*Algorithm:
        - we are given ladders + bricks
        - ladders scale no matter the height but bricks have a usable height.
        - we can use a greedy algorithm here with a priority queue.
        - with the priority queue, we will check if we can handle it with the amount of ladders.
        - when we run out of ladders we can start to check if we have enough bricks to handle the difference.
        - we use a priority queue because it'll always keep order of what we cant deal with (smallest height difference) at the front 
          so we use bricks to deal with smallest heigh difference while saving the ladders.
        - if we run through the entire array it means we can make it to the end so return length -1
        */

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < heights.length-1; i++){
            int h1 = heights[i];
            int h2 = heights[i+1];
            int diff = h2-h1;
            if(diff > 0){
                pq.offer(diff);
                if(pq.size() > ladders){
                    bricks -= pq.poll();
                    if(bricks < 0){
                        return i;
                    }
                }
            }            
        }
        return heights.length-1;
    }
}