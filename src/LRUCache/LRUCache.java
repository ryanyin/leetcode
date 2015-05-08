package LRUCache;



/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item. 
*/

//¥ÌŒÛ £∫≥¨ ±°£°£°£°£
/*public class LRUCache {
	HashMap<Integer, Integer> cap;
	LinkedList<Integer> rec;
	int size;
    public LRUCache(int capacity) {
        size=capacity;
        cap=new HashMap<Integer, Integer>();
        rec=new LinkedList<Integer>();
    }
    
    public int get(int key) {
    	if(cap.containsKey(key)) {
    		rec.addLast(key);
    		return cap.get(key);
    	}
		return -1;    
    }
    
    public void set(int key, int value) {
    	cap.put(key, value);
        if(cap.size()>size){
        	int last=rec.removeFirst();
        	while(rec.size()>0&&rec.contains(last)) 
        		last=rec.removeFirst();
        	cap.remove(last);
        }
		rec.addLast(key);
    }
}*/


// π”√LinkedHashMap
import java.util.LinkedHashMap;
import java.util.Map;
public class LRUCache {
    private Map<Integer, Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
    map=new LinkedHashMap<Integer, Integer>(capacity, 1, true); //set access order to true
    this.capacity = capacity;
    }

    public int get(int key) {
    if (!map.containsKey(key)) return -1;
    return map.get(key);
    }

    public void set(int key, int value) {
    if (!map.containsKey(key) && (map.size() == capacity)) {
        map.remove(map.keySet().iterator().next());
    }
    map.put(key, value);
    }
}
