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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //your code goes here
        return isSame(p,q);
    }

    public boolean isSame(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if((p!=null&&q==null)|| (p==null&&q!=null)||p.data!=q.data){
            return false;
        }
        boolean left=isSame(p.left,q.left);
        boolean right=isSame(p.right,q.right);

        return left && right;

    }
}