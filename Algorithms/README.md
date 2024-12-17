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

<h1>Analysis and Design of Algorithms</h1>

<h2>Loop Invariants</h2>
<p>A statement that remains true across loop iterations. 3 properties:
    <ol>
        <li>Initialization: True before loop starts.</li>
        <li>Maintenance: Remains true after each iteration.</li>
        <li>Termination: Ensures correctness when loop ends.</li>
    </ol>
For example. Let's say we were looking to sum the values of an array, $ \sum_{k=1}^{i-1}k $

```python
sum = 0
for i in range(1, n+1): 
    sum = sum + i
```
The invariant here would be a summation: 
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