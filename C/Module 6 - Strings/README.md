# Strings

- [Strings](#strings)
  - [What is a String](#what-is-a-string)
  - [Declaration and Initialization](#declaration-and-initialization)
  - [Accessing Characters of a String](#accessing-characters-of-a-string)
  - [String Functions](#string-functions)
  - [Examples](#examples)
  - [ASCII and Character Encoding](#ascii-and-character-encoding)
  - [Strings from the user](#strings-from-the-user)

## What is a String
- A string is like a word - a sequence of characters. It is used to represent text data.
- In C, a string is a sequence of characters stored as an array of characters terminated by a null character `'\0'`
- So, no matter what, in any string you create, the last character will always be the null character.
- Example: "Hello" is represented as `{'H', 'e', 'l', 'l', 'o', '\0'}`.

## Declaration and Initialization

- In C, Strings can be declared as character arrays with an explicit size to hold a fixed number of characters, including the null terminator.
- The alternate method is to initialize it with a pointer.
<br>
Examples:

```C
//generic way to initialize of a string:
char str1[20] = "Hello, World!"; //as u can see, there are empty spaces; in strings, they are defaulted to the null character.

//initialize a string with implicit size:
char str[] = "C Programming blows";

//using a pointer:
char *str2 = "Hello Erika!";

```

## Accessing Characters of a String
- 2 methods, using array-like notation or using pointer arithmetic. 
1. Array-Notation
```C
char str[] = "Hello";
char firstChar = str[0]; // Accessing the first character ('H')
char thirdChar = str[2]; // Accessing the third character ('l')
```
2. Pointer Arithmetic
```C
char str[] = "Hello";
char firstChar = *str; // Accessing the first character ('H')
char thirdChar = *(str + 2); // Accessing the third character ('l')
```

## String Functions

- C provides various library functions in `<string.h>` for string manipulation.
- `strlen()` calculates the length of a string. Returns an `int` representing the length of the string.
- `strcpy()` copies one string to another.
- `strcat()` concatenates two strings (puts them together). Result gets put in the first var.
- `strcmp()` compares two strings. returns an integer; if 0, they are equal. if they arent equal and the first string is longer, then it prints out a positive value. otherwise, its smaller, and prints out a negative value. 

## Examples
```C
#include <stdio.h>
#include <string.h>
//you can copy paste to try these out; would reccomend.
int main() {

    //strlen()
    char str[] = "Hello, World!"; 
    int length = strlen(str);
    printf("Length of the string: %d\n", length); //prints out 13

    //strcpy()
    char source[] = "Hello";
    char destination[20];
    strcpy(destination, source);
    printf("Copied string: %s\n", destination);//prints Hello 

    //strcat()
    char str1[20] = "Hello";
    char str2[] = ", World!";
    strcat(str1, str2);
    printf("Concatenated string: %s\n", str1); //prints out Hello, World! 

    //strcmp()
    char str3[] = "Hello";
    char str4[] = "Hello";

    int result = strcmp(str1, str2);
    if (result == 0) {
        printf("The strings are equal.\n");
    } else {
        printf("The strings are not equal.\n");
    }
    return 0;
}
```

## ASCII and Character Encoding
- Character encoding is a system that maps characters to numerical codes for digital representation and transmission.
It defines how computers interpret and display text data by assigning unique numeric codes to each character.
- ASCII is a type of character encoding.
- Some things you might want to know about how to use ASCII:
  - 1. convert between upper and lower case. 
  - 2. Check if the current character is a digit
  - 3. Check if the current character is a number

- ASCII characters A--> Z correspond with values between 65 and 90
- ASCII characters a-->z correspond with 91 and 116
- to go between capital and lowercase, you can add or subtract `A`

```C
char ch = 'A'; // Uppercase letter
    // Check if the character is an uppercase letter
    if (ch >= 'A' && ch <= 'Z') {
        // Convert uppercase to lowercase by adding the ASCII value difference between upper and lowercase.
        ch = ch + ('a' - 'A');
    }
    printf("Lowercase equivalent: %c\n", ch); // Output: 'a'

  ```

  ## Strings from the user


1. ### Buffer Size Consideration:
   - When getting string input from a user, always allocate a sufficiently large buffer to accommodate the expected input size. Think about your assignment, you had a max of 50!
   - Consider the maximum length of input the program can handle and allocate a buffer of appropriate size to prevent buffer overflow vulnerabilities.

2. ### Using `scanf()` for String Input:
   - `scanf()` function can be used to read strings from the user, but it has limitations when dealing with whitespace characters (e.g., space, tab).
   - When using `scanf()` to read strings, ensure that the format specifier `%s` is used along with appropriate field width to limit the input size and prevent buffer overflow.
   - Example:
     ```c
     char str[50];
     printf("Enter a string: ");
     scanf("%49s", str); // Read up to 49 characters to leave room for null terminator
     ```

3. ### Using `fgets()` for String Input:
   - `fgets()` function is preferred for reading strings from the user, especially when dealing with spaces or entire lines of text.
   - It reads characters until a newline character (`'\n'`) is encountered or until the specified limit is reached.
   - Example:
     ```c
     char str[50];
     printf("Enter a string: ");
     fgets(str, sizeof(str), stdin);
     ```

4. ### Handling Newline Characters with `fgets()`:
   - `fgets()` reads and stores newline characters (`'\n'`) in the input buffer, which can affect string processing.
   - To remove the trailing newline character from the input string, you can replace it with a null terminator (`'\0'`) after reading the string.
   - Example:
     ```c
     char str[50];
     printf("Enter a string: ");
     fgets(str, sizeof(str), stdin);
     // Remove trailing newline character, if present
     size_t len = strlen(str);
     if (len > 0 && str[len - 1] == '\n') {
         str[len - 1] = '\0';
     }
     ```

5. ### Input Validation:
   - Validate user input to ensure it meets expected criteria (e.g., length, format, range) before processing.
   - Use functions like `strlen()` to check the length of the input string and handle input errors gracefully.

6. ### Error Handling:
   - Check for errors when getting string input, especially with functions like `fgets()` that may encounter errors or unexpected input conditions.
   - Handle errors by checking return values and providing appropriate feedback to the user.