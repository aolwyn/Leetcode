# Arrays

## Topics Covered
- [ ] What is an array
- [ ] Declaration and Initialization of Arrays
- [ ] Accessing Array Elements
- [ ] Arrays and Memory Allocation
- [ ] Multidimensional Arrays

## What is an Array?
- An array in C is a data structure that allows you to store a collection of elements of the same data type in contiguous memory locations. It provides a convenient way to organize and access multiple values of the same type under a single name.

### Key Characteristics:
1. `Homogeneous Elements`: Arrays can only contain elements of the same data type. For example, an array of integers can only store integers, and an array of characters can only store characters.
2. `Fixed Size`: The size of an array, once declared, remains fixed throughout its lifetime. This means you must specify the number of elements the array can hold at the time of declaration, and it cannot be changed dynamically during program execution.
3. `Indexed Access`: Each element in the array is identified by its position, called an index. The index starts from 0 for the first element and increases sequentially. You can access individual elements of the array using their respective indices.
4. `Contiguous Memory Allocation`: The elements of an array are stored in adjacent memory locations. This allows for efficient memory access and traversal of array elements.

## Declaration and Initialization
The general initialization is as follows:
```C
datatype arrayName[arraySize];

```
for example,
```C
int numbers[5]; // Declares an array named "numbers" capable of holding 5 integers.
```

TODO: finish section