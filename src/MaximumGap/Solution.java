package MaximumGap;

import java.util.Arrays;

public class Solution {
	/*Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
	Try to solve it in linear time/space.
	Return 0 if the array contains less than 2 elements.
	You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
	
	思路：桶排序
	 假设有N个元素A到B。
	那么最大差值不会小于ceiling[(B - A) / (N - 1)]， 根据鸽巢原理。
	令bucket（桶）的大小len = ceiling[(B - A) / (N - 1)]，则最多会有(B - A) / len + 1个桶
	对于数组中的任意整数K，很容易通过算式loc = (K - A) / len找出其桶的位置，然后维护每一个桶的最大值和最小值
	由于同一个桶内的元素之间的差值至多为len - 1，因此最终答案不会从同一个桶中选择。
         对于每一个非空的桶p，找出下一个非空的桶q，则q.min - p.max可能就是备选答案。返回所有这些可能值中的最大值。
	*/
	public int maximumGap(int[] nums) {
        if(nums.length<2||nums==null) return 0;
        int min=nums[0];
        int max=nums[0];
        for (int i : nums) {
			min=Math.min(min, i);
			max=Math.max(max, i);
		}
        int gap=(int) Math.ceil((double)(max-min)/(nums.length-1));
        int[] buck_max=new int[nums.length-1];
        int[] buck_min=new int[nums.length-1];
        Arrays.fill(buck_max, Integer.MIN_VALUE);
        Arrays.fill(buck_min, Integer.MAX_VALUE);
        for (int i : nums) {
			if(i==min||i==max)
				continue;
			int index=(i-min)/gap;
			buck_max[index]=Math.max(buck_max[index], i);
			buck_min[index]=Math.min(buck_min[index], i);
		}
        int maxgap=Integer.MIN_VALUE;
        int pre=min;
        for(int i=0;i<nums.length-1;i++){
        	if(buck_max[i]==Integer.MIN_VALUE&&buck_min[i]==Integer.MAX_VALUE)
        		continue;
        	maxgap=Math.max(maxgap, buck_min[i]-pre);
        	pre=buck_max[i];
        }
        maxgap=Math.max(maxgap, max-pre);
        return maxgap;
    }
}
