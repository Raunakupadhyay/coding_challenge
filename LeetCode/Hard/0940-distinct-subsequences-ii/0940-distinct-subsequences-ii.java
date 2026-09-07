class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1000000007;
        int[] dp = new int[s.length() + 1];
        int[] last = new int[26];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            int ch = s.charAt(i - 1) - 'a';

            dp[i] = (2 * dp[i - 1]) % MOD;

            dp[i] = (dp[i] - last[ch] + MOD) % MOD;

            last[ch] = dp[i - 1];
        }

        return (dp[s.length()] - 1 + MOD) % MOD;
    }
}