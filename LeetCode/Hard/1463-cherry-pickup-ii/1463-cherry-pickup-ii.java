class Solution {
    int[][][] dp;
    int rows, cols;
    public int cherryPickup(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        dp = new int[rows][cols][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, 0, cols - 1, grid);
    }
    public int solve(int row, int c1, int c2, int[][] grid) {
        if(c1 < 0 || c1 >= cols || c2 < 0 || c2 >= cols)
            return Integer.MIN_VALUE;
        if(row == rows)
            return 0;
        if(dp[row][c1][c2] != -1)
            return dp[row][c1][c2];
        int cherries;
        if(c1 == c2)
            cherries = grid[row][c1];
        else
            cherries = grid[row][c1] + grid[row][c2];
        int max = 0;
        for(int d1 = -1; d1 <= 1; d1++) {
            for(int d2 = -1; d2 <= 1; d2++) {
                max = Math.max(max,
                        solve(row + 1,
                              c1 + d1,
                              c2 + d2,
                              grid));
            }
        }
        dp[row][c1][c2] = cherries + max;
        return dp[row][c1][c2];
    }
}