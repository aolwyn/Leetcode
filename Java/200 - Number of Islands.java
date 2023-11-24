class Solution {
    public int numIslands(char[][] grid) {
        /*Algorithm:
        - we will use a graph traversal, checking and resetting 1's and 0's
        - use a custom function to check each value. this function/method will accept

        */
        int count = 0;
        for(int i =0; i < grid.length;i++){
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j] == '1')

                    count++;
                    Search(grid,i,j);
            }
        }
        return count;
    }

    public void Search(char[][] grid, int i, int j){
        if(i < 0 || j< 0 || i>= grid.length || j>= grid[i].length || grid[i][j] == '0') return;
        
        grid[i][j] = '0'; //set = to 0 before continuing to see connected pieces of land
        Search(grid, i+1, j); //up
        Search(grid, i-1, j);//down
        Search(grid, i, j+1);//left
        Search(grid, i, j-1);//right
    }
}