class Solution {
    public int frogJump(int[] heights) {
        int n=heights.length;
        // int sum=0;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return min(n-1,heights,dp);
    }
    public int min(int n,int heights[],int dp[]){
        if(n==0){
            return 0;
        }
        if(n==1){
            return Math.abs(heights[0]-heights[1]);
        }
        if(dp[n]!=-1) return dp[n];
        dp[n]=Math.min(
            min(n-1,heights,dp)+Math.abs(heights[n]-heights[n-1]),
            min(n-2,heights,dp)+Math.abs(heights[n]-heights[n-2])
        );
        return dp[n];
            }
}