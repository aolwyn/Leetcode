# Functions

- [Functions](#functions)
  - [What is a function](#what-is-a-function)
  - [Function Declaration](#function-declaration)
    - [Function Prototype](#function-prototype)
    - [Function Definition](#function-definition)
    - [Calling Functions](#calling-functions)
  - [Scope](#scope)
    - [Types of Scope](#types-of-scope)
    - [Scope Rules](#scope-rules)
    - [Scope Resolution](#scope-resolution)
  - [Function Parameters](#function-parameters)

## What is a function
- Functions are blocks of code that perform specific tasks and can be re-used.
- They are good for tasks that run more than once.
- functions are generally of the form `returnType functionName(Parameters)`

## Function Declaration 

The general use of a function has 3 parts:
1. The prototype (declaration)
2. What it does (definition)
3. Actual call

### Function Prototype
- fancy way of saying, "tell the program that I have a function. I haven't defined it yet, but it exists."
- Put these before any function calls - normally above main, below any global #define statements.
- The prototype just states the return type, name of the function, and then the parameters.
<br>
example:

```C
int add(int num1, int num2); // <-- prototype
main{
    printf("%d", add(1,2)); //would return 3; this is the actual call.
    ...
}

int add(int num1, int num2){ // <-- define the function
    return num1+num2;
}
```
### Function Definition
- this is where u give the function it's bread and butter - telling the computer what it actually does.
- In the example above, we see that the definition takes in 2 integers and spits out the sum.
- functions must have a return type, unless they are of type `void` - void functions don't return any value.
- An example of a void function might just print something to the console; no value is being returned that will be used elsewhere, like the add function.


### Calling Functions
- To call a function, we simply invoke the name of the function and put in the arguments.
- If arguments are not given correctly, errors can be thrown or things can go... wonky.
- We can see above when we called add in the `printf` statement, we only called its name and gave it 2 integers.

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

## Function Parameters
- You might be wondering why function parameters is down here. Well, that's because they have their own scope as you can see in the example above.
<br>

- Function parameters are declared within the parentheses following the function name in the function declaration and definition.
- Each parameter consists of a data type followed by a parameter name, separated by commas if there are multiple parameters.
- When a function is called, arguments (actual values or expressions) are provided for each parameter in the function call.
- These arguments are passed to the function and assigned to the corresponding parameters, allowing the function to work with the provided data.
- Parameters can have different data types, including primitive types (int, float, char), pointers, arrays, structures, or even other functions.
- The data type of a parameter specifies the type of data that can be passed to the function when it is called.
- <strong>Parameters act as local variables within the function, meaning they are accessible only within the function's scope.</strong>
- They can be used like any other variable within the function's body to perform calculations, comparisons, or other operations.