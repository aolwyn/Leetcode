class Solution {
    public int numSpecial(int[][] mat) {
        /*Algorithm:
        - we are dealing with a 2D matrix.
        - we want to identify positions i,j where mat[i][j] == 1 and no other elements in row col are 0.
        - we can keep track of where ones occur using 1D arrays. one will keep track of the 1s in each row, the other for cols.
        - we sum the # of 1s in each row/col respectively. in a separate loop, we check if curr value is 1 and if row col sums are also 1. (we dont check if 0 because curr element wouldve been counted in row col sums)
        */

        int m = mat.length;
        int n = mat[0].length;

        //new arrays for rows and cols
        int[] r = new int[m];
        int[] c = new int[n];

        //populate counts
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                r[i] += mat[i][j];
                c[j] += mat[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 1 && r[i] == 1 && c[j] == 1) { //check if sum of row cols is correct + if curr value is 1
                    ++ans;
                }
            }
        }
        return ans;
    }
}