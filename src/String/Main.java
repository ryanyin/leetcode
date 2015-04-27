package String;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("110010","10111"));

	}
	public static String addBinary(String a, String b) {
        a=(new StringBuilder(a)).reverse().toString();
        b=(new StringBuilder(b)).reverse().toString();
        StringBuilder output=new StringBuilder();
        int p=0;
        int tempf=0;
       
        while(p<a.length()&&p<b.length())
        {
            if(a.charAt(p)=='1'&&b.charAt(p)=='1')
            {
            	if(tempf==0)	output.append(0);
            	else output.append(1);
                 tempf=1;
            }else if((a.charAt(p)=='1'&&b.charAt(p)=='0')||(a.charAt(p)=='0'&&b.charAt(p)=='1')){
            	if(tempf==0){output.append(1); tempf=0;}
            	else {output.append(0); tempf=1;}
            }else{
            	if(tempf==0)	output.append(0);
            	else output.append(1);
                 tempf=0; 
            }
            p++;
        }
            if(p<a.length()){
                while(p<a.length())
                {
                    if(a.charAt(p)=='1'&&tempf==1){
                        output.append(0);
                        tempf=1;
                    }else if(a.charAt(p)=='0'&&tempf==0) 
                    {
                        output.append(0);
                        tempf=0;
                    }else{
                         output.append(1);
                         tempf=0;
                    }
                    p++;
                }
            }
            if(p<b.length()){
                 while(p<b.length())
                {
                    if(b.charAt(p)=='1'&&tempf==1){
                        output.append(0);
                        tempf=1;
                    }else if(b.charAt(p)=='0'&&tempf==0) 
                    {
                        output.append(0);
                        tempf=0;
                    }else{
                         output.append(1);
                         tempf=0;
                    }
                    p++;
                }
            }
        if(tempf==1) output.append(1);
        return output.reverse().toString();
    }
}
