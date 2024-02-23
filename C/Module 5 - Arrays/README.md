# Arrays

## Topics Covered
- [ ] What is an array
- [ ] Declaration and Initialization of Arrays
- [ ] Accessing Array Elements
- [ ] Arrays and Memory Allocation
- [ ] Copying Arrays
- [ ] Multidimensional Arrays

## What is an Array?
- Arrays are a fundamental data structure in C that allow storing multiple elements of the same data type under a single name.
- They provide a convenient way to organize and manipulate data in programs.
- Each element in an array is accessed using an index, starting from 0 for the first element.
- Arrays are contiguous, meaning, in memory, the elements are stored one after another.

### Key Characteristics:
1. `Homogeneous Elements`: Arrays can only contain elements of the same data type. For example, an array of integers can only store integers, and an array of characters can only store characters.
2. `Fixed Size`: The size of an array, once declared, remains fixed throughout its lifetime. This means you must specify the number of elements the array can hold at the time of declaration, and it cannot be changed dynamically during program execution.
3. `Indexed Access`: Each element in the array is identified by its position, called an index. The index starts from 0 for the first element and increases sequentially. You can access individual elements of the array using their respective indices.
4. `Contiguous Memory Allocation`: The elements of an array are stored in adjacent memory locations. This allows for efficient memory access and traversal of array elements.

## Declaration and Initialization
The general initialization is as follows:
```C
datatype arrayName[arraySize];
```
for example,
```C
// Declares an array named "numbers" capable of holding 5 integers. All values default initialize to 0 in an integer array.
int numbers[5]; 
```
If you want to initialize an array that has some values,
```C
//this is how you declare an array with some values.
int arr[5] = {0,234,1058,3945,145}; 
```
Note, you can also do what's called partial initialization; this is where you initialize an array but only populate some indexes; any indexes you didn't give a value to get defaulted to 0.
```C
int partial[4] = {1,2,3}; //element 4 would be initialized to 0.
```
There is another way you can initialize arrays. This method doesn't explicitly state the size of the array, but the computer will know based on the amount of numbers you initialize the array with:
```C
int implicit[] = {2,134,514,6252}; 
//so here you can see on the left hand side, we didn't explicitly state 
//the size of the array - but its of size 4 as you can see on the right.
```

## Accessing Elements
- to access an element, we can use its index. <strong> REMEMBER!</strong> you can go up to size-1 indexes. so for a size of 5, you can access indexes 0,1,2,3,4.
- the easiest way to remember indexing is to just start counting from 0, rather than 1.

For example:
```C
int demo[5] = {1,2,3,4,5};
printf("%d ",demo[0]); //prints 1
printf("%d ",demo[1]); //prints 2
printf("%d ",demo[2]); //prints 3
printf("%d ",demo[3]); //prints 4
printf("%d ",demo[4]); //prints 5
```
in a similar manner, you can use this logic to change the value of an array at a given index.<br>
Using the same array from above, to change the value at the 3rd index to 100,
```C
demo[2] = 100;
```
<br>

So lets entertain a new idea - what if you don't know the size of the array?<br>
Well, if you remember, an array can only hold things of the same datatype. So, if you divide the total size of the array by just 1 element, you'll get the number of elements.<br>
here's it in action:
```C
int unknown[] = {1,2,3,6,7,9,9}; //pretend this isn't initialized here...
int numberOfElements = sizeof(unknown) / sizeof(unknown[0]); 
```
so cool trick - but how do we apply it?<br>
short answer is that it makes it very easy to iterate through each element in a `for` loop <strong>when you DON'T know the number of elements</strong>. 
```C
int unknown[] = {1,2,3,4,5};
int numberOfElements = sizeof(unknown) / sizeof(unknown[0]);

for(int i = 0 ; i < numbberOfElements; i++){
    printf("%d " , unknown[i]); 
}
```

So what happens if you try to access an element larger than the size?<br>
<strong>Accessing elements beyond the array bounds leads to undefined behavior and may result in program crashes or incorrect results.</strong>

## Increasing Size of an Array
- So one of the things we said at the start is that we <strong>cannot</strong> change the size of an array, and, this is true.<br>
- so what happens when we need to increase the size of the array?<br>
There's a few steps we have to do:
1. create a new array that's bigger than the original.
2. use either a built in function or a for loop to transfer the old values over
3. put in whatever new values you want.

Here's how to copy using a for loop:
```C
int original [6] = {100,12,104,104,104,100};
int new[10];
for(int i = 0; i < sizeof(original)/sizeof(original[0]); i++){
    new[i] = original[i]; //manually set each element's value in new array to be same as the one from original
}

```

### Memcpy
- the built in function uses what's called `memcpy`, which , as the name suggests, copies memory. So we copy the memory values of 1 place to a new place.
- `memcpy` does require the `<string.h>` library.
- the syntax is: `memcpy(destination, source, sizeOfSource)`
here's an example of memcpy methods:
```C
//method 1, using the function:
int original[3] = {100,101,123};
int new[4];
memcpy(new,original,sizeof(original)); 
//so elements 0->2 will be the same as the original and the last element (index 3) in the new one will be initialized to 0.
```

## Calculating the physical address in memory
- there's a high chance at one point you've tried to print an array as it is and gotten a wack answer.
- you've likely just printed where the array is located in memory, or rather, the starting point.
- let's use an example. for an integer array of size 4, lets say, in memory, it is located at 100. 
- We know integers take up 4 bytes of memory, and we have the starting point. this means:
  - the first element is located at memory address 100.
  - the second element is located at memory address 104.
  - the third element is at memory address108.
  - the last element is at memory address 112.
so how would we code this --> we can use `%p` in a print statement to print the start address of an array.
```C
int arr[] = {10, 20, 30, 40};
 printf("%p", arr); 
```
and to get the other element locations using code and basic math, the equation in memory for a given index is as follows:
`address[i] = addressOfStart + (i * sizeof(datatype))`
so for the example above where we had an int,
`arr[3] = startAddressOfArr + (3 * sizeof(int))`

TODO:
- define statements
- multi-dimensional arrays