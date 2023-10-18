class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        /*Algorithm:
        - we have an M x N grid. 
        - we have a search requirement to check nearby colors.
        - 1 base case, color to swap is same. update based on old and new colors accordingly.
        */
        if(image[sr][sc] != color)
            fill(image,sr,sc,image[sr][sc], color);
        return image;
    }   

    public void fill(int[][] image, int sr, int sc, int color, int newColor){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] == newColor || image[sr][sc] != color )
        return;
        image[sr][sc] = newColor;
        fill(image, sr+1, sc, color, newColor);
        fill(image, sr-1, sc, color, newColor);
        fill(image, sr, sc+1, color, newColor);
        fill(image, sr, sc-1, color, newColor);
    }
}