class Solution {
    public int findSpecialInteger(int[] arr) {
        /*Algorithm:
        - 2 approaches, first is to use a hashmap and count to find when above the ceiling of n/4
        - other approach is to understand that the array is sorted, so any arr[i] where arr[i+25% positions] should be same
            --> bit shift to right 2x, looks like: arr[i] == arr[i + n >> 2]
        - if no values follow, then we can just return 0. same if arr length is 0
        */
        if(arr.length == 0)
            return 0;
        int n = arr.length;
        HashMap<Integer,Integer> count = new HashMap<>();

        double floor = Math.ceil(n/4);
        for(int i =0; i < n; i++){
            count.put(arr[i],count.getOrDefault(arr[i],0)+1);
            if(count.get(arr[i]) > floor){
                return arr[i];
            }
        }
        return 0;
    }
}