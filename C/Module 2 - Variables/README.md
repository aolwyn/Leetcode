# Variables and Data Types

## Topics Covered 

- [ ] Declaring and initializing variables.
- [ ] Fundamental data types in C (e.g., int, float, char).
- [ ] Rules for variable naming and declaration.
- [ ] Basic arithmetic operations.

### Declaring and Initializing variables
- Variables are used to store and manipulate data in a program. They must be declared before they can be used, specifying their data type and optionally their initial value.
- C supports several fundamental data types, each with its own size, range, and usage scenarios.
- Understanding the size and range of data types is crucial for efficient memory usage and ensuring that variables can accommodate the necessary values.
- Constants and literals are fixed values used in expressions or assignments. Constants can be defined using the const keyword, while literals are directly specified in the code.

### Fundamental Data Types in C
- `int`: Typically 4 bytes, range from -2,147,483,648 to 2,147,483,647 (signed int). Unsigned int has a range from 0 to 4,294,967,295.
- `float`: Typically 4 bytes, range from approximately 1.2E-38 to 3.4E+38. Floats are used to represent single-precision floating point numbers.
- `char`: Typically 1 byte, range from -128 to 127 (signed char). Unsigned char has a range from 0 to 255. Used to represent characters or small integers.
- `double`: Typically 8 bytes, range from approximately 2.3E-308 to 1.7E+308. Doubles are used to represent double-precision floating point numbers.
- <strong>NOTE:</strong> try to learnt the sizes of some of these types of variables. Looking at your lecture notes, they do ask questions about these things using `sizeof()`

### Rules for Variable Naming and Declaration
1. Start with a letter or underscore: Variable names must begin with a letter (a-z, A-Z) or an underscore (_).

2. Subsequent characters: After the first character, variable names may consist of letters, digits (0-9), or underscores.

3. Case sensitivity: C is case-sensitive, so uppercase and lowercase letters are considered distinct. For example, num and Num are treated as different variables.

4. Reserved keywords: Avoid using C keywords (such as int, float, if, for, etc.) as variable names, as they have predefined meanings in the language.

### Examples
```C
    // Variable declaration and initialization
    int age = 25;
    float pi = 3.14159;
    char grade = 'A';
    double salary = 50000.75;

    // Displaying size and range of data types
    printf("Size of int: %lu bytes\n", sizeof(int));
    printf("Size of float: %lu bytes\n", sizeof(float));
    printf("Size of char: %lu byte\n", sizeof(char));
    printf("Size of double: %lu bytes\n", sizeof(double));

    // Constants and literals
    const int MONTHS_IN_YEAR = 12;
    printf("Number of months in a year: %d\n", MONTHS_IN_YEAR);

```