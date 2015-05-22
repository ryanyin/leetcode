package SubstringwithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter). */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a={"foo", "bar"};
		System.out.println(findSubstring2("barfoothefoobarman", a));
	}
	public static int num;
	public static int size;
    public static List<Integer> findSubstring(String s, String[] words) {
    	List<Integer> result=new ArrayList<Integer>();
    	if(words.length==0||words==null) return result;
    	num=words[0].length();
    	size=words.length;
    	HashMap<String, Integer> temp=new HashMap<String, Integer>();
    	for (int j = 0; j < words.length; j++) {
			temp.put(words[j], temp.containsKey(words[j])?temp.get(words[j])+1:1);
			
		}
    	int i=0;
    	while(i<=s.length()-num*size){
    		if(temp.containsKey(s.substring(i, i+num))){
    			HashMap<String, Integer> t=new HashMap<String, Integer>();
    			for(int j=0;j<size;j++){
    				String string=s.substring(i+j*num, i+(j+1)*num);
    				t.put(string, t.containsKey(string)?t.get(string)+1:1);
    			}
    			if(temp.equals(t))
    				result.add(i);
    		}
    		i++;
    	}
		return result;
        
    }

    
    public static List<Integer> findSubstring2(String S, String[] L)
    {
        final List<Integer> result = new ArrayList<>();
        if (L.length > 0 && L[0].length() > 0 && S.length() >= L.length * L[0].length())
        {
            final Map<String, Integer> dict = new HashMap<>();

            for (final String str : L)
            {
                dict.put(str, (dict.containsKey(str) ? dict.get(str) : 0) + 1);
            }

            final int len = L[0].length();
            // We only start from 0 ~ len - 1.
            for (int i = 0; i < len; ++i)
            {
                // This map is used to store the remained word count in the directory.
                Map<String, Integer> map = new HashMap<>(dict);
                // Use queue to store current sequence. All the words in queue also should be in map.
                final Queue<String> queue = new LinkedList<>();
                // Every time add one word.
                for (int j = i; (j + len) <= S.length(); j += len)
                {
                    final String str = S.substring(j, j + len);
                    // If this word is in directory.
                    if (dict.containsKey(str))
                    {
                        // Add the word into the sequence.
                        queue.add(str);
                        // We already have enough such word in the sequence so we need to move the starting point to next such word.
                        if (map.get(str) == 0)
                        {
                            while (!str.equals(queue.element()))
                            {
                                final String item = queue.remove();
                                map.put(item, map.get(item) + 1);
                            }

                            queue.remove();
                        }
                        else
                        {
                            map.put(str, map.get(str) - 1);
                        }

                        // There are enough words in the sequence.
                        if (queue.size() == L.length)
                        {
                            result.add(j - len * (L.length - 1));
                        }
                    }
                    else
                    {
                        queue.clear();
                        map = new HashMap<>(dict);
                    }
                }
            }
        }
        return result;
    }

}
