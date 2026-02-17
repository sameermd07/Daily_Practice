class Solution {
    int dp[][];
    public int minDifference(int[] arr, int n) {
        int totSum=0;
        for(int i=0;i<n;i++){
            totSum+=arr[i];
        }
        dp=new int[n+1][totSum/2+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        int x=helper(n-1,arr,n,totSum/2);
        int y=totSum-x;
        return y-x; 
    }
    int helper(int i,int arr[],int n,int target){
        if(i==0){
            if(arr[0]<=target){
                return arr[0];
            }
            return 0;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int take=0;
        if(arr[i]<=target){
            take=arr[i]+helper(i-1,arr,n,target-arr[i]);
        }
        int notTake=helper(i-1,arr,n,target);
        return dp[i][target]=Math.max(take,notTake);
    }
}
