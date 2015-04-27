package bst;

import java.util.ArrayList;
import java.util.LinkedList;
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
 class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
}
public class Solution {

	public static void main(String[] args){
		ListNode head=new ListNode(1);
		ListNode temp=head;
		temp.next=new ListNode(2);
		temp=temp.next;
		temp.next=new ListNode(3);
		temp=temp.next;
		temp.next=new ListNode(4);
		temp=temp.next;
		temp.next=new ListNode(5);
		temp=temp.next;
		temp.next=new ListNode(6);
		temp=temp.next;
		temp.next=new ListNode(7);
		temp=temp.next;
		temp.next=new ListNode(8);
		temp=temp.next;
		temp.next=new ListNode(9);
		temp=temp.next;
		temp.next=new ListNode(10);
		temp=temp.next;
		temp.next=new ListNode(11);
		Solution s=new Solution();
		System.out.println(s.sortedListToBST(head).val);
	}
/*	private ListNode node;

	public TreeNode sortedListToBST(ListNode head) {
	    if(head == null){
	        return null;
	    }

	    int size = 0;
	    ListNode runner = head;
	    node = head;

	    while(runner != null){
	        runner = runner.next;
	        size ++;
	    }

	    return inorderHelper(0, size - 1);
	}

	public TreeNode inorderHelper(int start, int end){
	    if(start > end){
	        return null;
	    }

	    int mid = start + (end - start) / 2;
	    TreeNode left = inorderHelper(start, mid - 1);

	    TreeNode treenode = new TreeNode(node.val);
	    treenode.left = left;
	    node = node.next;

	    TreeNode right = inorderHelper(mid + 1, end);
	    treenode.right = right;

	    return treenode;
	}
    */
	
	  public ListNode node;
	    public ArrayList<ListNode> temp=new ArrayList<>();
	    public TreeNode sortedListToBST(ListNode head) {
	    	TreeNode root = null;
	        if(head==null)  return root;
	        node=head;
	        int count=0;
	        while(head!=null){
	            temp.add(head);
	            head=head.next;
	            count++;
	        }
			return build(0,count-1,temp);
	    }
	    
	    public TreeNode build(int beg,int end,ArrayList<ListNode> temp){
	    	if(beg>end) return null;
	        int med=(beg+end)/2;
	        TreeNode root=new TreeNode(temp.get(med).val);
	        root.left=build(beg,med-1,temp);
	        root.right=build(med+1,end,temp);
			return root;
	    }
    
}
