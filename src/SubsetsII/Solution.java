package SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/*Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:

   Elements in a subset must be in non-descending order.
   The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
]
*/

public class Solution {
	public static void main(String[] args) {
		int[] a={1,1};
		System.out.println(subsetsWithDup(a));
	}
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> result=new ArrayList<List<Integer>>();
    	Arrays.sort(nums);
    	if(nums==null||nums.length==0) 
    	{
    		List<Integer> a=new ArrayList<Integer>();
    		result.add(a);
    		return result;
    	}
    	result.addAll(subHelper(0,nums));
		return result;
        
    }

	private static Set<List<Integer>> subHelper(int i, int[] nums) {
		// TODO Auto-generated method stub
		Set<List<Integer>> result=new HashSet<List<Integer>>();
		if(i==nums.length) {
    		List<Integer> a=new ArrayList<Integer>();
    		result.add(a);
    		return result;
    	}
		Set<List<Integer>> temp=subHelper(i+1, nums);
		for (List<Integer> list : temp) {
			List<Integer> alist=new ArrayList<Integer>();
			alist.addAll(list);
			alist.add(0, nums[i]);
			result.add(alist);
		}
		result.addAll(temp);
		return result;
	}
}
