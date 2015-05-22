package DivideTwoIntegers;

/*Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT. */

public class Solution {
	public static void main(String[] args) {
		System.out.println(divide(
            	-2147483648,2));
	}
    public static int divide(int dividend, int divisor) {
		if(divisor==0) return Integer.MAX_VALUE;
		else if(divisor==1) return dividend;
		else if(divisor==-1) return dividend==Integer.MIN_VALUE?Integer.MAX_VALUE:-dividend;
		else{
			int result=0;
			long di=Math.abs((long)dividend);
			long ded=Math.abs((long)divisor);
			boolean flag=(dividend<0&&divisor>0)||(dividend>0&&divisor<0);
			for(int size=Integer.SIZE-1;size>=0&&di>=ded;size--){
				if (di>=ded<<size) {
					di-=ded<<size;
					result|=1<<size;
				}
			}
			if(flag) return -result;
			else return result;
		}
        
    }
}
