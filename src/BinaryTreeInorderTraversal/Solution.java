package BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.*/

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
		System.out.println(inorderTraversal2(root));
	}
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> result=new ArrayList<Integer>();
    	List<TreeNode> med=new ArrayList<TreeNode>();
    	Stack<TreeNode> temp=new Stack<TreeNode>();
    	if(root==null) return result;
    	temp.push(root);
    	while(!temp.isEmpty()){
    		TreeNode cur=temp.pop();
    		if(cur.left==null||(cur.left!=null&&med.contains(cur.left))) {
    			result.add(cur.val);
    		}
    		if(cur.right!=null&&!med.contains(cur.right)){
    			temp.push(cur.right);
    			med.add(cur.right);
    		} 
    		if(cur.left!=null&&!med.contains(cur.left)){
    			temp.push(cur);
    			temp.push(cur.left);
    			med.add(cur.left);
    		}
    			
    	}
		return result;      
    }
    
    //不用记录是否访问过
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }
    
    
    //不用栈，但是彻底改变树的结构
    public static List<Integer> inorderTraversal2(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        TreeNode pre = null;
        while(root != null){
            if(root.left == null){
                res.add(root.val);
                root = root.right;
            }else{
                pre = root.left;
                while(pre.right != null /*&& pre.right != root*/){
                    pre = pre.right;
                }
                if(pre.right == null){
                    pre.right = root;
                    TreeNode cur=root.left;
                    root.left=null;
                    root = cur;
                }/*else{
                    pre.right = null;
                    res.add(root.val);
                    root = root.right;
                }*/
            }
        }
        return res;
    }
}
