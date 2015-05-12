package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

   All numbers (including target) will be positive integers.
   Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
   The solution set must not contain duplicate combinations.

For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3] */

public class Solution {

	public static void main(String[] args) {
		int[] a={7,3,9,6};
		System.out.println(combinationSum(a,6));
	}
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> result=new ArrayList<List<Integer>>();
    	Arrays.sort(candidates);
    	if(target<candidates[0]||candidates.length==0) return result;
    	result.addAll(getHepler(candidates, 0, target));
		return result;
    }

	private static List<List<Integer>> getHepler(int[] candidates, int i, int target) {
		// TODO Auto-generated method stub
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(i>candidates.length-1||target<candidates[i]) return result;
		for(int k=i;k<candidates.length;k++){
			int count=target/candidates[k];
			while(count>0){
				if(target==count*candidates[k]){
					List<Integer> temp=new ArrayList<Integer>();
					for(int j=0;j<count;j++)
						temp.add(candidates[k]);
					result.add(temp);
				}else{
					List<List<Integer>> temp=getHepler(candidates,k+1,target-count*candidates[k]);
					for (List<Integer> list : temp) {					
						for(int j=0;j<count;j++)
							 list.add(0, candidates[k]);
					}
					result.addAll(temp);
				}
				count--;
			}
		}
		return result;
	}
    
}
