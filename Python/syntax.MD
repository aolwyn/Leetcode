# Python Data Structures for LeetCode

## 1. Lists (Arrays & Stacks)

Python lists are dynamic arrays. They function as both Arrays and Stacks.

**Initialization**

```python
nums = [] 
nums = [0] * 5          # [0, 0, 0, 0, 0] (Fixed size init)
nums = list(range(5))   # [0, 1, 2, 3, 4]
two_d = [[0] * 3 for _ in range(3)] # 3x3 Matrix (Correct way)

```

**Common Operations**

```python
nums.append(1)        # O(1) - Add to end
x = nums.pop()        # O(1) - Remove from end (Stack LIFO)
x = nums[0]           # O(1) - Access
nums[0] = 5           # O(1) - Update
length = len(nums)    # O(1)

```

**Sorting**

```python
nums.sort()           # O(N log N) - In-place
new_list = sorted(nums) # O(N log N) - Returns new list
nums.sort(reverse=True) # Descending
nums.sort(key=lambda x: x[1]) # Sort 2D array by 2nd element

```

**Pro Tips**

* **Slicing:** `nums[::-1]` reverses the list. `nums[1:4]` gets sub-array.
* **Don't use:** `nums.insert(0, val)` or `nums.pop(0)`. These are **O(N)**. Use a `deque` instead.

---

## 2. Hash Map (Dictionary)

The bread and butter of LeetCode. Key-value storage with  access.

**Initialization**

```python
d = {} 
d = dict()

```

**Common Operations**

```python
d['key'] = 100        # O(1) - Insert/Update
val = d['key']        # O(1) - Access (Crash if missing)
val = d.get('key', 0) # O(1) - Safe access (returns 0 if missing)
exists = 'key' in d   # O(1) - Check existence
del d['key']          # O(1) - Delete

```

**Looping**

```python
for key in d: ...               # Keys only
for val in d.values(): ...      # Values only
for k, v in d.items(): ...      # Keys and Values

```

**The "Cheat" Codes**

```python
from collections import defaultdict, Counter

# 1. defaultdict: Never raises KeyError. Sets default value automatically.
d = defaultdict(int)   # Default value is 0
d = defaultdict(list)  # Default value is []

# 2. Counter: Counts frequency of elements in a list automatically.
counts = Counter("banana") # {'a': 3, 'n': 2, 'b': 1}
# Get the 2 most common elements
print(counts.most_common(2)) 

```

---

## 3. Hash Set

Unordered collection of **unique** elements. Great for  lookups to check "Have I seen this before?"

**Initialization**

```python
s = set() 
s = set([1, 2, 2, 3]) # {1, 2, 3} (Duplicates removed)

```

**Common Operations**

```python
s.add(1)              # O(1)
s.remove(1)           # O(1) (Crash if missing)
s.discard(1)          # O(1) (No crash if missing)
exists = 1 in s       # O(1)

```

**Math Operations**

```python
union = s1 | s2
intersection = s1 & s2
diff = s1 - s2

```

---

## 4. String

Immutable sequences of characters.

**Common Operations**

```python
s = "Hello"
char = s[1]           # 'e'
# s[1] = 'a'          # ERROR! Strings are immutable.
s = s + " World"      # O(N) - Creates new string
s = s.strip()         # Removes leading/trailing whitespace

```

**Tricks**

```python
# Convert List -> String
arr = ["H", "i"]
s = "".join(arr)      # "Hi" (Very fast)

# Convert String -> List
arr = list("Hi")      # ['H', 'i']

# Check Type
digit = "123".isdigit() # True
alpha = "abc".isalpha() # True
alnum = "a1".isalnum()  # True (Letters + Numbers)

```

---

## 5. Queue & Deque (Double-Ended Queue)

Use `collections.deque` for Queues. **Never** use a List for a Queue.

**Why?** `pop(0)` on a list is  (shifts everything). `popleft()` on a deque is .

```python
from collections import deque

q = deque()
q.append(1)           # Add to right
q.appendleft(2)       # Add to left
val = q.pop()         # Remove from right
val = q.popleft()     # Remove from left (Standard Queue Dequeue)

```

---

## 6. Heap (Priority Queue)

Python uses `heapq` module. By default, it is a **Min-Heap** (smallest element at root).

```python
import heapq

min_heap = [] # Just a normal list

# Add element - O(log N)
heapq.heappush(min_heap, 5)
heapq.heappush(min_heap, 1)

# Pop smallest element - O(log N)
smallest = heapq.heappop(min_heap) # Returns 1

# Peek smallest - O(1)
peek = min_heap[0]

# Convert list to heap in-place - O(N)
nums = [5, 1, 3]
heapq.heapify(nums)

```

**Max-Heap Trick**
Since Python only has Min-Heap, multiply numbers by `-1` to simulate a Max-Heap.

* To store `10`, push `-10`.
* When you pop `-10`, multiply by `-1` to get `10` back.

---

## 7. Classes for Trees & Linked Lists

These are not built-in, but this is exactly how they appear in LeetCode problems.

**Linked List Node**

```python
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# Traversal
curr = head
while curr:
    print(curr.val)
    curr = curr.next

```

**Binary Tree Node**

```python
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

```

---

## 8. Graphs

Usually represented as an **Adjacency List** (a Dictionary of Lists).

```python
from collections import defaultdict

# Graph: Node -> [Neighbors]
graph = defaultdict(list)

edges = [[0, 1], [0, 2], [1, 2]]

# Build Graph
for u, v in edges:
    graph[u].append(v)
    graph[v].append(u) # If undirected
    
# Iterating neighbors
for neighbor in graph[0]:
    print(neighbor)

```

---

## Summary of Big-O Complexities

| Data Structure | Access | Search | Insertion | Deletion |
| --- | --- | --- | --- | --- |
| **List (Array)** |  |  |  |  |
| **Stack** |  |  |  |  |
| **Queue (Deque)** |  |  |  |  |
| **HashMap / Set** | N/A |  |  |  |
| **Heap (Min)** |  (Min) |  |  |  |

**Insertion/Deletion for List is  only at the END (`append`/`pop`).*
