class Solution:
    
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or grid is []:
            return 0

        num_island = 0

        rows = len(grid)
        cols = len(grid[0])

        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == "1":
                    num_island +=1
                    self.DFS(grid, rows, cols, row, col)

        return num_island

    def DFS(self, grid, rows, cols, row, col):
        if row >= rows or col >= cols or col < 0 or row < 0 or grid[row][col] == "0":
            return
        
        if grid[row][col] == "1":
            grid[row][col] = "0"
        
        self.DFS(grid, rows, cols, row+1, col)
        self.DFS(grid, rows, cols, row-1, col)
        self.DFS(grid, rows, cols, row, col+1)
        self.DFS(grid, rows, cols, row, col-1)
            