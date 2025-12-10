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
    public boolean isBalanced(TreeNode root) {
        //your code goes here
        return balance(root)!=-1;
	}
    public int balance(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=balance(root.left);
        if(left==-1){
            return -1;
        }
        int right=balance(root.right);

        if(right==-1){
            return -1;
        }

        if(Math.abs(left-right)>1){
            return -1;
        }
        return 1+Math.max(left,right);
    }
}