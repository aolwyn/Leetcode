<h1> Algorithms </h1>

<p> To you, the reader - a quick <strong>disclaimer</strong>. I <u>do not claim to cover all material that you may have taught</u>. I simply summarize here what is taught in the majority of textbooks, from my hand written notes, and from when I took the class in undergrad. I <u>specifically leave out mathematical concepts</u> (i.e., matrix mult.) as they are simply not worth my time to write out in markdown format. You are still responsible for learning this. If there is material you'd like specifically covered, please don't hesistate to reach out. </p>

<p><strong>P.S. - would check out the README in the Java folder if you'd like a recap on data structures + some algorithms. There is also visualizations and graphics in that file. This is also a personal repository and has nothing to do with being a TA (Fall 2024). <u>Don't</u> throw me under the bus 😎.</strong></p>

# Table of Contents
- [Table of Contents](#table-of-contents)
  - [Designing Algorithms](#designing-algorithms)
    - [Incremental Technique](#incremental-technique)
    - [Divide-and-Conquer Technique](#divide-and-conquer-technique)
  - [Insertion Sort](#insertion-sort)
    - [Process](#process)
    - [Complexities](#complexities)
  - [Merge Sort](#merge-sort)
    - [Process](#process-1)
    - [Complexities](#complexities-1)
  - [Asymptotic Analysis](#asymptotic-analysis)
  - [Recurrence Relations](#recurrence-relations)
    - [Master Method](#master-method)
      - [Example - merge sort](#example---merge-sort)
    - [Substitution Method](#substitution-method)
      - [Example - binary search](#example---binary-search)
    - [Recursion-Tree Method](#recursion-tree-method)
      - [Example - merge sort](#example---merge-sort-1)
  - [Matrix Multiplication](#matrix-multiplication)
    - [Blocked Matrix Multiplication](#blocked-matrix-multiplication)
    - [Performance Issues with Memory Hierarchy](#performance-issues-with-memory-hierarchy)
    - [Blocked/Tiled Matrix Multiplication](#blockedtiled-matrix-multiplication)
  - [Dynamic Programming](#dynamic-programming)
    - [Key Concepts](#key-concepts)
    - [Steps in Dynamic Programming](#steps-in-dynamic-programming)
    - [Example: Matrix-Chain Multiplication](#example-matrix-chain-multiplication)
  - [Greedy Algorithms](#greedy-algorithms)
    - [Key Principles](#key-principles)
    - [Applications](#applications)
      - [Huffman's Algorithm](#huffmans-algorithm)
  - [Branch and Bound](#branch-and-bound)
    - [Pruning Conditions](#pruning-conditions)
  - [Sets](#sets)
    - [Implementation with Rooted Trees](#implementation-with-rooted-trees)
      - [Pseudocode for the above operations](#pseudocode-for-the-above-operations)
    - [Optimization Techniques (for the trees)](#optimization-techniques-for-the-trees)
  - [Graphs](#graphs)
    - [Breadth-First Search (BFS)](#breadth-first-search-bfs)
    - [Depth-First Search (DFS)](#depth-first-search-dfs)
    - [Topological Sort](#topological-sort)
    - [Strongly Connected Components (SCC)](#strongly-connected-components-scc)
  - [Minimum Spanning Trees (MST)](#minimum-spanning-trees-mst)
    - [Kruskal's Algorithm](#kruskals-algorithm)
    - [Prim's Algorithm](#prims-algorithm)
    - [Theoretical and Practical Considerations for MSTs](#theoretical-and-practical-considerations-for-msts)
  - [Path Finding](#path-finding)
  - [**Single Source Shortest Paths**](#single-source-shortest-paths)
    - [Relaxation Technique](#relaxation-technique)
      - [Importance of Relaxation](#importance-of-relaxation)
    - [Bellman-Ford Algorithm](#bellman-ford-algorithm)
    - [Dijkstra's Algorithm](#dijkstras-algorithm)
    - [Directed Acyclic Graphs (DAG)](#directed-acyclic-graphs-dag)
    - [Complexities](#complexities-2)
  - [All Pairs - Shortest Path](#all-pairs---shortest-path)
    - [Matrix Multiplication-Based Approach](#matrix-multiplication-based-approach)
    - [Floyd-Warshall Algorithm](#floyd-warshall-algorithm)
    - [Transitive Closure](#transitive-closure)
      - [Floyd-Warshall Algorithm Adapted for Transitive Closure](#floyd-warshall-algorithm-adapted-for-transitive-closure)
  - [P, NP, NPC Completeness](#p-np-npc-completeness)
    - [Overview and Key Questions](#overview-and-key-questions)
    - [Definitions and Relationships Among Complexity Classes](#definitions-and-relationships-among-complexity-classes)
    - [Verification Algorithm Inputs](#verification-algorithm-inputs)
    - [Purpose of Reduction Algorithms](#purpose-of-reduction-algorithms)
    - [Relationships and Practical Implications](#relationships-and-practical-implications)
    - [Complexity Classes and Their Importance](#complexity-classes-and-their-importance)
  - [P, NP, NPC Proofs](#p-np-npc-proofs)
    - [Proving a problem is in NP](#proving-a-problem-is-in-np)
    - [Proving a problem is NP-Complete](#proving-a-problem-is-np-complete)
    - [Reduction algorithms](#reduction-algorithms)
    - [Using the Classes P, NP, and NPC in Proofs](#using-the-classes-p-np-and-npc-in-proofs)
    - [Complexity Class Containment](#complexity-class-containment)



<h1>Algorithms</h1>
<p>An algorithm is a well-defined computational procedure that takes a
value or set of values as input and produces a value or a set a values
as output; it completes the computation in a finite amount of time. Algorithms are important as they improve efficiency and provide a systematic way to solving problems. </p>

<p>An algorithm is <em>correct</em> if, for every instance provided as input,
it halts <u>and</u> it produces the correct output for that instance.</p>

<h2>Algorithms Vs. Techniques</h2>
<p>Algorithm: A specific, step-by-step procedure to solve a problem (e.g., binary search). <br>
Technique: A general method or strategy for solving problems (e.g., divide-and-conquer).</p>



<h2>Loop Invariants</h2>
<p>A statement that remains true across loop iterations. 3 properties:
    <ol>
        <li>Initialization: True before loop starts.</li>
        <li>Maintenance: Remains true after each iteration.</li>
        <li>Termination: Ensures correctness when loop ends.</li>
    </ol>
For example. Let's say we were looking to sum the values of an array, 

```python
sum = 0
for i in range(1, n+1): 
    sum = sum + i
```
The invariant here would be a summation: 

$$
\sum_{k=1}^{i-1}k
$$

You can test before (0) and during the loop and this invariant always holds true.

As another example, Let's say we want to count how many times the integer `x` appears in an array `arr`. The code is as follows:

```python
def count_occurrences(arr, x):
    count = 0
    for i in range(len(arr)):
        if arr[i] == x:
            count += 1
    return count
```

The Invariant could be written as,

$$
count = \sum_{k=0}^{i-1} f(arr[k], x)
$$

where `f(arr[k], x)` is considered as:

$$
f(arr[k], x) = 
  \begin{cases} 
    1 & \text{if } arr[k] = x \\
    0 & \text{otherwise}
  \end{cases}
$$

Lets explain this. To start, the function returns 
`1` if the element at position `𝑘` in the array `arr` equals `𝑥`, and `0` otherwise. 

Now to prove the Invariant Properties:

- **Initialization**: At the start (before the first iteration, when `i = 0`), the summation is over an empty set, which correctly initializes `count = 0`.

- **Maintenance**: On each iteration, if `arr[i] = x`, the function `f(arr[i], x)` contributes `1` to the sum, updating the `count` to include the current element. This maintains the correctness of the `count` through each iteration.

- **Termination**: At the end of the loop, the condition `i = len(arr)` ensures that `count` represents the sum of `f(arr[k], x)` for every `k` from `0` to `len(arr)-1`, which is the total occurrences of `x` in `arr`.
</p>

<h2>Pseudocode</h2>
<p>Code, but make it English (basically). <br>Example:</p>

```
FUNCTION FindMaximum(A, n)
    // Initialize maximum element
    max ← A[1]
    
    // Loop through the list
    FOR i ← 2 TO n DO
        IF A[i] > max THEN
            max ← A[i]
        ENDIF
    ENDFOR
    
    RETURN max
END FUNCTION
```

## Designing Algorithms

### Incremental Technique
- Adds a new item to data already in a specific state (e.g., sorted).
- Example: Insertion sort.

### Divide-and-Conquer Technique
- Splits problem into smaller subproblems.
- Recursively solves subproblems and combines results.
  - **Divide**: Break problems into subproblems.
  - **Conquer**: Solve subproblems recursively.
  - **Combine**: Merge solutions to solve the original problem.
- Requires:
  - **Base case**: Directly solvable.
  - **Recursive case**: Divides, conquers, and combines solutions.
- Example: Merge sort.

## Insertion Sort
### Process

1. **Start from the beginning**: Consider the first element of the array as sorted.
2. **Pick the next element**: Move to the next element and store its value in a temporary variable.
3. **Compare with sorted elements**: Compare this element with the sorted elements in the array (i.e., the elements to the left of the current position).
4. **Shift elements**: Shift all elements that are larger than the current element one position to the right to make space.
5. **Insert the element**: Insert the current element into its correct position within the sorted subset.
6. **Repeat**: Repeat steps 2-5 for each element in the array until the entire array is sorted.

### Complexities
- **Time Complexity**: Average and worst-case time complexity is `O(n^2)`, where n is the number of items being sorted.
- **Space Complexity**: `O(1)` additional space, making it an in-place sorting algorithm.


## Merge Sort

### Process

1. **Divide**: If the list is of length 0 or 1, it is already sorted. Otherwise, divide the list into two halves.
2. **Conquer**: Recursively sort both halves of the list.
3. **Combine**: Merge the two halves together into a single sorted list.

### Complexities
- **Time Complexity**: `O(nlog n)` for all cases (best, average, worst) because the list is divided into halves and each element is considered at each level of merge operations.
- **Space Complexity**: `O(n)` additional space is required for the merging process, not counting the space used for the input array.

## Asymptotic Analysis
Effectively, how we categorize run times.

- **O-Notation**: Upper bound on the growth (worst-case).
- **Ω-Notation**: Lower bound on the growth (best-case).
- **Θ-Notation**: Tight bound, indicates exact growth with increasing input size.

This means, For a function `f(n)`, `f(n) = Θ(g(n))` if `f(n) = O(g(n))` and `f(n) = Ω(g(n))`.

We prefer precise notation (`Θ`) over general bounds (`O` or `Ω`) when possible.

## Recurrence Relations
**Recurrence Relations** define the running time of recursive algorithms by expressing the time complexity in terms of the input size minus some increment. Essentially, they describe how a problem of size `n` can be solved by breaking it down into one or more smaller problems, often of size `n/b`, and combining their solutions with additional work `f(n)`.

General form: `T(n) = aT(n/b) + f(n)`
, where:
- `a` ≥ 1 is the number of recursive calls,
- `n/b` is the size of each subproblem,
- `f(n)` is the cost of the work done outside the recursive calls.

3 types of methods to solving these. I'll show examples. 

### Master Method
1. **Compare `f(n)` with `n^c`** where `c = log_b(a)`.
2. **Case Determination**:
 - **Case 1**: If `f(n) = O(n^c-ε)` for some ε > 0, then `T(n) = Θ(n^c)`.
 - **Case 2**: If `f(n) = Θ(n^c log^k(n))` for some k ≥ 0, then `T(n) = Θ(n^c log^(k+1)(n))`.
 - **Case 3**: If `f(n) = Ω(n^c+ε)` for some ε > 0 and `af(n/b) ≤ cf(n)` for some c < 1 and large `n`, then `T(n) = Θ(f(n))`.
3. **Conclusion**: Determine which case fits `f(n)` and apply the corresponding formula to find `T(n)`.

#### Example - merge sort 

Merge sort: `(T(n) = 2T(n/2) + n)`

Here, `a = 2`, `b = 2`, and `f(n) = n`. 
We compute `c = log_b(a) = log_2(2) = 1`.
- **Step 1**: Compare `f(n)` with `n^c`, where `c = 1`.
- **Step 2**: Since `f(n) = n` matches `Θ(n^1)`, this falls under **Case 2** of the Master Method.
- **Conclusion**: `T(n) = Θ(n log n)`.

### Substitution Method
- The Substitution Method involves guessing the form of the solution and then using mathematical induction to prove the guess is correct.

Steps to Apply the Substitution Method:
1. **Make an Educated Guess**: Propose a form for `T(n)`, such as `T(n) = Θ(n^2)`.
2. **Use Induction**:
 - **Base Case**: Verify your guess for small values of `n`.
 - **Inductive Step**: Assume the guess is true for `n` and show it holds for `n+1` (or another function of `n` like `n/b`).
3. **Validate the Guess**: Ensure the boundary conditions and recursive cases all confirm the initial guess.

#### Example - binary search

Binary search: `T(n) = T(n/2) + 1`.
We guess that `T(n) = Θ(log n)`.

Application of the Substitution Method:
1. **Base Case**: Verify for `n = 1`, `T(1) = Θ(1)`, which matches as `log 1 = 0`.
2. **Inductive Step**:
   - Assume `T(n/2) = Θ(log (n/2))`.
   - Then, `T(n) = T(n/2) + 1 = Θ(log (n/2)) + 1 = Θ(log n - log 2 + 1) = Θ(log n)`.
3. **Validate the Guess**: The substitution and inductive step confirm our guess that `T(n) = Θ(log n)` holds.


### Recursion-Tree Method
The Recursion-Tree Method visualizes the recursion as a tree, where each node represents a cost incurred at that level of recursion. The total cost is the sum of costs at all levels.

Steps to Apply the Recursion-Tree Method:
1. **Draw the Recursion Tree**: Each node represents `T(n/b^i)` where `i` is the depth of the tree. The cost at each node is `f(n/b^i)`.
2. **Calculate Cost per Level**: Sum the costs of all nodes at each level of the tree.
3. **Sum All Levels**: Add up the costs across all levels to determine the total cost.
4. **Analyze the Sum**: Depending on the growth or shrinkage of costs across levels (geometric progression, etc.), determine the asymptotic behavior of `T(n)`.

#### Example - merge sort

reminder, merge sort: `T(n) = 2T(n/2) + n`. 

Application of the Recursion-Tree Method:
1. **Draw the Recursion Tree**:
   - At level 0: Cost is `n`.
   - At level 1: Cost is `2(n/2) = n`.
   - At level 2: Cost is `4(n/4) = n`.
   - This pattern continues down the levels.
2. **Calculate Cost per Level**: Each level contributes `n`.
3. **Sum All Levels**: The depth of the tree is `log n`, summing `n` across `log n + 1` levels.
4. **Analyze the Sum**: The sum across all levels is `n(log n + 1)`, simplifying to `Θ(n log n)`.

## Matrix Multiplication
- comparing the regular to the others, <strong>TL;DR</strong>
  - Strassen's and Tiled/Blocked Matrix Multiplication: Strassen's algorithm reduces the complexity to `O(n^2.807)`by decreasing recursive multiplications, while tiled or blocked techniques improve execution by optimizing data locality and cache usage, significantly enhancing performance by minimizing memory hierarchy delays.

- **Simple Recursive Approach**:
  - **Operation**: Subdivides matrix into smaller matrices, recursively performs multiplication, and combines results without explicitly managing data movement between memory hierarchies.
  - **Running Time**: Defined by the recurrence `T(n) = 8T(n/2) + Θ(1)`, leading to a `Θ(n^3)` time complexity.

- **Strassen’s Algorithm**:
  - **Enhancement**: Reduces the number of recursive multiplications, changes how submatrices are combined.
  - **Recurrence Relation**: `T(n) = 7T(n/2) + Θ(n^2)`.
  - **Improvement**: Achieves a running time of `Θ(n^2.807)`, showcasing an asymptotic improvement over the naive approach.

### Blocked Matrix Multiplication

### Performance Issues with Memory Hierarchy
- **Concept**: Blocking or tiling is used to optimize matrix multiplication in the context of modern computer architectures with memory hierarchies.

### Blocked/Tiled Matrix Multiplication
- **Implementation**: Rearranges the standard matrix multiplication to improve cache usage, reducing the number of cache misses.
- **Details**: 
  - Loops are blocked in such a way that the data needed for one block of computation stays in cache as long as possible.
  - The operation involves iterating over blocks and performing multiplication within blocks, improving data locality.

 ## Dynamic Programming

**Dynamic Programming (DP)** solves problems by combining solutions to overlapping subproblems, typically using memoization to save results of subproblems.

### Key Concepts
- **Memoization**: An optimization technique that involves storing the results of expensive function calls and returning the cached result when the same inputs occur again.
- **Tabulation**: A bottom-up dynamic programming approach where results are solved for and stored in a table, typically avoiding recursion by filling up entries in a systematic manner.

### Steps in Dynamic Programming
1. **Characterize the Structure of an Optimal Solution**: Break down the problem into smaller subproblems and understand how these subproblems contribute to the overall solution.
2. **Recursively Define the Value of an Optimal Solution**: Formulate the problem in terms of recursive equations, expressing the solution to the problem in terms of solutions to smaller subproblems.
3. **Compute the Value of an Optimal Solution**: Using either memoization (top-down) or tabulation (bottom-up), fill out the values needed to construct the solution.
4. **Construct an Optimal Solution from Computed Information**: Use the stored information to backtrack and determine the sequence of decisions that leads to the optimal outcome.

### Example: Matrix-Chain Multiplication
- **Problem**: Determine the most efficient way to multiply a chain of matrices.
- **Solution**: Use DP to find the minimum number of multiplications by splitting the problem into smaller segments and solving for the minimal cost at each split.
- **Implementation Details**:
  - Use a DP table to store the minimum cost of multiplying matrices from i to j.
  - The optimal cost is determined by splitting the product at different points and combining the results using previously computed values.

## Greedy Algorithms

**Greedy Algorithms** solve optimization problems by making a series of choices, each locally optimal, with the hope that this leads to a globally optimal solution.

### Key Principles
- **Greedy-Choice Property**: Each choice is local and does not require re-evaluating previous choices.
- **Optimal Substructure**: A problem exhibits optimal substructure if an optimal solution to the problem contains optimal solutions to its subproblems.

### Applications
- **Huffman Coding**: A greedy method for data compression that builds an optimal prefix-free binary tree based on character frequencies.
- **Offline Caching**: Utilizes a farthest-in-future strategy to minimize cache misses, demonstrating the application of greedy algorithms in system optimizations.

#### Huffman's Algorithm
```
Algorithm Huffman(C):
    Input: A set C of n characters and their frequencies
    Output: An optimal prefix-free binary tree

    1. Create a priority queue Q to hold trees, initially containing all characters in C, each as a single-node tree with frequency as the key.
    
    2. for i from 1 to n - 1:
        a. Allocate a new node z
        b. z.left = x = Extract-Min(Q)  // Remove and get the node with the smallest frequency
        c. z.right = y = Extract-Min(Q) // Remove and get the next smallest frequency node
        d. z.frequency = x.frequency + y.frequency  // Set the frequency of new node as the sum of the two
        e. Insert Q, z  // Insert the new node back into the priority queue
    
    3. Return Extract-Min(Q)  // The remaining node in the queue is the root of the Huffman tree
```

## Branch and Bound
**Branch and Bound** is an algorithmic technique used to solve combinatorial optimization problems by systematically enumerating all candidate solutions.

Branch and bound is commonly applied to the **Graph Bisection Problem**, where the task is to divide the graph into two subsets (cells) that are as equal as possible in terms of vertex weight, while minimizing the sum of the weights of the edges that are cut.

The logic is as follows:

- **Subproblem Division**: Divide the original problem into smaller subproblems.

- **Tree Representation**: Solutions are explored in a tree format, where each node represents a subproblem.

- **Bounding**: Use upper and lower bounds to prune the search space, avoiding paths that cannot produce a better solution than already found.

the **Root** node represents the starting point of the problem. **Leaf** nodes represent early stopping points due to a condition (see below,) or a feasible solution with known cost.

The Pseudocode is as follows:
```
Algorithm Branch_and_Bound():
    Input: Graph G = (V, E) with vertex weights
    Output: A minimum-cost balanced bisection of G

    1. Initialize priority queue Q with the root node (initial partial solution)
    2. Set initial upper bound U to infinity

    while Q is not empty:
        3. Extract node N from Q with the lowest bound
        4. If the bound of N >= U:
            5. Continue to next iteration (Prune this node)
        6. If N represents a complete solution:
            7. If cost(N) < U:
                8. Update U = cost(N)
                9. Continue to next iteration
        10. Else:
            11. Branch N into new nodes based on possible next steps
            12. For each new node M:
                13. Calculate lower bound of M
                14. If lower bound of M < U:
                    15. Add M to Q
    16. Return the solution corresponding to U
```

### Pruning Conditions
Pruning in Branch and Bound algorithms involves skipping the exploration of certain branches of the search tree. This happens under the following conditions:
1. **Bound Comparison**: If the lower bound of a node is greater than or equal to the best solution found so far (upper bound U), there's no need to explore this node further because it cannot possibly lead to a better solution.
2. **Feasibility**: If a node or its development violates problem constraints or conditions for optimality, it is pruned.

## Sets
A **set** is an abstract data type that can store certain values, without any particular order, and with no repeated values. It is a collection of distinct objects.

**Characteristics**:
  - **Unordered**: The elements in a set do not have a specific order.
  - **Unique Elements**: Each element appears only once; no duplicates are allowed.
  - **Access Operations**: Basic operations include adding elements, removing elements, and checking whether an element exists in the set.

We also have what is called **Disjoint Sets**. Disjoint set data structures, also known as union-find or merge-find sets, are used to keep track of a partition of a universe into disjoint (non-overlapping) sets. Disjoint sets are particularly useful in network connectivity, image processing, and finding cycles in graphs where the universe is a set of elements and the partitions are subsets.

Disjoint sets have a few operations associated with them:
- **Make-Set(x)**: Initializes a new set with x as its only member.
- **Union(x, y)**: Merges the sets containing elements x and y, with one set's representative pointing to the other's.
- **Find-Set(x)**: Returns the representative of the set containing x, which involves following parent pointers up to the root.

Disjoint sets can be done with linked lists, but they suck. So the more common approach is to use a tree. Specifically, a rooted tree.

###  Implementation with Rooted Trees
- **Structure**: Each set is represented by a rooted tree where each node points to its parent and the root points to itself.
- **Operations**:
  - **Make-Set(x)**: x points to itself, effectively its own parent.
  - **Find-Set(x)**: Traverse parent pointers until the root is reached.
  - **Union(x, y)**: The roots of the trees containing x and y are linked. The decision of which root becomes the representative can be optimized using methods like union by rank.

#### Pseudocode for the above operations
``` 
Make-Set(x)
  x.parent = x
  x.rank = 0

Union(x, y)
  rootX = Find-Set(x)
  rootY = Find-Set(y)
  if rootX != rootY
      Link(rootX, rootY)

Find-Set(x)
  if x != x.parent
      x.parent = Find-Set(x.parent)
  return x.parent
```

### Optimization Techniques (for the trees)
1. **Union by Rank**: Maintains a rank for each tree as an estimate of its height and ensures that the smaller tree (by rank) is pointed to the larger tree to avoid increasing the tree height unnecessarily.
2. **Link(x, y)**: Function to link two trees based on their ranks. If ranks are equal, the rank of the resulting tree is incremented.
3. **Path Compression**: During a Find-Set operation, makes all nodes on the path from a found node to the root point directly to the root, flattening the structure and speeding up future operations.

## Graphs
- Note. If you're confused after reading this section, see the Java folder.

 A graph  `G = (V, E)`  consists of a set of vertices `V`  and a set of edges `E`  that connect pairs of vertices. Graphs can be either directed (arrows) or undirected (lines).

 A graph can be represented in 1/2 ways:
 1.  **Adjacency List**: Best for large sparse graphs, stores a list of adjacent vertices for each vertex, with a storage requirement of  `Θ(V + E)`.
 2.  **Adjacency Matrix**: Suitable for dense graphs or when fast edge existence checks are needed, uses a matrix to represent edges with a storage requirement of `Θ(V^2)`.

Graphs can be searched using multiple different methods. The most frequently used are BFS and DFS.

### Breadth-First Search (BFS)
- **Purpose**: Discovers all vertices reachable from a source vertex `s`, computing the shortest path from `s` to each vertex in terms of edge count.
- **Process**: Expands level by level from the source, using a queue to manage the frontier and marking vertices as visited.
- **Running Time**: `O(V + E)` with an adjacency list representation.

Pseudocode:
```
 BFS(G, s)
    for each vertex u in G.V - {s}
      u.color = WHITE
      u.distance = INFINITY
      u.parent = NIL
    s.color = GRAY
    s.distance = 0
    s.parent = NIL
    Q = empty queue
    ENQUEUE(Q, s)
    while Q is not empty
      u = DEQUEUE(Q)
      for each v in G.Adj[u]
        if v.color == WHITE
          v.color = GRAY
          v.distance = u.distance + 1
          v.parent = u
          ENQUEUE(Q, v)
      u.color = BLACK
```

### Depth-First Search (DFS)
- **Purpose**: Explores as far as possible along each branch before backtracking, useful for classification of edges and properties like connectivity.
- **Process**: Uses a stack (implicitly via recursion) to dive deep into the graph, backtracking when no further advancement is possible.
- **Running Time**: `Θ(V + E)` with an adjacency list representation.

Pseudocode:
```
DFS(G)
  for each vertex u in G.V
    u.color = WHITE
    u.parent = NIL
  time = 0
  for each vertex u in G.V
    if u.color == WHITE
      DFS-VISIT(G, u)

DFS-VISIT(G, u)
  time = time + 1
  u.discovery = time
  u.color = GRAY
  for each v in G.Adj[u]
    if v.color == WHITE
      v.parent = u
      DFS-VISIT(G, v)
  u.color = BLACK
  time = time + 1
  u.finishing = time
```

### Topological Sort
- **Purpose**: Orders the vertices of a directed acyclic graph (DAG) linearly such that for every directed edge ` (u, v)`, vertex `u` appears before `v`.
- Topological sort is often used in scheduling tasks, for things where some tasks might precede others (think prerequisites for a course.)
- **Process**: Utilizes DFS to sort vertices by decreasing order of finishing times.
- **Running Time**:  `Θ(V + E)` using DFS.

Psuedocode:

```
TOPOLOGICAL-SORT(G)
  call DFS(G) to compute finishing times v.f for each vertex v
  as each vertex is finished, insert it onto the front of a linked list
  return the linked list of vertices
```

### Strongly Connected Components (SCC)
SCC's identify maximal sets of nodes in a directed graph where each node is reachable from any other node in the same set.

Graph Types Without SCC: Directed acyclic graphs (DAGs) do not have strongly connected components as there are no cycles, meaning no vertex can reach itself via a directed path.
  

  The process to get the SCC is as follows:

  1. Perform a DFS of the graph to get finish times.
  2. Compute the transpose of the graph.
  3. Perform DFS on the transposed graph in the order of decreasing finish times from the first DFS.
- **Running Time**:  `Θ(V + E)` for both DFS executions and the graph transpose, making it highly efficient.

## Minimum Spanning Trees (MST)
A **Minimum Spanning Tree (MST)** of a weighted, connected, undirected graph is a spanning tree with the minimum possible total edge weight. A spanning tree is a subset of the graph's edges that forms a tree including every vertex and has no cycles.

They are used in scenarios like connecting different components in engineering projects (e.g., circuit board wiring) with the least material cost.

**Goal**: To connect all vertices in a graph with the minimum total edge weight without any cycles, forming a spanning tree.

There are 2 algorithms to compute / create a MST.

### Kruskal's Algorithm
**Approach**: Build the MST by adding the next lightest edge that doesn't produce a cycle, typically managed with a disjoint-set data structure.

Use Cases: Network design, clustering, and determining pathways with minimal cost.

**Pseudocode**:
  ```plaintext
  KRUSKAL(G):
    A = ∅
    for each vertex v in G.V:
      MAKE-SET(v)
    sort the edges of G.E into nondecreasing order by weight w
    for each edge (u, v) in G.E, taken in sorted order:
      if FIND-SET(u) ≠ FIND-SET(v):
        A = A ∪ {(u, v)}
        UNION(u, v)
    return A
```

### Prim's Algorithm
**Approach**: Start from an arbitrary vertex and grow the MST by adding the cheapest possible connection from the tree to another vertex.

Use Cases: Similar to Kruskal's, used in network design and infrastructure planning where cost minimization is crucial.

**Pseudocode**:
```
PRIM(G, r): // r is start vertex
  for each u in G.V:
    u.key = ∞
    u.parent = NIL
  r.key = 0
  Q = G.V
  while Q is not empty:
    u = EXTRACT-MIN(Q)
    for each v in G.Adj[u]:
      if v in Q and w(u, v) < v.key:
        v.parent = u
        v.key = w(u, v)
  return G.V
```

### Theoretical and Practical Considerations for MSTs
- Graph Cuts and Light Edges: A cut in a graph divides the vertices into two disjoint subsets. A light edge crosses the cut and is the minimum weight edge from any of those in the cut.
- Asymptotic Complexity: Both algorithms can achieve 
`𝑂(𝐸log𝑉)`
 with efficient priority queue structures, making them suitable for large graphs.

## Path Finding

As the name suggests, how to determine the shortest paths. There's a few categories in this, but notably, how to find the shortest path given an input and then a pairwise method.

 **Optimal Substructure**: A shortest path between two vertices contains other shortest paths within it. This property is foundational for developing shortest path algorithms.

Use case includes Navigation in road networks, routing in computer networks, and logistics optimization.

**Problem Variants**:
  - **Single-Destination**: Find the shortest path to a specific vertex by reversing edge directions.
  - **Single-Pair**: Directly determine the shortest path between two specified vertices.
  - **All-Pairs**: Compute the shortest paths from each vertex to every other vertex 

## **Single Source Shortest Paths**

### Relaxation Technique
Relaxation is an operation at the heart of many shortest path algorithms that attempts to improve the shortest path estimate for a vertex.

**Process**:
  1. **Initial Setup**: Each vertex  `v` in the graph has a distance value `d[v]`, initially set to infinity, except for the source vertex ` s ` which is set to zero.
  2. **Edge Relaxation**: For an edge `(u, v)` with weight ` w(u, v) `, if `d[v]` can be reduced by taking `u` en route to `v`, then the relaxation process updates `d[v]` to `d[u] + w(u, v)` and sets `v`'s predecessor to `u`.
  Pseudocode for the Relax function: 
```
    RELAX(u, v, w):
      if d[v] > d[u] + w(u, v):
        d[v] = d[u] + w(u, v)
        π[v] = u
```

- **Usage in Algorithms**:
  - **Dijkstra's Algorithm**: Uses relaxation to iteratively finalize the shortest path to each vertex, ensuring no cycles with negative weights.
  - **Bellman-Ford Algorithm**: Applies relaxation to all edges in each of  `|V|-1` iterations, where `|V|` is the number of vertices. It also checks for negative-weight cycles by verifying that no further relaxations are possible.

#### Importance of Relaxation
- **Efficiency**: Relaxation helps algorithms converge to the correct shortest path distances quickly and efficiently.
- **Detecting Negative Cycles**: In the Bellman-Ford algorithm, if a relaxation operation can still reduce  `d[v]` after `|V|-1` iterations, a negative-weight cycle is present, which affects the feasibility of finding reliable shortest paths.

<u>TLDR</u> - Relaxation is a fundamental operation that optimizes the pathfinding process in graph algorithms by systematically ensuring that the shortest path estimates are minimized according to graph topology and edge weights.


### Bellman-Ford Algorithm
The Bellman-Ford algorithm computes the shortest paths from a single source vertex to all other vertices in a graph and is **capable of handling graphs with negative weight edges**.

Unlike Dijkstra’s, it can accommodate graphs containing negative weight edges as long as there are no negative weight cycles.

It provides a method to detect negative weight cycles reachable from the source, which are scenarios where no shortest path exists.

Pseudocode:
```
BELLMAN-FORD(G, w, s):
  INITIALIZE-SINGLE-SOURCE(G, s) // Set all vertices' distances to ∞ except for the source s which is set to 0
  for i from 1 to |G.V|-1:       // Loop through vertices |V|-1 times (where |V| is the number of vertices)
    for each edge (u, v) in G.E:
      RELAX(u, v, w)             // Relax each edge, trying to find shorter paths
  for each edge (u, v) in G.E:
    if v.d > u.d + w(u, v):      // Check for negative-weight cycles that are reachable from the source
      return FALSE               // If a cycle is found, return FALSE
  return TRUE                    // If no cycles, return TRUE indicating success

```

### Dijkstra's Algorithm
Dijkstra's algorithm finds the shortest paths from a source vertex to all other vertices in a graph with **non-negative edge weights**. It progressively expands the closest frontier until all vertices are processed.

Utilizes a priority queue to always extend the shortest path discovered so far.

Efficient for graphs with non-negative weights and widely used in practical applications such as GPS navigation systems.


Pseudocode:
  ```plaintext
  DIJKSTRA(G, w, s):
    INITIALIZE-SINGLE-SOURCE(G, s)      // Initialize the graph, set source distance to 0, others to ∞
    S = empty set                       // S will eventually contain the vertices with finalized shortest paths
    Q = G.V                             // Priority queue of all vertices in the graph, prioritized by shortest distance to s
    while Q is not empty:
      u = EXTRACT-MIN(Q)                // Extract vertex u, the one with the smallest distance estimate
      S = S ∪ {u}                       // Add u to the set of finalized vertices
      for each vertex v adjacent to u:
        RELAX(u, v, w)                  // Relax the edge if a shorter path from s to v through u is found
```

### Directed Acyclic Graphs (DAG)
DAGs are a special case - these graphs do not contain cycles, thus enabling unique topological sorting and efficient shortest path calculations. DAGs have guaranteed convergence. 
```
DAG-SHORTEST-PATHS(G, w, s):
  topologically sort the vertices of G
  INITIALIZE-SINGLE-SOURCE(G, s)
  for each vertex u, taken in topologically sorted order
    for each vertex v adjacent to u
      RELAX(u, v, w)
```
### Complexities
While Dijkstra's algorithm can be optimized to 
`O(ElogV)` with the right priority queue, Bellman-Ford operates in `O(VE)`, suitable for different scenarios based on graph density and edge weight characteristics.

## All Pairs - Shortest Path

All-pairs shortest paths algorithms are designed to find the shortest paths between every pair of vertices in a graph.

Use case includes road network distances and communication network diameter, measuring the longest transit time through the network.

In theory, you could use repeated single-source algorithms but specialized all-pairs algorithms aim for better efficiency.

**Edge-Weight Matrix (W)**: A matrix representation of the graph where each element `w_{ij}` represents the weight of the edge from vertex `i` to vertex ` j `. If there is no edge, ` w_{ij} ` is typically set to infinity (`∞`).

**Predecessor Matrix (Π)**: A matrix where each element `π_{ij}` points to the predecessor of vertex `j` on the shortest path from vertex `i`. If no path exists, `π_{ij}` is set to nil.

### Matrix Multiplication-Based Approach
This method uses a matrix multiplication technique to compute the shortest path lengths by repeatedly squaring the adjacency matrix. (uses dynamic programming)

Use case: Efficient for dense graphs where edge connections are rich and matrix multiplication computational overhead is justified. (remember, matrix mult has high overhead!)

Pseudocode:
  ```
  MATRIX-MULTIPLICATION-SHORTEST-PATHS(W):
    L = W
    for m from 2 to n
      L = EXTEND-SHORTEST-PATHS(L, W)
    return L
```

### Floyd-Warshall Algorithm
The Floyd-Warshall algorithm is a dynamic programming solution that computes shortest paths between all pairs of vertices in `O(n^3)` time using only space for two matrices (a series of "intermediate" vertices).

Utilizes the property that a shortest path from 
`𝑖` to `𝑗`using only vertices among `{1, ..., k}` as intermediate points can be found by considering all possible paths through the k-th vertex.

Particularly useful for computing paths in dense graphs or when retrieving the shortest path details is as important as determining the shortest path length.

Pseudocode:
```
  FLOYD-WARSHALL(W):
    let D = W                    // Initialize the distance matrix with edge weights
    for k from 1 to n:           // Intermediate vertices
      for i from 1 to n:         // Start vertex
        for j from 1 to n:       // End vertex
          D[i][j] = min(D[i][j], D[i][k] + D[k][j])  // Update distance
    return D
```

Technically, the algorithm can also be applied to single source but its highly unlikely. It can technically return a row or column corresponding to a single source, this method doesn't capitalize on the algorithm's strengths and is less efficient compared to using Dijkstra’s or Bellman-Ford algorithm for single-source shortest paths. This adaptation doesn't provide computational or conceptual advantages over these other algorithms in a single-source scenario. If you're interested, its here:
```
FLOYD-WARSHALL(G, w, s):
  D = matrix of edge weights w        // Initialize the distance matrix with edge weights
  for k from 1 to |G.V|:              // Intermediate vertices considered
    for i from 1 to |G.V|:
      for j from 1 to |G.V|:
        D[i][j] = min(D[i][j], D[i][k] + D[k][j]) // Update the distance matrix by considering intermediate vertices
  return D[s]                         // Return the row of the distance matrix corresponding to the source vertex
```

### Transitive Closure

The transitive closure of a graph indicates whether there is a direct or indirect path between each pair of vertices. It helps determine the reachability of vertices from one another within a graph.

Transitive closure is used in various fields such as database query optimization, network analysis, and access control systems to determine connectivity and access possibilities between nodes or data points.

#### Floyd-Warshall Algorithm Adapted for Transitive Closure
While the Floyd-Warshall algorithm is traditionally used for finding shortest paths, it can be adapted to compute the transitive closure of a graph, providing a binary output (true/false) that indicates whether a path exists between each pair of vertices.

**Pseudocode**:
```plaintext
  TRANSITIVE-CLOSURE(W):
    let T = (W != ∞)             // Initialize the transitive closure matrix T, setting T[i][j] to true if there is a direct edge from i to j
    for k from 1 to n:           // Consider each vertex k as an intermediate point
      for i from 1 to n:         // For each vertex i
        for j from 1 to n:       // And each vertex j
          T[i][j] = T[i][j] or (T[i][k] and T[k][j])  // Update T[i][j] to reflect whether a path exists through vertex k
    return T
```

This adaptation of the Floyd-Warshall algorithm modifies the way the algorithm's main operation is performed. Instead of calculating minimum distances, it evaluates logical `OR` and `AND` operations to determine connectivity.

The initialization step sets each `T[i][j]` to true if there is a direct edge between `𝑖` and `𝑗` (i.e., the distance is not infinity). 

The algorithm iteratively updates the matrix 
`𝑇` to include indirect paths through intermediate vertices. If there is any path from `𝑖` to `𝑗` passing through 
`𝑘`, then `𝑇[𝑖][𝑗]` is set to true.

## P, NP, NPC Completeness

### Overview and Key Questions
- **Essential Open Question**: The most critical open question in theoretical computer science is whether **P = NP**. This query explores if every problem whose solution can be verified in polynomial time (`NP`) can also be solved in polynomial time (`P`).

### Definitions and Relationships Among Complexity Classes
- **Class `P`**: Comprises problems that can be solved deterministically in polynomial time.
- **Class `NP`**: Includes problems for which a solution can be verified in polynomial time by a nondeterministic algorithm.
- **NP-Complete (`NPC`)**: These are the hardest problems in NP. A problem is NP-Complete if:
  1. It is in `NP`.
  2. Every problem in `NP` can be polynomial-time reduced to it (NP-hardness).

### Verification Algorithm Inputs
- **Input Components**: A verification algorithm for an NP problem receives two inputs:
  1. **Certificate (Solution)**: A candidate solution to the problem.
  2. **Problem Instance**: The specific data or parameters that define an instance of the problem.

### Purpose of Reduction Algorithms

Reduction algorithms prove theoretical properties but also guide practical algorithm development. 

- **Functionality**: Reduction algorithms are used to transform one problem into another in polynomial time. They are critical for proving NP-completeness by demonstrating that a solution to a newly formulated problem implies a solution to a known NP-complete problem.
- **Application in Proofs**: These algorithms help establish that if a newly defined problem can be solved in polynomial time, then so can the original NP-complete problem, thereby extending the class `P` if `P = NP` is true.

### Relationships and Practical Implications
**Diagrammatic Representation**
  ```plaintext
  P ⊆ NP
  NPC ⊆ NP
  If P = NP, then P = NP = NPC.
  If P ≠ NP, then NPC problems are not solvable in polynomial time.
  ```
While the majority of computer scientists conjecture that `P ≠ NP`, proving this remains elusive. This belief underpins the importance of seeking efficient algorithms for NP problems, or at least less optimal or approximate solutions.

### Complexity Classes and Their Importance
Understanding these classes aids in identifying which computational problems are feasible to solve as technology evolves. Problems in `P` are considered tractable, while those in `NPC` are tackled with heuristic or approximate methods due to their presumed intractability.

## P, NP, NPC Proofs
Unsure if you will have learned this. Or if you learned what NP-Hard means. Below will be an `in the event of...`

### Proving a problem is in NP
 **Proof Strategy**: Direct explanation or constructive proof.
- **Details**:
  - **Objective**: Demonstrate that a given solution to the problem can be verified in polynomial time.
  - **Approach**: Provide a clear description or pseudocode of a polynomial-time verification algorithm.

#### Converting of Optimization Problems
- Convert to a decision problem  
- Permits easier reasoning because output is either <u>0 or 1</u>

### Proving a problem is NP-Complete
**Proof Strategy**: Proof by Reduction (Constructive proof).
- **Details**:
  - **NP Membership**: Show the problem is in NP by describing a polynomial-time verifier.
  - **NP-Hardness**: Employ a reduction from a known NP-Complete problem.
    - Construct a polynomial-time transformation of instances.
    - Ensure solutions map correctly between the reduced and original problems.
    - Use logical arguments or, occasionally, proof by induction for recursive structures.

### Language definition for (NP/NPC framework)
- A language is a <u>set of strings</u> built over an alphabet  
- For the NPC framework, it is <u>a set of strings accepted by an algorithm</u> (output decision algorithm is a <u>1</u>)

### Reduction algorithms
**Proof Strategy**: Proof by Construction.
- **Details**:
  - **Constructing the Reduction**: Design a polynomial-time algorithm that transforms one problem into another.
  - **Proving the Reduction Works**: Use logical arguments to show that the reduction maintains the essential properties of problems. Proof by induction might be relevant for iterative modifications.
 
#### Purpose of Reduction Algorithms
- A reduction transforms/recasts one language (problem) to another  
- Useful to apply from known NPC problem to new presumed NPC problem  
- A reduction to transform <u>binary encoding</u> from source language to destination language must be computable in <u>polynomial time</u>

### Input to a Verification Algorithm
- <u>binary encoding of problem instance</u>  
- <u>binary encoding of solution certificate</u>

### Proving CIRCUIT-SAT as the base NPC Problem
- First show that a <u>polynomial-time verification algorithm exists</u> (CIRCUIT-SAT ∈ NP)  
- Then show all other languages in NP are polynomial-time reducible to CIRCUIT-SAT by converting verification algorithms for those other languages to a <u>large combinational logic circuit</u>  
  - (Verification algorithm is a <u>1 → 1 comb. logic. circuit</u>, circuit output is <u>1</u>)



### Using the Classes P, NP, and NPC in Proofs
**Proof Strategy**: Logical deduction and class comparison.
- **Details**:
  - **Complexity Class Relationships**: Utilize known relationships like `P ⊆ NP`.
  - **Implications of Theoretical Results**: Use proof by contradiction to explore implications of potential proofs that `P = NP` or `P ≠ NP`.

### "Formal" NPC NP-Completeness Requirements
For language  `L_{0,1\}^{*} `:
1. L (is in) <u>NP</u>  
2. <u>L′ ≤p L for every L′ ∈ NP</u>

**Proof Strategy**: Logical deduction and class comparison.
- **Details**:
  - **Complexity Class Relationships**: Utilize known relationships like `P ⊆ NP`.
  - **Implications of Theoretical Results**: Use proof by contradiction to explore implications of potential proofs that `P = NP` or `P ≠ NP`.


###  Complexity Class Containment
1. **Proof for `P ⊆ NP`**
   - **Goal**: Show that every problem in `P` is also in `NP`.
   - **Proof Method**: Direct Proof.
   - **Steps**:
     1. **Definition Recall**: Remember, a problem is in `P` if there is a deterministic polynomial-time algorithm that solves it. A problem is in `NP` if a solution can be verified in polynomial time by a deterministic Turing machine.
     2. **Logical Argument**: If a problem can be solved in polynomial time, then any solution can be verified in no more time than it takes to solve it. Specifically, the verifier can simply ignore the provided solution, run the polynomial-time solver, and check if the output matches the given solution.
     3. **Conclusion**: Since every solver can be trivially converted into a verifier by solving the problem afresh and comparing the solution to the given one, every problem in P can be verified in polynomial time, hence `P ⊆ NP`.

2. **Proof for NPC ⊆ NP**
   - **Goal**: Demonstrate that all NP-Complete problems are within NP.
   - **Proof Method**: Definition and Logical Argument.
   - **Steps**:
     1. **Definition Recall**: NP-Complete problems are those problems to which every problem in NP can be reduced in polynomial time and which are themselves in `NP`.
     2. **Implication Understanding**: By definition, a problem must already be in `NP` to be considered for NP-completeness.
     3. **Conclusion**: Since being in NP is a prerequisite for being NP-Complete, it follows directly from the definition that `NPC ⊆ NP`.

3. **Demonstrating the Significance of ` P = NP `**
   - **Goal**: Explain what it means if `P = NP`.
   - **Proof Method**: Hypothetical Implication and Proof by Contradiction.
   - **Steps**:
     1. **Assume  `P = NP`: If `P = NP`**, then every problem whose solution can be verified in polynomial time can also be solved in polynomial time.
     2. **Implication for NPC**: Since NPC problems are the hardest problems in NP, and they would all fall into P, every NP problem becomes solvable in polynomial time, which would collapse the NP and NPC classes into P.
     3. **Challenge Existing Systems**: This would impact numerous fields, particularly cryptography, where the security of many systems relies on certain problems not being efficiently solvable.
     4. **Contradiction Exploration**: If one were to prove `P ≠  NP`, many current cryptographic methods remain secure, but proving ` P = NP ` would require reconstructing many foundational aspects of computer security. (unlikely to be asked.)
