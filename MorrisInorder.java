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
    public List<Integer> getInorder(TreeNode root) {
        //your code goes here
        ArrayList<Integer> nums=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                nums.add(curr.data);
                curr=curr.right;
            }else{
                // nums.add(curr.data);
                    nums.add(curr.data);
                TreeNode currPos=curr.left;
                while(currPos.right!=null && currPos.right!=curr){
                    currPos=currPos.right;
                }
                if(currPos.right==null){
                    currPos.right=curr;
                    curr=curr.left;
                }else{
                    currPos.right=null;
                    curr=curr.right;
                }
            }
        }
        return nums;
    }
}