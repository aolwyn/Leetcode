# NOTES!

Notes taken from across the internet rec visiting: https://github.com/kdn251/interviews/ 


# General Notes

## Recursion

- *Recursion* is a programming technique where a function calls itself to solve a problem
- Every recursive method should have a base case that stops the recursion.
- Recursion is often seen in tree problems and can be used to calculate factorials, GCDs, and even binary search.

```java
public static long calculateFactorial(int n) {
        // Base case: factorial of 0 or 1 is 1
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursive case: n! = n * (n-1)!
        else {
            return n * calculateFactorial(n - 1);
        }
    }
```

## DATA STRUCTURES

### Array

- An *Array* is a data structure consisting of a collection of elements (values or variables), each identified by at least one array index or key.
- Arrays store things of the same data type and store it at contiguous memory locations.
- Time Complexity:
    - Access: `O(1)`
    - Search: `O(n)`
    - Insert: `O(n)`
    - Remove: `O(n)`

### Linked List

- A *Linked List* is a linear collection of data elements, called nodes, each pointing to the next node by means of a pointer. It is a data structure consisting of a group of nodes which together represent a sequence.
- **Singly-linked list**: linked list in which each node points to the next node and the last node points to null
- **Doubly-linked list**: linked list in which each node has two pointers, p, and n, such that p points to the previous node and n points to the next node; the last node's n pointer points to null
- **Circular-linked list**: linked list in which each node points to the next node and the last node points back to the first node
- Time Complexity:
    - Access: `O(n)`
    - Search: `O(n)`
    - Insert: `O(1)`
    - Remove: `O(1)`

### Stack

- A *Stack* is a collection of elements, with two principle operations: *push*, which adds to the collection, and *pop*, which removes the most recently added element
- **Last in, first out data structure (LIFO)**: the most recently added object is the first to be removed
- Time Complexity:
    - Access: `O(n)`
    - Search: `O(n)`
    - Insert: `O(1)`
    - Remove: `O(1)`

### Queue

- A *Queue* is a collection of elements, supporting two principle operations: *enqueue*, which inserts an element into the queue, and *dequeue*, which removes an element from the queue
- **First in, first out data structure (FIFO)**: the oldest added object is the first to be removed
- Time Complexity:
    - Access: `O(n)`
    - Search: `O(n)`
    - Insert: `O(1)`
    - Remove: `O(1)`

### Dequeue

- A *Dequeue* is the short form for a double-ended queue. It supports the insertion and removal of elements from both the front and the back of the queue. The name "double-ended queue" signifies that operations can occur at both ends. Dequeues can be implemented using various underlying data structures, such as dynamic arrays or linked lists.
- Time Complexity:
    - Enqueue Front (push_front): Add an element to the front of the dequeue. `O(1)`
    - Enqueue Rear (push_back): Add an element to the rear (back) of the dequeue. ` O(1)`
    - Dequeue Front (pop_front): Remove and return the element from the front of the dequeue. `O(1)`
    - Dequeue Rear (pop_back): Remove and return the element from the rear of the dequeue. `O(1)`
    - Front (peek_front): View the element at the front of the dequeue without removing it. `O(1)`
    - Rear (peek_back): View the element at the rear of the dequeue without removing it. `O(1)`

### Hashing

- *Hashing* is used to map data of an arbitrary size to data of a fixed size. The values returned by a hash function are called hash values, hash codes, or simply hashes. If two keys map to the same value, a collision occurs
- **Hash Map**: a *hash map* is a structure that can map keys to values. A hash map uses a hash function to compute an index into an array of buckets or slots, from which the desired value can be found.
- Collision Resolution
- **Separate Chaining**: in *separate chaining*, each bucket is independent, and contains a list of entries for each index. The time for hash map operations is the time to find the bucket (constant time), plus the time to iterate through the list
- **Open Addressing**: in *open addressing*, when a new entry is inserted, the buckets are examined, starting with the hashed-to-slot and proceeding in some sequence, until an unoccupied slot is found. The name open addressing refers to the fact that the location of an item is not always determined by its hash value

