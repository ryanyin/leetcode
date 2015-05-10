package ReverseLinkedList0;


  
   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class Solution {
	
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		reverseList(head);
	}
    public static ListNode reverseList(ListNode head) {
    	if(head==null||head.next==null) return head;
    	ListNode dummpy=new ListNode(0);
    	dummpy.next=head;
    	ListNode pre=dummpy;
    	ListNode start=pre.next;
    	ListNode then=start.next;
    	while(then!=null){
    		start.next=then.next;
    		then.next=pre.next;
    		pre.next=then;
    		then=start.next;
    		
    	}
		return dummpy.next;
        
    }
}