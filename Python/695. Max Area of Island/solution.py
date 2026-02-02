class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        if grid is None or grid is []:
            return 0
        
        def DFS(grid, rows, cols, row, col) -> int:
            if row >= rows or col >= cols or row < 0 or col < 0 or grid[row][col] == 0:
                return 0
        
            grid[row][col] = 0

            return 1 + DFS(grid, rows, cols, row+1, col) + DFS(grid, rows, cols, row-1, col) + DFS(grid, rows, cols, row, col+1) + DFS(grid, rows, cols, row, col-1)


        max_area = 0

        rows = len(grid)
        cols = len(grid[0])

        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 1:
                    temp = DFS(grid, rows, cols, i, j)
                    max_area = max(temp, max_area)

        return max_area