![https://github.com/kdn251/interviews/raw/master/images/hash.png?raw=true](https://github.com/kdn251/interviews/raw/master/images/hash.png?raw=true)

### Trees

- A *Tree* is an undirected, connected, acyclic graph

### Binary Tree

- A *Binary Tree* is a tree data structure in which each node has at most two children, which are referred to as the *left child* and *right child*
- **Full Tree**: a tree in which every node has either 0 or 2 children
- **Perfect Binary Tree**: a binary tree in which all interior nodes have two children and all leaves have the same depth
- **Complete Tree**: a binary tree in which every level *except possibly the last* is full and all nodes in the last level are as far left as possible

### Binary Search Tree

- A binary search tree, sometimes called BST, is a type of binary tree that maintains the property that the value in each node must be greater than or equal to any value stored in the left sub-tree, and less than or equal to any value stored in the right sub-tree
- Time Complexity:
    - Access: `O(log(n))`
    - Search: `O(log(n))`
    - Insert: `O(log(n))`
    - Remove: `O(log(n))`

![https://github.com/kdn251/interviews/raw/master/images/BST.png?raw=true](https://github.com/kdn251/interviews/raw/master/images/BST.png?raw=true)

### Trie

- A trie, sometimes called a radix or prefix tree, is a kind of search tree that is used to store a dynamic set or associative array where the keys are usually Strings. No node in the tree stores the key associated with that node; instead, its position in the tree defines the key with which it is associated. All the descendants of a node have a common prefix of the String associated with that node, and the root is associated with the empty String.

![https://github.com/kdn251/interviews/raw/master/images/trie.png?raw=true](https://github.com/kdn251/interviews/raw/master/images/trie.png?raw=true)

### Fenwick Tree

- A Fenwick tree, sometimes called a binary indexed tree, is a tree in concept, but in practice is implemented as an implicit data structure using an array. Given an index in the array representing a vertex, the index of a vertex's parent or child is calculated through bitwise operations on the binary representation of its index. Each element of the array contains the pre-calculated sum of a range of values, and by combining that sum with additional ranges encountered during an upward traversal to the root, the prefix sum is calculated
- Time Complexity:
    - Range Sum: `O(log(n))`
    - Update: `O(log(n))`

![https://github.com/kdn251/interviews/raw/master/images/fenwickTree.png?raw=true](https://github.com/kdn251/interviews/raw/master/images/fenwickTree.png?raw=true)

### Segment Tree

- A Segment tree, is a tree data structure for storing intervals, or segments. It allows querying which of the stored segments contain a given point
- Time Complexity:
    - Range Query: `O(log(n))`
    - Update: `O(log(n))`

![https://github.com/kdn251/interviews/raw/master/images/segmentTree.png?raw=true](https://github.com/kdn251/interviews/raw/master/images/segmentTree.png?raw=true)

### Heap

- A *Heap* is a specialized tree-based structure data structure that satisfies the *heap* property: if A is a parent node of B, then the key (the value) of node A is ordered with respect to the key of node B with the same ordering applying across the entire heap. A heap can be classified further as either a "max heap" or a "min heap". In a max heap, the keys of parent nodes are always greater than or equal to those of the children and the highest key is in the root node. In a min heap, the keys of parent nodes are less than or equal to those of the children and the lowest key is in the root node
- Time Complexity:
    - Access Max / Min: `O(1)`
    - Insert: `O(log(n))`
    - Remove Max / Min: `O(log(n))`

![https://github.com/kdn251/interviews/raw/master/images/heap.png?raw=true](https://github.com/kdn251/interviews/raw/master/images/heap.png?raw=true)

### Graphs

- A *Graph* is an ordered pair of G = (V, E) comprising a set V of vertices or nodes together with a set E of edges or arcs, which are 2-element subsets of V (i.e. an edge is associated with two vertices, and that association takes the form of the unordered pair comprising those two vertices)
- **Undirected Graph**: a graph in which the adjacency relation is symmetric. So if there exists an edge from node u to node v (u -> v), then it is also the case that there exists an edge from node v to node u (v -> u)
- **Directed Graph**: a graph in which the adjacency relation is not symmetric. So if there exists an edge from node u to node v (u -> v), this does *not* imply that there exists an edge from node v to node u (v -> u)

![https://github.com/kdn251/interviews/raw/master/images/graph.png?raw=true](https://github.com/kdn251/interviews/raw/master/images/graph.png?raw=true)

## SORTING

### Quicksort
- *Quicksort* is based on the Divide and Conquer algorithm that picks an element as a pivot and partitions the given array around the picked pivot by placing the pivot in its correct position in the sorted array.

- Stable: `No`
- Time Complexity:
    - Best Case: `O(nlog(n))`
    - Worst Case: `O(n^2)`
    - Average Case: `O(nlog(n))`

![https://github.com/kdn251/interviews/raw/master/images/quicksort.gif?raw=true](https://github.com/kdn251/interviews/raw/master/images/quicksort.gif?raw=true)

### Mergesort

- *Mergesort* is also a divide-and-conquer algorithm. It continuously divides an array into two halves, recurses on both the left subarray and right subarray and then merges the two sorted halves
- Stable: `Yes`
- Time Complexity:
    - Best Case: `O(nlog(n))`
    - Worst Case: `O(nlog(n))`
    - Average Case: `O(nlog(n))`

![https://github.com/kdn251/interviews/raw/master/images/mergesort.gif?raw=true](https://github.com/kdn251/interviews/raw/master/images/mergesort.gif?raw=true)

### Bucket Sort

- *Bucket Sort* is a sorting algorithm that works by distributing the elements of an array into a number of buckets. Each bucket is then sorted individually, either using a different sorting algorithm or by recursively applying the bucket sorting algorithm. `n` represents number of elements in array, `k` is the number of buckets.
- Time Complexity:
    - Best Case: `Ω(n + k)`
    - Worst Case: `O(n^2)`
    - Average Case:`Θ(n + k)`

![https://github.com/kdn251/interviews/raw/master/images/bucketsort.png?raw=true](https://github.com/kdn251/interviews/raw/master/images/bucketsort.png?raw=true)

### Radix Sort

- *Radix Sort* is a sorting algorithm that like bucket sort, distributes elements of an array into a number of buckets. However, radix sort differs from bucket sort by 're-bucketing' the array after the initial pass as opposed to sorting each bucket and merging
- Time Complexity:
    - Best Case: `Ω(nk)`
    - Worst Case: `O(nk)`
    - Average Case: `Θ(nk)`

### Insertion Sort

- *Insertion Sort* sorts the array one element at a time by repeatedly taking the next element and inserting it into its correct position. Divide into sorted and unsorted region, take element from unsorted and move to sorted, repeat until done.
- Time Complexity:
    - Best Case: O(n) - Already sorted.
    - Average Case: O(n^2) - Each element compares with every previous one.
    - Worst Case: O(n^2) - Reverse order.

### Selection Sort

- *Selection Sort* selects the smallest (or largest) element from the unsorted portion and swap it with the first (or last) element of the unsorted portion. Divide the array into a sorted and an unsorted region, find the minimum (or maximum) element in the unsorted region, swap it with the first (or last) element of the unsorted region, repeat until done.
- Time Complexity:
    - Best Case: O(n^2) - Always requires n^2/2 comparisons.
    - Average Case: O(n^2) - Same as the best case, as there are no optimizations.
    - Worst Case: O(n^2) - Same as the average and best case.
 
### Heap Sort

- *Heap Sort* uses a boinary heap data structure to build a heap and repeatedly extract the minimum (or maximum) element to achieve sorting. Build a max-heap (for ascending order) or a min-heap (for descending order) from the array, swap the root (maximum or minimum) with the last element, and reduce the size of the heap, 
Heapify the root to maintain the heap property, Repeat steps 2-3 until the heap is empty.
- Time Complexity:
    - Best Case: O(n log n) - Building the heap.
    - Average Case: O(n log n) - Building the heap.
    - Worst Case: O(n log n) - Building the heap and extracting elements.


## SEARCHING

### Linear Search

- Idea: Traverse the array sequentially to find the target element.
- Time Complexity:
    - Best Case: O(1) - Target is the first element.
    - Average Case: O(n) - Target is equally likely to be anywhere in the array.
    - Worst Case: O(n) - Target is the last element or not present.

### Binary Search

- Idea: Divide and conquer; repeatedly divide the sorted array in half and narrow down the search space.
- Time Complexity:
    - Best Case: O(1) - Target is the middle element.
    - Average Case: O(log n) - Each comparison reduces the search space by half.
    - Worst Case: O(log n) - Same as the average case.

### Hashing (Hash Table Search)

- Idea: Use a hash function to map keys to indices in an array; provides constant-time average case search.
- Time Complexity:
    - Average Case: O(1) - Assuming a good hash function and minimal collisions.
    - Worst Case: O(n) - In the presence of collisions, when multiple keys map to the same index.

### Interpolation Search

- Idea: Similar to binary search, but uses the distribution of values to estimate the likely position of the target.
- Time Complexity:
    - Best Case: O(1) - Target is found with the first probe.
    - Average Case: O(log log n) - Under certain assumptions about the distribution of data.
    - Worst Case: O(n) - When the distribution is skewed, and the interpolation formula gives poor estimates.

### Exponential Search

- Idea: Start with a small range and exponentially increase it until a range containing the target is found, then perform binary search within that range.
- Time Complexity:
    - Average Case: O(log n) - Combines exponential and binary search.
    - Worst Case: O(log n) - Same as the average case.

### Binary Search Tree (BST) Search

- Idea: Utilize the properties of a binary search tree, where nodes in the left subtree are smaller, and nodes in the right subtree are larger.
- Time Complexity:
    - Average Case: O(log n) - Balanced BST.
    - Worst Case: O(n) - Unbalanced BST.

### Ternary Search

- Idea: Divide the sorted array into three parts and determine which part the target lies in, narrowing down the search space.
- Time Complexity:
    - Average Case: O(log3 n) - Each comparison reduces the search space to one-third.

### Jump Search

- Idea: Jump a fixed block size ahead in the array and check if the target is in the current block; if not, jump again.
- Time Complexity:
    - Average Case: O(√n) - Optimal for uniformly distributed data.
    - Worst Case: O(√n) - Same as the average case.

## GRAPH ALGORITHMS

### Depth First Search

- *Depth First Search* is a graph traversal algorithm that explores as far as possible along each branch before backtracking
- Time Complexity: `O(|V| + |E|)`

![https://github.com/kdn251/interviews/raw/master/images/dfsbfs.gif?raw=true](https://github.com/kdn251/interviews/raw/master/images/dfsbfs.gif?raw=true)

### Breadth First Search

- *Breadth First Search* is a graph traversal algorithm that explores the neighbor nodes first, before moving to the next level neighbors
- Time Complexity: `O(|V| + |E|)`

![https://github.com/kdn251/interviews/raw/master/images/dfsbfs.gif?raw=true](https://github.com/kdn251/interviews/raw/master/images/dfsbfs.gif?raw=true)

### Topological Sort

- *Topological Sort* is the linear ordering of a directed graph's nodes such that for every edge from node u to node v, u comes before v in the ordering
- Time Complexity: `O(|V| + |E|)`

### Dijkstra's Algorithm

- *Dijkstra's Algorithm* is an algorithm for finding the shortest path between nodes in a graph
- Time Complexity: `O(|V|^2)`

![https://github.com/kdn251/interviews/raw/master/images/dijkstra.gif?raw=true](https://github.com/kdn251/interviews/raw/master/images/dijkstra.gif?raw=true)

### Bellman-Ford Algorithm

- *Bellman-Ford Algorithm* is an algorithm that computes the shortest paths from a single source node to all other nodes in a weighted graph
- Although it is slower than Dijkstra's, it is more versatile, as it is capable of handling graphs in which some of the edge weights are negative numbers
- Time Complexity:
    - Best Case: `O(|E|)`
    - Worst Case: `O(|V||E|)`

![https://github.com/kdn251/interviews/raw/master/images/bellman-ford.gif?raw=true](https://github.com/kdn251/interviews/raw/master/images/bellman-ford.gif?raw=true)

### Floyd-Warshall Algorithm

- *Floyd-Warshall Algorithm* is an algorithm for finding the shortest paths in a weighted graph with positive or negative edge weights, but no negative cycles
- A single execution of the algorithm will find the lengths (summed weights) of the shortest paths between *all* pairs of nodes
- Time Complexity:
    - Best Case: `O(|V|^3)`
    - Worst Case: `O(|V|^3)`
    - Average Case: `O(|V|^3)`

### Prim's Algorithm

- *Prim's Algorithm* is a greedy algorithm that finds a minimum spanning tree for a weighted undirected graph. In other words, Prim's find a subset of edges that forms a tree that includes every node in the graph
- Time Complexity: `O(|V|^2)`

![https://github.com/kdn251/interviews/raw/master/images/prim.gif?raw=true](https://github.com/kdn251/interviews/raw/master/images/prim.gif?raw=true)

### Kruskal's Algorithm

- *Kruskal's Algorithm* is also a greedy algorithm that finds a minimum spanning tree in a graph. However, in Kruskal's, the graph does not have to be connected
- Time Complexity: `O(|E|log|V|)`

![https://github.com/kdn251/interviews/raw/master/images/kruskal.gif?raw=true](https://github.com/kdn251/interviews/raw/master/images/kruskal.gif?raw=true)

## GREEDY ALGORITHMS

- *Greedy Algorithms* are algorithms that make locally optimal choices at each step in the hope of eventually reaching the globally optimal solution
- Problems must exhibit two properties in order to implement a Greedy solution:
- Optimal Substructure
    - An optimal solution to the problem contains optimal solutions to the given problem's subproblems
- The Greedy Property
    - An optimal solution is reached by "greedily" choosing the locally optimal choice without ever reconsidering previous choices
- Example - Coin Change
    - Given a target amount V cents and a list of denominations of n coins, i.e. we have coinValue[i] (in cents) for coin types i from [0...n - 1], what is the minimum number of coins that we must use to represent amount V? Assume that we have an unlimited supply of coins of any type
    - Coins - Penny (1 cent), Nickel (5 cents), Dime (10 cents), Quarter (25 cents)
    - Assume V = 41. We can use the Greedy algorithm of continuously selecting the largest coin denomination less than or equal to V, subtract that coin's value from V, and repeat.
    - V = 41 | 0 coins used
    - V = 16 | 1 coin used (41 - 25 = 16)
    - V = 6 | 2 coins used (16 - 10 = 6)
    - V = 1 | 3 coins used (6 - 5 = 1)
    - V = 0 | 4 coins used (1 - 1 = 0)
    - Using this algorithm, we arrive at a total of 4 coins which is optimal

## BITMASKS

- Bitmasking is a technique used to perform operations at the bit level. Leveraging bitmasks often leads to faster runtime complexity and helps limit memory usage
- Test kth bit: `s & (1 << k);`
- Set kth bit: `s |= (1 << k);`
- Turn off kth bit: `s &= ~(1 << k);`
- Toggle kth bit: `s ^= (1 << k);`
- Multiple by 2: `s << n;`
    
    n
    
- Divide by 2: `s >> n;`
    
    n
    
- Intersection: `s & t;`
- Union: `s | t;`
- Set Subtraction: `s & ~t;`
- Extract lowest set bit: `s & (-s);`
- Extract lowest unset bit: `~s & (s + 1);`
- Swap Values: `x ^= y; y ^= x; x ^= y;`

## RUNTIME ANALYSIS

### Big O Notation

- *Big O Notation* is used to describe the upper bound of a particular algorithm. Big O is used to describe worst case scenarios

![https://github.com/kdn251/interviews/raw/master/images/bigO.png?raw=true](https://github.com/kdn251/interviews/raw/master/images/bigO.png?raw=true)

### Little O Notation

- *Little O Notation* is also used to describe an upper bound of a particular algorithm; however, Little O provides a bound that is not asymptotically tight

### Big Ω Omega Notation

- *Big Omega Notation* is used to provide an asymptotic lower bound on a particular algorithm

![https://github.com/kdn251/interviews/raw/master/images/bigOmega.png?raw=true](https://github.com/kdn251/interviews/raw/master/images/bigOmega.png?raw=true)

### Little ω Omega Notation

- *Little Omega Notation* is used to provide a lower bound on a particular algorithm that is not asymptotically tight

### Theta Θ Notation

- *Theta Notation* is used to provide a bound on a particular algorithm such that it can be "sandwiched" between two constants (one for an upper limit and one for a lower limit) for sufficiently large values

![https://github.com/kdn251/interviews/raw/master/images/theta.png?raw=true](https://github.com/kdn251/interviews/raw/master/images/theta.png?raw=true)

## NICHE

### how to get max in array using stream:

Arrays.stream(arr).max().getAsInt();

### How to iterate through each key of a hashmap:

for(Integer key : map.keySet()){

### how to get rid of extra spaces in a string (leading and following):

s.trim()

### how to get rid of extra spaces between words in string:

temp.replaceAll("\\s+", " ");

### how to convert array to list quickly:

Set<Integer> integerSet = new HashSet<>(Arrays.asList(integerArray));

## how to make a stringbuilder:

StringBuilder removed = new StringBuilder();

### remove a specific char at ith index in stringbuilder/string:

ans.deleteCharAt(ans.length() - 1);

### max/min possible values:

Integer.MAX_VALUE; or Integer.MIN_VALUE;

### **Loop Through Letters in For Loop:**

for(char let = ‘Z’; let ≥ ‘A’; let—);

### **Priority Queues:**
