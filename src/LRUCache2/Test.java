package LRUCache2;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache test=new LRUCache(1);
		test.set(2, 1);
		int a=test.get(2);
		test.set(3,2);
		int b=test.get(2);
		int c=test.get(3);
	}

}
