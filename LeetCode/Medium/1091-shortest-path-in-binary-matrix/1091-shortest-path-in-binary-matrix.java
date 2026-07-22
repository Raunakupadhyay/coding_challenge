class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};
        q.offer(new int[]{0, 0, 1});
        vis[0][0] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];
            if(r == n - 1 && c == n - 1)
                return dist;
            for(int i = 0; i < 8; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < n &&
                   nc >= 0 && nc < n &&
                   grid[nr][nc] == 0 &&
                   !vis[nr][nc]){
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return -1;
    }
}