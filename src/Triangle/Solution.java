package Triangle;

import java.util.ArrayList;
import java.util.List;

/*Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 
*/
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if(triangle==null||triangle.size()==0) return 0;
    	if(triangle.size()==1) return triangle.get(0).get(0);
    	List<Integer> first=new ArrayList<Integer>();
    	first.add(triangle.get(0).get(0));
    	List<Integer> second=new ArrayList<Integer>();
    	for (int i=1;i<triangle.size();i++) {
			if(second.size()==0){
				for(int j=0;j<triangle.get(i).size();j++){
					if(j==0) second.add(first.get(0)+triangle.get(i).get(j));
					else if(j==triangle.get(i).size()-1) second.add(first.get(first.size()-1)+triangle.get(i).get(j));
					else{
						second.add(triangle.get(i).get(j)+Math.min(first.get(j-1), first.get(j)));
					}
				}
				first.clear();
			}else{
				for(int j=0;j<triangle.get(i).size();j++){
					if(j==0) first.add(second.get(0)+triangle.get(i).get(j));
					else if(j==triangle.get(i).size()-1) first.add(second.get(second.size()-1)+triangle.get(i).get(j));
					else{
						first.add(triangle.get(i).get(j)+Math.min(second.get(j-1), second.get(j)));
					}
				}
				second.clear();
			}
		}
    	int result=Integer.MAX_VALUE;
    	List<Integer> third=(first.size()==0?second:first);
    	for (Integer integer : third) {
			if(result>integer) result=integer;
		}
		return result;    
    }

    
    //可以将结果存在原集合中，并且从后往前遍历，避免最后的找最小值
    public int minimumTotal2(List<List<Integer>> triangle) {
    	if(triangle==null||triangle.size()==0) return 0;
    	if(triangle.size()==1) return triangle.get(0).get(0);
    	for(int i=triangle.size()-2;i>=0;i++){
    		for(int j=0;j<i;j++){
    			int sum=Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1))+triangle.get(i).get(j);
    			triangle.get(i).set(j, sum);
    		}
    	}
		return triangle.get(0).get(0);
    	
    }

}
