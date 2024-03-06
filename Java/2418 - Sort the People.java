class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        /*Algorithm:
        - we are given 2 arrays, heights and names.
        - these heights map to the names by index.
        - we want to sort in descending order based on the heights.
        - keep original mapping from height --> name using a hash map.
        - they wants DESC ORDER, so when iterating through loop, get value at end of sorted array.
        - O(2n) time complexity
        */

        if(names.length ==0 || names == null || heights.length == 0 || heights == null)
            return new String[]{};
        
        HashMap<Integer, String> heightMap = new HashMap<>();

        for(int i = 0 ; i < heights.length; i++){
            heightMap.put(heights[i],names[i]);
        }

        Arrays.sort(heights);

        for(int i= 0; i < names.length; i++){
            names[i] = heightMap.get(heights[names.length-1-i]);
        }
        return names;
    }
}