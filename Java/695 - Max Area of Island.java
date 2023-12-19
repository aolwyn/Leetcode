class Solution {
    private int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        /*Algorithm:
        - we have a graph traversal 2D array Q that asks for the max area of an island.
        - max area is considered the number of ones connected to it 4-directionally.
        - to solve this, we can use a DFS with a count, return said count and take the max.
        - we visit 4 directional elements, if out of bounds or 0, return 0. otherwise set current eleemnt to 0 (to mark as visited) and then return 1 + dfs directionally.
        */
        if(grid == null || grid[0].length == 0 || grid.length == 0)
            return 0;
        this.grid = grid;
        int max = 0;

        for(int i =0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max, DFS(i,j));
                }
            }
        }
        return max;
    }
    private int DFS(int i, int j){
        if(i >= grid.length || j >= grid[0].length || i <0 || j < 0 || grid[i][j] == 0)
            return 0;
        
        grid[i][j] = 0;
        return 1 + DFS(i+1,j) + DFS(i-1,j) + DFS(i,j+1) + DFS(i,j-1);    
    }
}