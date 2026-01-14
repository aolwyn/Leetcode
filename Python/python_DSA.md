## 1. Lists (Arrays)

Python lists are dynamic arrays. They are the go-to structure for ordered collections.

* **Underlying Structure:** Contiguous memory blocks.
* **Key Feature:** Indexing is `O(1)`, but inserting/deleting from the middle or beginning is `O(n)`.

```python
nums = [1, 2, 3]

# Appending (End) - O(1)
nums.append(4)

# Popping (End) - O(1)
val = nums.pop()

# Popping (Index) - O(n)
val = nums.pop(0) 

# Insert - O(n)
nums.insert(1, 99) # Inserts 99 at index 1

# Slicing - O(k) where k is slice length
copy = nums[:]     # Full copy
sub = nums[1:3]    # Index 1 to 2
reverse = nums[::-1]

```

## 2. Linked Lists

Python does not have a built-in Linked List class. You typically implement a `ListNode` class or are given one in the problem.

```python
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# Traversal
head = ListNode(1)
current = head
while current:
    print(current.val)
    current = current.next

```

## 3. Hash Maps (Dictionaries)

The most important structure for interviews. Used to store Key-Value pairs with `O(1)` average lookup.

```python
# Initialization
d = {} 
# or with default values (VERY USEFUL)
from collections import defaultdict
adj_list = defaultdict(list) # Default value is empty list []
counts = defaultdict(int)    # Default value is 0

# Operations - O(1) average
d['key'] = 'value'
val = d['key']
exists = 'key' in d
del d['key']

# Iteration
for k, v in d.items():
    print(k, v)

```

### The `Counter` Tool

A subclass of `dict` specifically for counting hashable objects.

```python
from collections import Counter
s = "banana"
counts = Counter(s) 
# Result: {'a': 3, 'n': 2, 'b': 1}
# Get top k frequent elements
print(counts.most_common(2)) 

```

## 4. Sets (Hash Sets)

Similar to dictionaries but only store Keys (unique elements). Great for `O(1)` existence checks and deduplication.

```python
seen = set()

# Operations - O(1) average
seen.add(5)
exists = 5 in seen
seen.remove(5) # Raises error if missing
seen.discard(5) # No error if missing

```

## 5. Stacks

Python uses standard Lists `[]` as stacks. Follows **LIFO** (Last In, First Out).

```python
stack = []

# Push - O(1)
stack.append(10)

# Pop - O(1)
if stack:
    val = stack.pop() 

# Peek - O(1)
top = stack[-1]

```

## 6. Queues (Deque)

Do **NOT** use `list` for queues (popping from the front is `O(n)`). Use `collections.deque` (Double-Ended Queue). Follows **FIFO** (First In, First Out).

```python
from collections import deque
q = deque()

# Enqueue - O(1)
q.append(10)

# Dequeue - O(1)
val = q.popleft() 

```

## 7. Heaps (Priority Queues)

Used for finding the Min/Max element in `O(1)` and inserting/deleting in `O(log n)`.
**Important:** Python's `heapq` is a **Min-Heap** by default.

```python
import heapq

min_heap = []

# Push - O(log n)
heapq.heappush(min_heap, 5)
heapq.heappush(min_heap, 1)
heapq.heappush(min_heap, 10)

# Pop Min - O(log n)
smallest = heapq.heappop(min_heap) # Returns 1

# Peek Min - O(1)
print(min_heap[0])

# Max Heap Hack: Store values as negative
max_heap = []
heapq.heappush(max_heap, -5)
heapq.heappush(max_heap, -10)
largest = -heapq.heappop(max_heap) # Returns 10

```

## 8. Trees & Graphs

### Trees

Like Linked Lists, these are usually node-based classes.

```python
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

```

### Graphs

Usually represented using an **Adjacency List** (Dictionary of Lists/Sets) or an **Adjacency Matrix** (2D List).

```python
# Adjacency List using defaultdict
graph = defaultdict(list)
graph[0].append(1)
graph[0].append(2)
graph[1].append(2)
# graph = {0: [1, 2], 1: [2]}

```

## 9. Tries (Prefix Trees)

Used for string search problems (autocomplete, prefix matching).

```python
class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end_of_word = False

```

## Summary of Time Complexities (Python)

| Structure | Access | Search | Insert | Delete | Notes |
| --- | --- | --- | --- | --- | --- |
| **List (Array)** | `O(1)` | `O(n)` | `O(n)` | `O(n)` | Append/Pop(end) is `O(1)` |
| **Stack** | `O(n)` | `O(n)` | `O(1)` | `O(1)` | Using `list` |
| **Queue** | `O(n)` | `O(n)` | `O(1)` | `O(1)` | Using `deque` |
| **Dict (Map)** | `N/A` | `O(1)` | `O(1)` | `O(1)` | Average case |
| **Set** | `N/A` | `O(1)` | `O(1)` | `O(1)` | Average case |
| **Heap** | `O(1)` (min) | `O(n)` | `O(log n)` | `O(log n)` | Search is slow! |
| **BST** | `O(log n)` | `O(log n)` | `O(log n)` | `O(log n)` | If balanced |
