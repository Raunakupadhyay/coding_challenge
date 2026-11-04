class Solution {

    public boolean sol(char[][] grid, int i, int j, int c, Boolean arr[][][]) {

        if (i >= grid.length || j >= grid[0].length)
            return false;

        if (c < 0)
            return false;

        if (grid[i][j] == ')')
            c--;
        else
            c++;

        if (c < 0)
            return false;

        if (i == grid.length - 1 && j == grid[0].length - 1)
            return c == 0;

        if (arr[i][j][c] != null)
            return arr[i][j][c];

        return arr[i][j][c] =
                sol(grid, i + 1, j, c, arr)
                || sol(grid, i, j + 1, c, arr);
    }

    public boolean hasValidPath(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Boolean arr[][][] = new Boolean[n + 1][m][205];

        return sol(grid, 0, 0, 0, arr);
    }
}