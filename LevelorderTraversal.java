/**
 * Definition for a binary tree node. public class TreeNode { int data; TreeNode left; TreeNode
 * right; TreeNode(int val) { data = val; left = null, right = null } }
 */
class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    // your code goes here
    return levelOrder(root);
  }
  public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> x = new LinkedList<>();
    List<List<Integer>> big = new ArrayList<>();
    if (root == null) {
      return big;
    }
    x.offer(root);
    boolean reverse=false;
    while (!x.isEmpty()) {
      int len = x.size();
      LinkedList<Integer> small = new LinkedList<>();
      for (int i = 0; i < len; i++) {
        TreeNode curr = x.poll();

        if(reverse){
            small.addFirst(curr.data);
        }else{
            small.add(curr.data);
        }
        if (curr.left != null) {
          x.offer(curr.left);
        }
        if (curr.right != null) {
          x.offer(curr.right);
        }
        // small.add(curr.data);
      }
    //   if(reverse){
    //     Collections.reverse(small);
    //     big.add(new ArrayList<>(small));
    //     reverse=false;
    //   }else{
    //     big.add(new ArrayList<>(small));
    //     reverse=true;
    //   }
        big.add(new ArrayList<>(small));
        reverse=!reverse;
    }
    return big;
  }
}
