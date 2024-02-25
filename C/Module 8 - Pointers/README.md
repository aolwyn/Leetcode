# Pointers

- [Pointers](#pointers)
  - [What is a Pointer](#what-is-a-pointer)
  - [Declaring and Initializing a Pointer](#declaring-and-initializing-a-pointer)
  - [Using a Pointer](#using-a-pointer)
  - [Static and Dynamic Memory](#static-and-dynamic-memory)

## What is a Pointer
- Pointers are variables that store memory addresses and their values.
- It essentially "points" to the location in memory where a value is stored rather than containing the value itself. 
- They are typically used to access memory directly and for managing memory, specifically passing data by reference, and accessing elements of arrays and complex data structures.
- Generic template: `dataType *pointerName;`

## Declaring and Initializing a Pointer
- Declared using the asterisk `*` symbol.
- Initialized with the address of operator `&` or by assigning the address of another variable.
- Few ways to initialize:
  - Initialize with the address of an existing variable
  - Empty pointer
  - Using `malloc()` or `calloc()` for Dynamic Memory Allocation
  - Array Initialization 
  - Array of Pointers
  - String Literal Initialization
  - Function Return Values
  - Using `&` Operator with the Address of Operator
<br>

Example:
```C
//Initialize with the address of an existing variable
int num = 10;
int *ptr = &num; // Initializing pointer 'ptr' with the address of 'num'

//Assigning NULL to Indicate an Empty Pointer
int *ptr2 = NULL; // Initializing pointer 'ptr' with NULL

//Using malloc() or calloc() for Dynamic Memory Allocation
int *ptr3 = (int *)malloc(sizeof(int)); // Allocating memory for an integer

//Array Initialization
int arr[] = {1, 2, 3};
int *ptr4 = arr; // 'arr' decays into a pointer to its first elem

//Array of Pointers
int *arrayOfPointers[5]; // Defines an array of 5 pointers to int values

//String Literal Initialization <-- covered in string section as well
char *str5 = "Hello"; // Initializing pointer 'str' with a string literal

//Function Return Values
int *ptr6 = someFunction(); // Initializing pointer 'ptr' with the return value of 'someFunction()'

//Using & Operator with the Address of Operator
int *ptr7;
int num = 10;
ptr7 = &num; // Assigning the address of 'num' to 'ptr'
```

## Using a Pointer
- Using a pointers name alone gives you access to the value stored at the memory address of the pointer which is the memory address of another variable
- To use the value at the address stored within a pointer, the indirection operator, `*`, must be used

## Static and Dynamic Memory
- `Static Memory`: Static memory is allocated when your program compiles
  - Think declaring size of an array
  - Memory allocation does not change
- `Dynamic Memory`: is allocated when your program runs
  - Size expands and shrinks as the program runs
  - Memory stays available until it is released using `free()`

