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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //your code goes here
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        // TreeNode base=new TreeNode()
        return buildTree1(preorder,0,preorder.length-1,inorder,0,inorder.length-1,mp);
    }
    public TreeNode buildTree1(int pre[],int pstart,int pend,int in[],int istart,int iend,HashMap<Integer,Integer>mp){
        if(pstart>pend || istart>iend){
            return null;
        }
        TreeNode base=new TreeNode(pre[pstart]);
        int root=mp.get(pre[pstart]);
        int len=root-istart;
        base.left=buildTree1(pre,pstart+1,pstart+len,in,istart,root-1,mp);
        base.right=buildTree1(pre,pstart+len+1,pend,in,root+1,iend,mp);
        return base;
    }
}