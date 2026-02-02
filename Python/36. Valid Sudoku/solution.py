from collections import defaultdict
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if board is None or board is []:
            return False
        
        # we have a sudoku board, 9x9. 
        # rules are, numbers must be unique in row, col, and square.
        # in this, we are tasked with validating the NUMBERS ONLY INPUTTED
        # so ignore the blanks (denoted by ".") in the array.
        # so we need something to keep track of values seen in row and square
        # can do row col using a dictionary to list for each row and col
        # and then for square we can map based on current position of row and column.
        # with default dict, we need a set structure.

        columns = defaultdict(set)
        rows = defaultdict(set)
        squares = defaultdict(set)

        for r in range(9):
            for  c in range (9):
                if board[r][c] == ".":
                    continue
                if (board[r][c] in columns[c]) or (board[r][c] in rows[r]) or (board[r][c] in squares[(r//3, c//3)]):
                    return False
                
                columns[c].add(board[r][c])
                rows[r].add(board[r][c])
                squares[(r//3, c//3)].add(board[r][c])
                
        return True