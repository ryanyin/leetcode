package SingleNumberII;
/*Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? */
public class Solution {
	public static void main(String[] args) {
		int[] nums={1,1,3,3,4,1,3};
		System.out.println(singleNumber(nums));
	}
    public static int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones|twos;   
    }
}
