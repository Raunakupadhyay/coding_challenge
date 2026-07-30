class Solution {
    public int uniquePaths(int m, int n) { 
        int dp[][]=new int[m][n]; 
        return countpath(m-1,n-1,dp);    
        
    }
    public static int countpath(int m,int n,int dp[][]){
        if(m==0 || n==0) return 1;
        if(dp[m][n]!=0) return dp[m][n];
        dp[m][n]=countpath(m-1,n,dp)+countpath(m,n-1,dp);
        return dp[m][n];
    }

}