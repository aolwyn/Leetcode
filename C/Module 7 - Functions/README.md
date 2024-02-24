# Functions

- [Functions](#functions)
  - [What is a function](#what-is-a-function)
  - [Scope](#scope)
    - [Types of Scope](#types-of-scope)
    - [Scope Rules](#scope-rules)
    - [Scope Resolution](#scope-resolution)

## What is a function




## Scope

- Scope refers to the region of a program where a variable is accessible or visible.
- It determines where in the program a variable can be used and accessed.

### Types of Scope
1. Global Scope
   - Variables declared outside of any function have global scope.
   - Global variables are accessible from any part of the program.
   - They retain their value throughout the program's execution.
2. Local Scope
   - Variables declared within a function have local scope.
   - Local variables are accessible only within the function in which they are declared.
   - They are created when the function is called and destroyed when the function exits.

### Scope Rules

1. Block Scope
- Variables declared within a block of code (within curly braces {}) have block scope.
- They are accessible only within that block and its nested blocks.
- Block scope applies to variables declared within loops, if statements, and other compound statements.
2. Function Scope
- Parameters and variables declared within a function have function scope.
- They are accessible only within that function.
- Function scope variables are destroyed when the function exits.


### Scope Resolution
- When a variable is referenced, the compiler searches for its declaration starting from the innermost scope and moving outward.
- If a variable with the same name exists in both local and global scopes, the local variable takes precedence within its scope.
- Shadowing occurs when a local variable hides a global variable with the same name within the same scope.
<br>

Example:

```C
#include <stdio.h>

// Global variable with global scope
int globalVar = 10;

void function1() {
    // Local variable with function scope
    int localVar1 = 20;
    
    // Accessing global and local variables within function1
    printf("Inside function1:\n");
    printf("Global variable: %d\n", globalVar); // Output: 10
    printf("Local variable 1: %d\n", localVar1); // Output: 20
    
    // Attempting to access local variable from function2 (error)
    // printf("Local variable 2 from function1: %d\n", localVar2);
}

void function2() {
    // Local variable with function scope
    int localVar2 = 30;
    
    // Accessing global and local variables within function2
    printf("Inside function2:\n");
    printf("Global variable: %d\n", globalVar); // Output: 10
    printf("Local variable 2: %d\n", localVar2); // Output: 30
    
    // Attempting to access local variable from function1 (error)
    // printf("Local variable 1 from function2: %d\n", localVar1);
}

int main() {
    // Local variable with function scope
    int localVarMain = 40;
    
    // Accessing global and local variables within main
    printf("Inside main:\n");
    printf("Global variable: %d\n", globalVar); // Output: 10
    printf("Local variable in main: %d\n", localVarMain); // Output: 40
    
    // Attempting to access local variables from functions (error)
    // printf("Local variable 1 in main: %d\n", localVar1);
    // printf("Local variable 2 in main: %d\n", localVar2);
    
    // Function calls
    function1();
    function2();
    
    return 0;
}


```