package TwoSum;
import java.util.Hashtable;

public class Solution {
	public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        Hashtable<Integer,Integer> temp=new Hashtable<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
        	if(!temp.containsKey(nums[i]))
        		temp.put(target-nums[i], i);
        	else{
        		result[0]=temp.get(nums[i])+1;
        		result[1]=i+1;
        	}
        }
        return result;
    }
}
