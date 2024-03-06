class Solution {
    public int heightChecker(int[] heights) {
        /*Algorithm:
        - we are given a list of heights representative of the expected height of the ith student in the line.
        - we want to check if they are actually in the right position when sorted against the original array.
        - first, make a copy of the original
        - sort the original
        - compare against the copy
        - return index differences
        */
        if(heights.length == 0 || heights == null)
            return 0;
        
        int[] copy = Arrays.copyOf(heights, heights.length);

        Arrays.sort(heights);
        int diff = 0;

        for(int i = 0; i < copy.length; i++){
            if(heights[i] != copy[i])
                diff++;
        }
        return diff;
    }
}