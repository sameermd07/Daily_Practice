class Solution {
  public int houseRobber(int[] money) {
    if(money.length==1){
        return money[0];
    }
    int arr1[]=new int[money.length-1];
    int arr2[]=new int[money.length-1];
    for(int i=0;i<money.length-1;i++){
        arr1[i]=money[i];
    }
    for(int i=1;i<money.length;i++){
        arr2[i-1]=money[i];
    }
    return Math.max(nonAdjacent(arr1),nonAdjacent(arr2));
  }

  public int nonAdjacent(int[] nums) {
    int dp[] = new int[nums.length];
    Arrays.fill(dp, -1);
    return helper(nums, nums.length - 1, dp);
  }
  public int helper(int nums[], int n, int dp[]) {
    if (n < 0) {
      return 0;
    }
    if (dp[n] != -1) return dp[n];
    int pick = nums[n] + helper(nums, n - 2, dp);
    int nopick = 0 + helper(nums, n - 1, dp);
    dp[n] = Math.max(pick, nopick);
    return dp[n];
  }
}
