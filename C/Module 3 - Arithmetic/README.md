# Arithmetic

## Intro
- C provides a variety of arithmetic operators for performing basic mathematical operations on integer and floating-point values.
- The result of an arithmetic operation depends on the data types of the operands involved. Mixing different data types may lead to implicit type conversion and affect the result.
- The increment and decrement operators (++ and --) are unary operators used to increase or decrease the value of a variable by 1, respectively. They can be used in both prefix and postfix forms, with subtle differences in their behavior.
- Modulus operator (%) is particularly useful for tasks such as determining whether a number is even or odd, or for cyclic calculations.

## Types of operations
- `Addition (+)`: Adding two values together.
- `Subtraction (-)`: Subtracting one value from another.
- `Multiplication (*)`: Multiplying two values.
- `Integer Division (/)`: Dividing one integer by another, resulting in an integer quotient.
- `Modulus (%)`: Finding the remainder of an integer division.
- `Floating-point Division (/)`: Dividing one floating-point number by another, resulting in a floating-point quotient.
- `Increment (++)` and `Decrement (--)`: Increasing or decreasing the value of a variable by 1.

### Examples

```C
#include <stdio.h>

int main() {
    // Variable declaration
    int a = 10, b = 3;
    float x = 10.5, y = 2.0;

    // Addition
    int sum = a + b;
    printf("Addition: %d\n", sum); //prints out 13

    // Subtraction
    int difference = a - b;
    printf("Subtraction: %d\n", difference); //prints out 7

    // Multiplication
    int product = a * b;
    printf("Multiplication: %d\n", product); //prints out 30

    // Integer Division
    int quotient = a / b;
    printf("Division (Integer): %d\n", quotient); //prints out 3

    // Modulus
    int remainder = a % b;
    printf("Modulus: %d\n", remainder); //prints out 1

    // Floating-point Division
    float floatQuotient = x / y;
    printf("Division (Float): %.2f\n", floatQuotient); //prints out 5.25

    // Increment and Decrement Operators
    int i = 5;
    printf("Original value: %d\n", i); //prints out 5
    printf("Post-increment: %d\n", i++); //prints out 5, value after the i++ line will be 6.
    printf("After post-increment: %d\n", i); //prints out 6
    printf("Pre-increment: %d\n", ++i); //prints out 7
    printf("After pre-increment: %d\n", i); //prints out 7

    return 0;
}
```

## Printing out Outputs and Special Formatters
- `printf` Function: In C, the printf function is used to print formatted output to the standard output stream (usually the console).

- Format Specifiers: Format specifiers are placeholders used within the format string of printf to indicate the type and format of the data to be printed. For example, `%d` is used to print integers, `%f` for floating-point numbers, `%c` for characters, `%s` for strings, and so on.

- Escape Sequences: Escape sequences are special characters preceded by a backslash  that are used to represent non-printable characters or to perform special actions. For example, `\n` represents a newline character, `\t` represents a tab character, `\"` represents a double quote, and `\\` represents a backslash.

- Variable Substitution: Format specifiers are replaced by the corresponding values of variables in the printf function call. The order of variables in the argument list should match the order of format specifiers in the format string.

- Precision and Width Specifiers: Format specifiers can include precision and width specifiers to control the number of digits displayed and the field width, respectively. For example, `%.2f` specifies that a floating-point number should be displayed with two decimal places.

- <strong>NOTE:</strong>learning the above notation is especially important. Profs are known to fuck with you using it. by default, `%f` prints out 6 decimal places. in the following, `%m.nf`, m represents the max length of what will be printed (left of decimal, decimal, and right of decimal) and the n represents the maximum amount of digits past the decimal.

- Concatenation: Multiple variables and literal strings can be concatenated in a single printf statement to construct complex output messages. This allows for flexible and customizable output formatting.

- Return Value: The printf function returns the number of characters printed, excluding the null terminator ('\0') at the end of the printed string. This return value can be useful for error checking or for tracking the number of characters printed.

- Standard Output: By default, printf sends its output to the standard output stream, which is usually the console. However, the output can be redirected to other destinations, such as files, using file I/O functions.