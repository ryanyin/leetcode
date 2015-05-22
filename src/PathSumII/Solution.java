package PathSumII;

import java.util.ArrayList;
import java.util.List;

/*Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
For example:
Given the below binary tree and sum = 22,

             5
            / \
           4   8
          /   / \
         11  13  4
        /  \    / \
       7    2  5   1

return

[
  [5,4,11,2],
  [5,8,4,5]
]
*/

 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

public class Solution {
	public static void main(String[] args) {
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(4);
		root.right=new TreeNode(8);
		root.left.left=new TreeNode(11);
		root.right.left=new TreeNode(13);
		root.right.right=new TreeNode(7);
		System.out.println(pathSum(root, 20));
	}
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> result=new ArrayList<List<Integer>>();
    	if(root==null) return result;
    	if(root.left==null&&root.right==null&&root.val==sum){
    		List<Integer> t=new ArrayList<Integer>();
    		t.add(sum);
    		result.add(t);
    		return result;
    	}
    	result.addAll(pathSum(root.left, sum-root.val));
    	result.addAll(pathSum(root.right, sum-root.val));
    	for (List<Integer> list : result) {
			list.add(0, root.val);
		}	
		return result;   
    }
}
