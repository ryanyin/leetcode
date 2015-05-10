package ClimbingStairs;

/*You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
*/
public class Solution {
	public static void main(String[] args) {
		System.out.println(climbStairs2(4));
	}
	public static int climbStairs2(int n) {
		if(n<=2) return n;
    	int[] temp=new int[n+1];
    	temp[0]=1;
    	temp[1]=1;
    	for(int i=2;i<=n;i++){
    		
    		temp[i]=temp[i-1]+temp[i-2];
    		
    	}
		return temp[n];
    	
    }
	
	
	//果然不是说想象中那么简单，超时了
    public int climbStairs(int n) {
    	if(n<=2) return n;
		return climbStairs(n-1)+climbStairs(n-2);
    }
}
