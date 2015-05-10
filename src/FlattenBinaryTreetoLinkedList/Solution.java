package FlattenBinaryTreetoLinkedList;

/*Given a binary tree, flatten it to a linked list in-place.

For example,
Given

        1
       / \
      2   5
     / \   \
    3   4   6

The flattened tree should look like:

  1
   \
    2
     \
      3
       \
        4
         \
          5
           \
            6
*/


   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    
    public void flatten(TreeNode root) {
        TreeNode now=root;
        while(now!=null){
            if(now.left!=null){
                TreeNode pre=now.left;
                while(pre.right!=null){
                    
                    pre=pre.right;
                }
                pre.right=now.right;
                now.right=now.left;
                now.left=null;
            }
            now=now.right;
        }
    }
    

}