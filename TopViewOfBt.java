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
    public List<Integer> topView(TreeNode root) {
        //your code goes here
        ArrayList<Integer> temp=new ArrayList<>();
        verticalTraversal(root,temp);
        return temp;
    }
    public void verticalTraversal(TreeNode root,ArrayList<Integer> temp) {
        ArrayList<int []> dict=new ArrayList<>();
        helper(root,0,0,dict);
        Collections.sort(dict,(a,b)->{
            if(a[1]!=b[1]) return a[1]-b[1];
            else return a[0]-b[0];
            // else return a[2]-b[2];
        });
        int prev=Integer.MIN_VALUE;
        // List<Integer> temp=new ArrayList<>();
        for(int []arr:dict){
            int row=arr[0];
            int col=arr[1];
            int value=arr[2];
            if(prev!=col){
                temp.add(value);
                prev=col;
            }else{
                continue;
            }
        }
        // big.add(new ArrayList<>(temp));
        // return temp;
    }   

    public void helper(TreeNode root,int row,int col,ArrayList<int []> dict){
        if(root==null){
            return;
        }
        dict.add(new int[]{row,col,root.data});
        helper(root.left,row+1,col-1,dict);
        helper(root.right,row+1,col+1,dict);
    }  
}