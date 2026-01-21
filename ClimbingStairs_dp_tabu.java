class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1); 
        return stairs(n,dp);
    }
    public int stairs(int n,int dp[]){
        if(n<=1){
            return 1;
        }
        if(dp[n]!=-1) return dp[n];
        dp[n]=stairs(n-1,dp)+stairs(n-2,dp);
        return dp[n];
    }
}