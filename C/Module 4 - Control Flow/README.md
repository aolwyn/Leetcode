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
