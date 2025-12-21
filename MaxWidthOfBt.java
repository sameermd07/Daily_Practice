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
    public int widthOfBinaryTree(TreeNode root) {
        //your code goes here
        return levelOrder(root);
    }
     public int levelOrder(TreeNode root) {
        Queue<pair> x=new LinkedList<>();
        int max=Integer.MIN_VALUE;
        if(root==null){
            return 0;
        }
        x.offer(new pair(root,0));
        while(!x.isEmpty()){
            int len=x.size();
            List<Integer> small=new ArrayList<>();
            for(int i=0;i<len;i++){
                pair curr=x.poll();
                if(curr.node.left!=null){
                    x.offer(new pair(curr.node.left,2*curr.value+1));
                }
                if(curr.node.right!=null){
                    x.offer(new pair(curr.node.right,2*curr.value+2));
                }
               small.add(curr.value);
            }
            max=Math.max(max,small.get(small.size()-1)-small.get(0)+1);
        }
        return max;
    }
    class pair{
        TreeNode node;
        int value;
        pair(TreeNode node,int value){
            this.node=node;
            this.value=value;
        }
    }
} 
