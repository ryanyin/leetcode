package SwapNodesinPairs;

/*Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed. 
*/  
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
public class Solution {
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		swapPairs(head);
	}
    public static ListNode swapPairs(ListNode head) {
    	ListNode dummpy=new ListNode(0);
    	dummpy.next=head;
    	ListNode pre=dummpy;
    	while(pre.next!=null){
    		ListNode now=pre.next;
    		if(now.next!=null){
    			pre.next=now.next;
        		if(pre.next.next!=null) now.next=pre.next.next;
        		else now.next=null;
        		pre.next.next=now;
        		pre=pre.next.next;
    		}else
    			pre=pre.next;
    	}
		return dummpy.next;
        
    }
}
