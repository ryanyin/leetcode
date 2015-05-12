package CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:

 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 The solution set must not contain duplicate combinations.

 For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 A solution set is:
 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6] */

public class Solution {

	public static void main(String[] args) {
		int[] a = { 10,1,2,7,6,1,5};
		System.out.println(combinationSum(a, 8));
	}

	public static List<List<Integer>> combinationSum(int[] candidates,
			int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		if (target < candidates[0] || candidates.length == 0)
			return result;
		result.addAll(getHepler(candidates, 0, target));
		return result;
	}

	private static Set<List<Integer>> getHepler(int[] candidates, int i,
			int target) {
		// TODO Auto-generated method stub
		Set<List<Integer>> result = new HashSet<List<Integer>>();
		if (i > candidates.length - 1 || target < candidates[i])
			return result;
		for (int k = i; k < candidates.length; k++) {

			if (target == candidates[k]) {
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(candidates[k]);
				result.add(temp);
			} else {
				Set<List<Integer>> temp = getHepler(candidates, k + 1, target
						- candidates[k]);
				for (List<Integer> list : temp) {
					list.add(0, candidates[k]);
				}
				result.addAll(temp);
			}

		}
		return result;
	}

}
