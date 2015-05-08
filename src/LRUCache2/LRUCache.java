package LRUCache2;

import java.util.HashMap;

public class LRUCache {
	private class Node {
		Node pre = null;
		Node next = null;
		int key = 0;
		int value = 0;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	int size = 0;
	HashMap<Integer, Node> map;
	Node head = null;
	Node tail = null;

	public LRUCache(int capacity) {
		size = capacity;
		map = new HashMap<Integer, Node>();
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;
		Node cur = map.get(key);
		Node pre = cur.pre;
		Node next = cur.next;
		if(next!=null){
			if (pre == null)
				head = next;
			else
				pre.next = next;
			next.pre=pre;
			tail.next = cur;
			cur.pre = tail;
			cur.next = null;
			tail = cur;
		}
		
		return cur.value;
	}

	public void set(int key, int value) {
		if(map.containsKey(key)){
			get(key);
			map.get(key).value=value;
		}else{
			Node cur=new Node(key, value);
			
			if(map.size()>=size){
				Node oldNode=head;
				if(oldNode!=null){
					head=head.next;
					oldNode.next=null;
					if(head!=null)
						head.pre=null;
					map.remove(oldNode.key);
				}
			}
			
			if(head==null){
				head=cur;
				tail=cur;
			}else{
				tail.next=cur;
				cur.pre=tail;
				tail=cur;
			}
			map.put(key, cur);
		}
	}
}
