package PartitionList;

/*Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5. */

  class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(1);
		head.next=new ListNode(4);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(2);
		head.next.next.next.next=new ListNode(5);
		head.next.next.next.next.next=new ListNode(2);
		ListNode temp=partition(head, 3);
		System.out.println("--------");
	}

    public static ListNode partition(ListNode head, int x) {
    	if(head==null) return head;
    	ListNode less=new ListNode(Integer.MIN_VALUE);
    	ListNode more=new ListNode(Integer.MAX_VALUE);
    	ListNode lepoint=less;
    	ListNode mopoint=more;
    	while(head!=null){
    		if(head.val<x){
    			lepoint.next=head;
    			lepoint=head;
    		}else{
    			mopoint.next=head;
    			mopoint=head;
    		}
    		head=head.next;
    		lepoint.next=null;
    		mopoint.next=null;
    	}
    	lepoint.next=more.next;
		return less.next;
        
    }
	
}
