package LinkedListCycle;

/*Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? */

 class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
public class Solution {
	
    public boolean hasCycle(ListNode head) {
    	if(head==null) return false;
    	ListNode first=head;
    	ListNode second=head.next;
    	while(first!=null&&second.next!=null){
    		first=first.next;
    		second=second.next.next;
    		if(first==second) return true;
    	}
		return false;
        
    }
    
/*  ³öÏÖ´íÎó
 *   public static boolean hasCycle2(ListNode head) {
    	if(head==null) return false;
    	ListNode node=head;
    	while(head!=null&&head.next!=null){
    		if(head.next==head) return true;
    		head=head.next;
    		node.next=node;
    	}
		return false;   
    }*/
    
    
    public static boolean hasCycle3(ListNode head) {
    	if(head==null||head.next==null) return false;
    	if(head.next==head) return true;
    	ListNode node=head.next;
    	head.next=head;
    	return hasCycle3(node);
    }
}
