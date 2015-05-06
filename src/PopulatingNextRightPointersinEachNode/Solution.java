package PopulatingNextRightPointersinEachNode;

import java.util.ArrayList;
import java.util.List;

/*Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

For example,
Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7

After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL
*/
 class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) { val = x; }
	  }

public class Solution {

    public void connect(TreeLinkNode root) {
        List<TreeLinkNode> first=new ArrayList<TreeLinkNode>();
        List<TreeLinkNode> second=new ArrayList<TreeLinkNode>();
        if(root!=null) first.add(root);
        while(first.size()>0||second.size()>0){
        	if(first.size()>0){
        		for(int i=0;i<first.size();i++){
        			if(i<first.size()-1) first.get(i).next=first.get(i+1);
        			if(first.get(i).left!=null) {
        				second.add(first.get(i).left);
        			}
        			if(first.get(i).right!=null) {
        				second.add(first.get(i).right);
        			}
        		}
        		first.clear();
        	}else{
        		for(int i=0;i<second.size();i++){
        			if(i<second.size()-1) second.get(i).next=second.get(i+1);
        			if(second.get(i).left!=null) {
        				first.add(second.get(i).left);
        			}
        			if(second.get(i).right!=null) {
        				first.add(second.get(i).right);
        			}
        		}
        		second.clear();
        	}
        }
    }
}
