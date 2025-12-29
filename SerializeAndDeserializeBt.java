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
    public String serialize(TreeNode root) {
        Queue<TreeNode> pq=new LinkedList<>();
        String str="";
        pq.offer(root);
        str+=root.data+" ";
        while(!pq.isEmpty()){
            int size=pq.size();
            for(int i=0;i<size;i++){
                TreeNode curr=pq.poll();
                if(curr.left!=null){
                    pq.offer(curr.left);
                    str+=curr.left.data+" ";
                }else{
                    str+="null ";
                }
                if(curr.right!=null){
                    pq.offer(curr.right);
                    str+=curr.right.data+" ";
                }else{
                    str+="null ";
                }
            }
        }
        return str.trim();
    }

    public TreeNode deserialize(String data) {
        String str[]=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode>pq=new LinkedList<>();
        pq.offer(root);
        // root.left=new TreeNode(Integer.parseInt(str[1]));
        // root.right=new TreeNode(Integer.parseInt(str[2]));
        for(int i=0;i<str.length/2;i++){
            TreeNode curr=pq.poll();
            if(!str[2*i+1].equals("null")){
                curr.left=new TreeNode(Integer.parseInt(str[2*i+1]));
                pq.offer(curr.left);
            }else{
                curr.left=null;
            }
            if(!str[2*i+2].equals("null")){
                curr.right=new TreeNode(Integer.parseInt(str[2*i+2]));
                pq.offer(curr.right);
            }else{
                curr.right=null;
            }
        }
        return root;
    }
}

/*
 * Your Codec object will be instantiated and called as such:
 * Codec ser = new Codec();
 * Codec deser = new Codec();
 * String tree = ser.serialize(root);
 * TreeNode ans = deser.deserialize(tree);
 * return ans;
 */