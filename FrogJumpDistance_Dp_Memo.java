class Solution {
    public int frogJump(int[] heights, int k) {
        int dp[]=new int[heights.length];
        Arrays.fill(dp,-1);
        return min(heights.length-1,dp,heights,k);
    }
    public int min(int n,int dp[],int heights[],int k){
        if(n==0){
            return 0;
        }
        if(n==1){
            return Math.abs(heights[1]-heights[0]);
        }
        if(dp[n]!=-1) return dp[n];
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(n-i>=0){
                min=Integer.min(min,min(n-i,dp,heights,k)+Math.abs(heights[n]-heights[n-i]));
            }else{
                break;
            }
        }
        dp[n]=min;
        return dp[n];
    }
}