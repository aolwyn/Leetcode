class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        /*Algorithm:
        - we need to make two arrays equal by reversing subarrays.
        - we can reverse any number of times; so really, we are just seeing if all elements are present in both.
        - or take easy way out and sort both arrays, if the arrays' elements are equal, we fine
        */
        if(target.length != arr.length)
            return false;

        Arrays.sort(target);
        Arrays.sort(arr);

        for(int i =0; i < target.length; i++){
            if(target[i] != arr[i])
                return false;
        }
        return true;
    }
}