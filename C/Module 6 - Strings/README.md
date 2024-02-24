# Strings

- [Strings](#strings)
  - [What is a String](#what-is-a-string)
  - [Declaration and Initialization](#declaration-and-initialization)
  - [String Functions](#string-functions)
  - [Examples](#examples)



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

## String Functions

- C provides various library functions in `<string.h>` for string manipulation.
- `strlen()` calculates the length of a string.
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