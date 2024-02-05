class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*Algorithm:
        - very big problem, needs to be broken down.
        - few stages and considerations:
            -> keep track of numbers and number of occurences
            -> sort out how to keep track of most frequent
            -> also need to return only K most frequent.
        - to keep track of numbers and number of occurrences, can use a hashmap/frequency map
        - can iterate through values in hashmap then populate a priority queue?
        - after populating priority queue, return biggest vals
        */

        //create and populate the frequency map.
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        //create max-heap priority queue, meaning higher valued things in the map will be at
        //the end of the queue.
        PriorityQueue<Map.Entry<Integer, Integer>> pqueue = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());

        //populate the priority queue based on the entries of the frequency map
        for(Map.Entry entry : map.entrySet()){
            pqueue.add(entry);
        }

        //create return array and populate with most frequent. 
		//we poll the pq and take the key of the entryset.
        int[] mostFrequent = new int[k];
        for(int i = 0; i < k; i++){
            mostFrequent[i] = pqueue.poll().getKey();
        }
        return mostFrequent;
    }
}