<h1> Algorithms </h1>

<p> To you, the reader - a quick <strong>disclaimer</strong>. I do not claim to cover all material that you may have taught. I simply summarize here what is taught in the majority of textbooks, from my hand written notes, and from when I took the class in undergrad. If there is material you'd like specifically covered, please don't hesistate to reach out. </p>

<p><strong>P.S. - would check out the README in the Java folder if you'd like a recap on data structures.</strong></p>

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
- **Time Complexity**: Average and worst-case time complexity is O(n^2), where n is the number of items being sorted.
- **Space Complexity**: O(1)additional space, making it an in-place sorting algorithm.


## Merge Sort

### Process

1. **Divide**: If the list is of length 0 or 1, it is already sorted. Otherwise, divide the list into two halves.
2. **Conquer**: Recursively sort both halves of the list.
3. **Combine**: Merge the two halves together into a single sorted list.

### Complexities
- **Time Complexity**: O(n \log n) for all cases (best, average, worst) because the list is divided into halves and each element is considered at each level of merge operations.
- **Space Complexity**: O(n)\additional space is required for the merging process, not counting the space used for the input array.

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


