package GenerateParentheses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"*/ 

public class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> temp=new ArrayList<String>();
		if(n==0) return temp;
//		List<String> tempAll=getAll(n);
		return null;      
    }
public static void main(String[] args) {
	System.out.println(getAll(4));
}
	private static List<String> getAll(int n) {
		// TODO Auto-generated method stub
		Set<String> temp=new HashSet<String>();
		String start="()";
		temp.add(start);
		Set<String> temp2=new HashSet<String>();
		List<String> result=new ArrayList<String>();
		if(n==1) {result.add("()"); return result;}
		for(int i=1;i<n;i++){
			if(temp2.size()==0){
				for (Iterator<String> iterator = temp.iterator(); iterator.hasNext();) {
					StringBuilder stringBuilder = new StringBuilder((String) iterator.next());
					for(int j=0;j<=stringBuilder.length();j++){
						StringBuilder sj=new StringBuilder(stringBuilder.toString());
						sj.insert(j, '(');
						for(int k=j+1;k<=sj.length();k++){
							StringBuilder sk=new StringBuilder(sj.toString());
							sk.insert(k, ')');
							temp2.add(sk.toString());
						}
					}
				}
				temp.clear();
			}else{
				for (Iterator<String> iterator = temp2.iterator(); iterator.hasNext();) {
					StringBuilder stringBuilder = new StringBuilder((String) iterator.next());
					for(int j=0;j<=stringBuilder.length();j++){
						StringBuilder sj=new StringBuilder(stringBuilder.toString());
						sj.insert(j, '(');
						for(int k=j+1;k<=sj.length();k++){
							StringBuilder sk=new StringBuilder(sj.toString());
							sk.insert(k, ')');
							temp.add(sk.toString());
						}
					}
				}
				temp2.clear();
			}
		}
		
		result.addAll((temp.size()==0)?temp2:temp);
		return result;
	}
	
	
	//一个更加简练的方法
	public List<String> generateParenthesis2(int n)
    {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));

        for (int i = 1; i <= n; ++i)
        {
            final List<String> list = new ArrayList<>();

            for (int j = 0; j < i; ++j)
            {
                for (final String first : lists.get(j))
                {
                    for (final String second : lists.get(i - 1 - j))
                    {
                        list.add("(" + first + ")" + second);
                    }
                }
            }

            lists.add(list);
        }

        return lists.get(lists.size() - 1);
    }
}
