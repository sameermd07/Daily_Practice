class Solution {
    public int minTriangleSum(int[][] triangle) {
        int dp[][]=new int[triangle.length][triangle.length];
        for(int i=0;i<triangle.length;i++){
            Arrays.fill(dp[i],(int)1e9);
        }
        return helper(triangle,0,0,dp);
    }
    public int helper(int triangle[][],int i,int j,int dp[][]){
        if(i==triangle.length){
            return 0;
        }
        if(dp[i][j]!=(int)1e9) return dp[i][j];
        int x=triangle[i][j]+helper(triangle,i+1,j,dp);
        int y=triangle[i][j]+helper(triangle,i+1,j+1,dp);
        dp[i][j]=Math.min(x,y);
        return dp[i][j];
    }
}