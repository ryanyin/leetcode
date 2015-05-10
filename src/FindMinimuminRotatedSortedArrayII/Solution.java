package FindMinimuminRotatedSortedArrayII;





/*Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.*/

public class Solution {
	public static void main(String[] args) {
		Solution s=new Solution();
		int[] a={2,3,4,5,6,1};
		s.findMin(a);
	}
	 public int findMin(int[] nums) {
	    	
			return fimSecond(nums,0,nums.length-1);
	    }

	private int fimSecond(int[] nums, int i, int j) {
			// TODO Auto-generated method stub
		while(j>=i&&nums[i]==nums[j]) j--;
		
		if(j-i<=1) {
			if(j<0) return nums[i];
			else
				return Math.min(nums[i], nums[j]);
		}
		if(nums[i]<=nums[j]) return nums[i];
		int med=i+(j-i)/2;
		if(nums[med]>=nums[i]) return fimSecond(nums,med+1,j);
		else return fimSecond(nums,i,med);
		
	}
}
