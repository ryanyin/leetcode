package wildcardMatching;

public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("hi","*?"));
	}
	
	public static boolean isMatch(String s, String p){
		int ss=0,pp=0,match=0;
		int start=-1;
		while(ss<s.length()){
			if(pp<p.length()&&(p.charAt(pp)=='?'||p.charAt(pp)==s.charAt(ss))){pp++;ss++;}
			else if(pp<p.length()&&p.charAt(pp)=='*')
			{
				start=pp++;
//				ss++;
                match=ss;
			}
			else if(start!=-1)
			{
				pp=start+1;
				ss=match;
				match++;
			}
			else return false;
		}
		while(pp<p.length()&&p.charAt(pp)=='*')
			pp++;
		return pp==p.length();
	}

}
