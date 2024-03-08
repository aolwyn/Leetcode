class Solution {
    public int[] replaceElements(int[] arr) {
        /*Algorithm:
        - we are asked to replace each element in the array with the greatest element to the right of the index.
        - looking at this, we want to build out new array R --> L.
        - we can keep track of the running 'right max' and set it to the current index accordingly.
        - afterwards, update the right max if needed. 
        - right most element will be -1.
        */
        if(arr.length == 0 || arr == null)
            return arr;
        
        int rightMax = arr[arr.length-1];
        arr[arr.length-1] = -1;

        for(int i = arr.length-2; i >= 0; i--){
            int temp = arr[i]; // hold value before setting curr to rightMax
            arr[i] = rightMax;
            rightMax = Math.max(rightMax, temp);
        }
        return arr;
    }
}