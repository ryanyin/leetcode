package UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

/*Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
		@Override
		public String toString() {
			return val + "";
		}
	      
	  }
public class Solution {

	public static void main(String[] args) {
		System.out.println(generateTrees(3));
	}
    public static List<TreeNode> generateTrees(int n) {
    	List<TreeNode> result=new ArrayList<TreeNode>();
    	if(n==0) {
    		TreeNode node=null;
    		result.add(node);
    		return result;
    	}
		return getAll(1,n);
        
    }

	private static List<TreeNode> getAll(int i, int n) {
		// TODO Auto-generated method stub
		List<TreeNode> result=new ArrayList<TreeNode>();
		if(i>n) return result;
		if(i==n) {
			TreeNode node=new TreeNode(i);
			result.add(node);
			return result;
		}
		for(int k=i;k<=n;k++){
			List<TreeNode> lefts=getAll(i,k-1);
			List<TreeNode> rights=getAll(k+1,n);
			
			if(lefts.size()>0&&rights.size()>0){
				for (TreeNode treeNode : lefts){
					for (TreeNode treeNode2 : rights) {
						TreeNode root=new TreeNode(k);
						root.left=treeNode;
						root.right=treeNode2;
						result.add(root);
					}
				}
				
			}else if(lefts.size()==0&&rights.size()>0){
				for (TreeNode treeNode2 : rights) {
					TreeNode root=new TreeNode(k);
					root.right=treeNode2;
					result.add(root);
				}
			}else if(lefts.size()>0&&rights.size()==0){
				for (TreeNode treeNode2 : lefts) {
					TreeNode root=new TreeNode(k);
					root.left=treeNode2;
					result.add(root);
				}
			}

		}
		return result;
	}
}
