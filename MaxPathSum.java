/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //your code goes here
        int y=helper(root); 
        return max;
    }
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }

        int left=helper(root.left);
        int right=helper(root.right);

        if(left<0) left=0; 
        if(right<0) right=0;
        int curr_max=Math.max(left,right);
        max=Math.max(left+right+root.data,max); 
        // System.out.println("first check:"+max);
        max=Math.max(curr_max+root.data,max);
        // System.out.println("second check:"+max);

        return curr_max+root.data; 
    }
}