# Arrays

## Topics Covered
- [ ] What is an array
- [ ] Declaration and Initialization of Arrays
- [ ] Accessing Array Elements
- [ ] Arrays and Memory Allocation
- [ ] Multidimensional Arrays

## What is an Array?
- Arrays are a fundamental data structure in C that allow storing multiple elements of the same data type under a single name.
- They provide a convenient way to organize and manipulate data in programs.
- Each element in an array is accessed using an index, starting from 0 for the first element.
- Arrays are contiguous, meaning, in memory, the elements are stored one after another.

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
// Declares an array named "numbers" capable of holding 5 integers. All values default initialize to 0 in an integer array.
int numbers[5]; 
```
If you want to initialize an array that has some values,
```C
//this is how you declare an array with some values.
int arr[5] = {0,234,1058,3945,145}; 
```
Note, you can also do what's called partial initialization; this is where you initialize an array but only populate some indexes; any indexes you didn't give a value to get defaulted to 0.
```C
int partial[4] = {1,2,3}; //element 4 would be initialized to 0.
```
There is another way you can initialize arrays. This method doesn't explicitly state the size of the array, but the computer will know based on the amount of numbers you initialize the array with:
```C
int implicit[] = {2,134,514,6252}; 
//so here you can see on the left hand side, we didn't explicitly state 
//the size of the array - but its of size 4 as you can see on the right.
```

## Accessing Elements
- to access an element, we can use its index. <strong> REMEMBER!</strong> you can go up to size-1 indexes. so for a size of 5, you can access indexes 0,1,2,3,4.
- the easiest way to remember indexing is to just start counting from 0, rather than 1.

For example:
```C
int demo[5] = {1,2,3,4,5};
printf("%d ",demo[0]); //prints 1
printf("%d ",demo[1]); //prints 2
printf("%d ",demo[2]); //prints 3
printf("%d ",demo[3]); //prints 4
printf("%d ",demo[4]); //prints 5
```

