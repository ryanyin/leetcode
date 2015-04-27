package solveNQueens;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		System.out.println(s.solveNQueens(3));
	}
	public List<String[]> solveNQueens(int n) {
		StringBuilder[] tem=new StringBuilder[n];
		StringBuilder s=new StringBuilder();
		for(int i=0;i<n-1;i++){
			s.append('.');
		}
		for (int i = 0; i < tem.length; i++) {
			tem[i]=new StringBuilder(s.toString());
			tem[i].insert(i, 'Q');
		}
		String[] fin=new String[n];
		for (int i = 0; i < fin.length; i++) {
			fin[i]=tem[i].toString();
		}
		List<String[]> finaresult=new ArrayList<String[]>();
		List<List<String>> result=getResult(fin);
		for (List<String> list : result) {
			String[] t=new String[list.size()];
			for (int i = 0; i < t.length; i++) {
				t[i]=list.get(i);
			}
			finaresult.add(t);
		}
		return finaresult;
    }
	private List<List<String>> getResult(String[] fin) {
		// TODO Auto-generated method stub
		List<List<String>> result=new ArrayList<List<String>>();
		List<List<String>> temp=new ArrayList<List<String>>();
		List<String> temp1=new ArrayList<>();
		temp1.add(fin[0]);
		temp.add(temp1);
		for (int i = 1; i < fin.length; i++) {
			if(result.isEmpty()){
				for (List<String> list : temp) {
					int a=list.size();
					for (int j = 0; j <=a; j++) {
						List<String> t2=new ArrayList<String>();
						t2.addAll(list);
						t2.add(j, fin[i]);
						result.add(t2);
					}
				}
				temp.clear();
			}else{
				for (List<String> list : result){
					int a=list.size();
					for (int j = 0; j <=a; j++) {
						List<String> t2=new ArrayList<String>();
						t2.addAll(list);
						t2.add(j, fin[i]);
						temp.add(t2);
					}
				}
				result.clear();
			}
		}
		
		return result.isEmpty()?temp:result;
	}
}
