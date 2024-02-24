# Pointers

- [Pointers](#pointers)
  - [What is a Pointer](#what-is-a-pointer)
  - [Declaring and Initializing a Pointer](#declaring-and-initializing-a-pointer)

## What is a Pointer
- Pointers are variables that store memory addresses and their values.
- It essentially "points" to the location in memory where a value is stored rather than containing the value itself. 
- They are typically used to access memory directly and for managing memory, specifically passing data by reference, and accessing elements of arrays and complex data structures.

## Declaring and Initializing a Pointer
- Declared using the asterisk `*` symbol.
- Initialized with the address of operator `&` or by assigning the address of another variable.
<br>

Example:
```C
int *ptr; // Declaration of pointer variable
int num = 10;
ptr = &num; // Initialization with address of 'num'
```