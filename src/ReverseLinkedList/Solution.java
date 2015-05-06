package ReverseLinkedList;

/*Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ¡Ü m ¡Ü n ¡Ü length of list. */

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dump=new ListNode(0);
        dump.next=head;
        ListNode pre=dump;
        int i=1;
        while(i<m) {
        	pre=pre.next;
        	i++;
        }
        ListNode start=pre.next;
        ListNode then=start.next;
        for(int j=m;j<n;j++){
        	start.next=then.next;
        	then.next=pre.next;
        	pre.next=then;
        	then=start.next;
        }
		return dump.next;
    }
}
