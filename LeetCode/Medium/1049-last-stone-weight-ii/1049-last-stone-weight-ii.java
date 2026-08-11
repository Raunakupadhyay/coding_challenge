class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int total = 0;
        for(int x : stones) {
            total += x;
        }
        int target = total / 2;
        boolean[][] dp = new boolean[n][target + 1];
        for(int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if(stones[0] <= target) {
            dp[0][stones[0]] = true;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= target; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if(stones[i] <= j) {
                    take = dp[i - 1][j - stones[i]];
                }
                dp[i][j] = take || notTake;
            }
        }
        int s1 = 0;
        for(int i = target; i >= 0; i--) {
            if(dp[n - 1][i]) {
                s1 = i;
                break;
            }
        }
        int s2 = total - s1;
        return s2 - s1;
    }
}