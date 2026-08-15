class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][]=new int[m+1][n+1];
        for(String s:strs){
            int zero=0;
            int one=0;
            for(char ch:s.toCharArray()){
                if(ch=='0'){
                    zero++;
                }else{
                    one++;
                }
            }
            for(int i=m;i>=zero;i--){
                for(int j=n;j>=one;j--){
                    dp[i][j]=Math.max(dp[i][j],1+dp[i-zero][j-one]);
                }
            }
        }
        return dp[m][n];
        
    }
}