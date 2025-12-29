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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //your code goes here
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        TreeNode root=null;
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1,root,mp);
    }
    public TreeNode helper(int inorder[],int inS,int inE,int postorder[],int poS,int poE,TreeNode root,HashMap<Integer,Integer>mp){
        if(inS>inE || poS>poE){
            return null;
        }

        int rootidx=mp.get(postorder[poE]);
        root=new TreeNode(inorder[rootidx]);
        int len=rootidx-inS;
        root.left=helper(inorder,inS,rootidx-1,postorder,poS,poS+len-1,root.left,mp);
        root.right=helper(inorder,rootidx+1,inE,postorder,poS+len,poE-1,root.right,mp);
        return root;
    } 
}