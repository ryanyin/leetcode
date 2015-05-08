package BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

/*Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?*/

 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }

public class Solution {
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		System.out.println(preorderTraversal(root));
	}
 public static List<Integer> preorderTraversal(TreeNode root) {
	 List<Integer> result=new ArrayList<Integer>();
	 List<TreeNode> temp=new ArrayList<TreeNode>();
	 if(root==null) return result;
	 Stack<TreeNode> stc=new Stack<>();
	 stc.push(root);
	 while(!stc.isEmpty()){
		 TreeNode cur=stc.peek();
		 if(!temp.contains(cur)) result.add(cur.val);
		 if(!temp.contains(cur)) temp.add(cur);
		 if(cur.left!=null&&!temp.contains(cur.left)) {
			 stc.push(cur.left);
			 continue;
		 }else if(cur.right!=null&&!temp.contains(cur.right)){
			 stc.push(cur.right);
			 continue;
		 }else{
			 stc.pop();
		 }
	 }
	 return result;    
    }
 
 
 //改进不用判断是否已遍历，先将右节点进栈，再左节点
 public static List<Integer> preorderTraversal2(TreeNode root) {
	 List<Integer> result=new ArrayList<Integer>();
	 if(root==null) return result;
	 Stack<TreeNode> stc=new Stack<>();
	 stc.push(root);
	 while(!stc.isEmpty()){
		 TreeNode node=stc.pop();
		 result.add(node.val);
		 if(node.right!=null) stc.push(node.right);
		 if(node.left!=null) stc.push(node.left);
	 }
	return result;

}
 
 //改进：只用栈保存右节点
 public static List<Integer> preorderTraversal3(TreeNode root) {
	 List<Integer> result=new ArrayList<Integer>();
	 if(root==null) return result;
	 Stack<TreeNode> stc=new Stack<>();
	 TreeNode node=root;
	 while(node!=null){
		 result.add(node.val);
		 if(node.right!=null) stc.push(node.right);
		 node=node.left;
		 if(node==null&&!stc.isEmpty())
			 node=stc.pop();
	 }
	return result;

}
}
