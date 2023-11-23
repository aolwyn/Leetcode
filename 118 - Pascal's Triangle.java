class Solution {
    public List<List<Integer>> generate(int numRows) {
        /*Algorithm:
         - initialize the first row(just 1) and add it to the triangle.
         - 1 base case check, if numRows is 0 return empty triangle
         - for the major algorithm, we take the previous row and save it.
            - we use 2 for loops, one to keep track of the current row and the other to put in values.
            - we initialize first and last element in the row to be 1 (outside of second for loop)
            - for each element in the current row, the value at the ith position is equivalent to the previous row's value at i-1 position + the ith position's value.
            - after adding, we go to add the end 1 and add to triangle.

        */
        List<List<Integer>> triangle=  new ArrayList<>();
        if(numRows == 0)
            return triangle;

            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            triangle.add(firstRow);

            for(int i =1; i < numRows; i++){
                List<Integer> prevRow = triangle.get(i-1);
                List<Integer> currRow = new ArrayList<>();

                currRow.add(1);
                for(int j = 1; j < i; j++){
                    currRow.add(prevRow.get(j-1)+prevRow.get(j));
                }
                currRow.add(1);
                triangle.add(currRow);
            }
            return triangle;
    }
}