class KthLargest {
    /*Algorithm + Thoughts:
    - we are likely using a priority queue here --> a min heap.
    - we will use the KthLargest method in order to instantiate the values in the heap,
    likely by offering them to the heap, calling the add method.

    - in the add method, 2 cases:
    1. if there isnt k values in said heap, then we need to just add the value in
    2. if there is k values, we first determine if the current array val is larger than the top element in the min heap (the smallest #) If val is greater than the top element, it means val is one of the k largest elements. So, we remove the smallest element from the min-heap and insert val into it.
    - After adding the new element val, we return the top element of the min-heap, which is the kth largest element in the stream.
    */
    private int k;
    private PriorityQueue<Integer> minHeap;

public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

  public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */