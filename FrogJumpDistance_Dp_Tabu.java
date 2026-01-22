class Solution {
  public int frogJump(int[] heights, int k) {
    int n = heights.length;
    if (n <= 1) return 0;
    int dp[] = new int[n];
    dp[0] = 0;
    dp[1] = Math.abs(heights[0] - heights[1]);
    for (int i = 2; i <n; i++) {
      int min = Integer.MAX_VALUE;
      for (int j = 1; j <= k; j++) {
        if (i - j >= 0) {
          min = Integer.min(min, dp[i - j] + Math.abs(heights[i] - heights[i-j]));
        }
      }
      dp[i] = min;
    }
    // System.out.println(Arrays.toString(dp));
    return dp[n-1];
  }

//   public int min(int n, int dp[], int heights[], int k) {
//     if (n == 0) {
//       return 0;
//     }
//     if (n == 1) {
//       return Math.abs(heights[1] - heights[0]);
//     }
//     if (dp[n] != -1) return dp[n];
//     int min = Integer.MAX_VALUE;
//     for (int i = 1; i <= k; i++) {
//       if (n - i >= 0) {
//         min = Integer.min(min, min(n - i, dp, heights, k) + Math.abs(heights[n] - heights[n - i]));
//       } else {
//         break;
//       }
//     }
//     dp[n] = min;
//     return dp[n];
//   }
}
