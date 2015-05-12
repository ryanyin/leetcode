package CopyListwithRandomPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.*/ 


class RandomListNode {
	     int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
	  };
public class Solution {

    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head==null) return head;
    	RandomListNode dummpy=new RandomListNode(0);
    	RandomListNode node=new RandomListNode(head.label);
    	dummpy.next=node;
    	HashMap<RandomListNode, RandomListNode> temp=new HashMap<>();
    	temp.put(head, node);
    	RandomListNode pre=head;
    	while(pre.next!=null){
    		RandomListNode next=pre.next;
    		RandomListNode t=new RandomListNode(next.label);
    		temp.put(next, t);
    		temp.get(pre).next=t;
    		pre=pre.next;
    	}
    	Set<RandomListNode> keys=temp.keySet();
    	for (RandomListNode randomListNode : keys) {
			if(randomListNode.random!=null)
				temp.get(randomListNode).random=temp.get(randomListNode.random);
		}
		return dummpy.next;       
    }
}
