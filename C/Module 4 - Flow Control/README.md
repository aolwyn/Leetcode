# Control Flow

## Topics Covered
- [ ] Conditional Statements
- [ ] Logical Operators
- [ ] Switch Statement
- [ ] Loops


## Conditional Statements
- Conditional statements are used to make decisions in a program based on certain conditions. For example, they can be used to check if a number is positive, negative, or zero, and execute different code blocks accordingly. They are also used in implementing various algorithms such as sorting and searching.

- conditional statements use `if`, `else if`, and `else`.
- A program can use `if` and `else`. However, if you decide to add `else if`, then a `else` case <strong>MUST</strong> be put as well.

### Examples
```C
int num = 10;

if (num > 0) {
    printf("Positive number\n");
} else if (num < 0) {
    printf("Negative number\n");
} else {
    printf("Zero\n");
}

//without the else if, you'd just put it as this:
if (num >= 0) {
    printf("Positive number or zero\n");
} else (num < 0) {
    printf("Negative number\n");
}
```

## Logical Operators
- Logical operators allow combining multiple conditions in conditional statements. 
- The primary logical operators in C are logical AND `(&&)`, logical OR `(||)`, and logical NOT `(!)`.

### Example
```C
int age = 25;
int salary = 50000;

// Logical AND (&&) operator 
//--> the age is above 25 AND the salary is above 30k, so therefore it will print you are eligible for a loan.
if (age >= 18 && salary > 30000) { 
    printf("You are eligible for a loan.\n");
} else {
    printf("You are not eligible for a loan.\n");
}


// Logical OR (||) operator
//--> the age is not less than 18 and is not greater than or equal to 65; because neither of the statements in the OR statement are true, it'll print the second thing.
if (age < 18 || age >= 65) {
    printf("You are not eligible for the discount.\n");
} else {
    printf("You are eligible for the discount.\n");
}

// Logical NOT (!) operator
//--> the salary is greater than 50,000 so it originally says true, however, the ! reverses it; think of it like this: !(false) --> (true)
//so it will print out eligible for a bonus.
if (!(salary < 40000)) {
    printf("You are eligible for a bonus.\n");
} else {
    printf("You are not eligible for a bonus.\n");
}

```

## Switch Statements
- The switch statement allows selecting one of several execution paths based on the value of a single expression.
- really good for selecting something based on 1 variable; note: you could accomplish the same task with only `if`, `else if`, and `else` statements.

### Example
```C
char grade = 'B';

switch (grade) {
    case 'A':
        printf("Excellent\n");
        break;
    case 'B':
        printf("Good\n");
        break;
    case 'C':
        printf("Average\n");
        break;
    default:
        printf("Below Average\n");
}

```

## Loops
-  Loops allow executing a block of code repeatedly until a specified condition is met. C supports three types of loops: `for`, `while`, and `do-while`.

### For Loop
- Use when the number of iterations is known in advance.
- Commonly used for iterating over elements in an array or collection.
- Useful when the loop control variable needs to be initialized, conditionally tested, and updated in a single compact statement.
- for loops are built using 3 parts: 
  - a start, a stop condition, and an increment. keep in mind that you could also write for loops in reverse; meaning, a decrement.

```C
// Incrementing For Loop
for (int i = 0; i < 5; i++) {
    printf("%d ", i);
}
// Output: 0 1 2 3 4 

// Decrementing For Loop

for (int i = 10; i >= 1; i--) {
    printf("%d ", i);
}
// Output: 10 9 8 7 6 5 4 3 2 1
```

### While Loop
- Use when the number of iterations is not known in advance and depends on a condition.
- Useful when the loop needs to continue until a certain condition is no longer true.
- Often used for input validation and reading data until a specific sentinel value is encountered.

```C
// While Loop
int j = 0;
while (j < 5) {
    printf("%d ", j);
    j++;
}
// Output: 0 1 2 3 4 
```

### Do-While Loop
- Similar to the while loop but ensures that the loop body is executed at least once before the condition is checked.
- Useful when the loop body must execute at least once, regardless of the condition.
- Often used in menu-driven programs or situations where the loop body contains code that must execute before the condition is evaluated.
```C
// Do-While Loop
int k = 0;
do {
    printf("%d ", k);
    k++;
} while (k < 5);
// Output: 0 1 2 3 4 
```