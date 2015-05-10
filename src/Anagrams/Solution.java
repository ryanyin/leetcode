package Anagrams;

/*Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> anagrams(String[] strs) {
    	HashMap<String, List<String>> map=new HashMap<String, List<String>>();
    	for (String string : strs) {
			int[] temp=new int[26];
			for(int i=0;i<string.length();i++){
				int a=string.charAt(i)-'a';
				temp[a]++;
			}
			StringBuilder s=new StringBuilder();
			for (int i : temp) {
				s.append(i);
			}
			if(map.containsKey(s.toString())) map.get(s.toString()).add(string);
			else{
				List<String> re=new ArrayList<String>();
				re.add(string);
				map.put(s.toString(), re);
			}
		}
    	List<String>  result=new ArrayList<String>();
    	Set<String> keyset=map.keySet();
    	for (Iterator<String> iterator = keyset.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			if(map.get(string).size()>1) result.addAll(map.get(string));
		}
		return result;  
    }
}
