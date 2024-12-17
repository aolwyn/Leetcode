<h1> Algorithms </h1>

<p> To you, the reader - a quick <strong>disclaimer</strong>. I <u>do not claim to cover all material that you may have taught</u>. I simply summarize here what is taught in the majority of textbooks, from my hand written notes, and from when I took the class in undergrad. If there is material you'd like specifically covered, please don't hesistate to reach out. </p>

<p><strong>P.S. - would check out the README in the Java folder if you'd like a recap on data structures + some algorithms. There is also visualizations and graphics in that file.</strong></p>

<h1>Table of Contents</h1>



<h1>Algorithms</h1>
<p>An algorithm is a well-defined computational procedure that takes a
value or set of values as input and produces a value or a set a values
as output; it completes the computation in a finite amount of time. </p>

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

</p>

<h2>Pseudocode</h2>
<p>code, but make it english (basically). <br>Example:</p>

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
- if you want a quick run through in Java, see the readme.