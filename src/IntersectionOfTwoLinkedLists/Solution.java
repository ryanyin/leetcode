package IntersectionOfTwoLinkedLists;

import java.util.HashSet;


//  Definition for singly-linked list.
   class ListNode {
      int val;
      ListNode next;
     ListNode(int x) {
          val = x;
          next = null;
      }
  }
 

public class Solution {
 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	 HashSet<ListNode> temp=new HashSet<ListNode>();
	 ListNode fora=headA;
	 ListNode forb=headB;
	 while(fora!=null){
		 temp.add(fora);
		 fora=fora.next;
	 }
	 while(forb!=null){
		 if(!temp.add(forb)) return forb;
		 forb=forb.next;
	 }
	return null;
        
    }
 
 
 //���˵�����smart  ȱ�ݣ�û�п���û���ཻ������
/* public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
     if( null==headA || null==headB )
         return null;

     ListNode curA = headA, curB = headB;
     while( curA!=curB){
         curA = curA==null?headB:curA.next;
         curB = curB==null?headA:curB.next;
     }
     return curA;    
      
 }
 
 //�ҵĸ���
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
     if( null==headA || null==headB )
         return null;

     ListNode curA = headA, curB = headB;
     int count=0;
     while( curA!=curB){
         curA = curA==null?headB:curA.next;
         curB = curB==null?headA:curB.next;
         if(curA==null) count++;
         if(count==2) break;
     }
     return curA;    
      
 }   
 
 */

}
