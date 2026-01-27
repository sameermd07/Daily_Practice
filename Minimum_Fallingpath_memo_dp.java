class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min=Integer.MAX_VALUE;
        int dp[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            Arrays.fill(dp[i],(int)1e9);
        }
        for(int i=0;i<matrix[0].length;i++){
            min=Math.min(helper(matrix,0,i,dp),min);
        }
        return min;
    }
    public int helper(int mat[][],int i,int j,int dp[][]){
        if(j<0 || j>=mat[0].length){
            return (int)1e9;
        }
        if(i==mat.length){
            return 0;
        }
        if(dp[i][j]!=(int)1e9) return dp[i][j];
        int x=mat[i][j]+helper(mat,i+1,j,dp);
        int y=mat[i][j]+helper(mat,i+1,j+1,dp);
        int z=mat[i][j]+helper(mat,i+1,j-1,dp);
        dp[i][j]=Math.min(x,Math.min(y,z));
        return dp[i][j];
    }
}