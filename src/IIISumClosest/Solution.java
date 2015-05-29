package IIISumClosest;

import java.util.Arrays;

/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={-1,2,1,-4};
		System.out.println(threeSumClosest(a, 1));

	}
    public static int threeSumClosest(int[] nums, int target) {
    	Arrays.sort(nums);
    	int sum=0;
    	int min=Integer.MAX_VALUE;
    	if(nums.length<=3){
    		for (int i : nums) {
				sum+=i;
			}
    		return sum;
    	}
    	for(int i=0;i<nums.length-2;i++){
    		for(int low=i+1,high=nums.length-1;low<high;){
    			int temp=nums[low]+nums[high]+nums[i];
    			if(Math.abs(temp-target)<min){
    				min=Math.abs(temp-target);
    				sum=temp;
    			}
    			if(nums[low]+nums[high]>target-nums[i]){
    				high--;
    				continue;
    			}else if(nums[low]+nums[high]<target-nums[i]){
    				low++;
    				continue;
    			}else
    				return sum;
    		}
    		
    	}
		return sum;
        
    }
}
