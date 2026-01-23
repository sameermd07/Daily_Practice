class Solution {
    public int nonAdjacent(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,nums.length-1,dp);
    }
    public int helper(int nums[],int n,int dp[]){
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1) return dp[n];
        int pick=nums[n]+helper(nums,n-2,dp);
        int nopick=0+helper(nums,n-1,dp);
        dp[n]= Math.max(pick,nopick);
        return dp[n];
    }
}