package leetcode;

public class LE006Convert {
//	MY
	public String convert(String s, int numRows) {
		if(numRows == 1 || numRows >= s.length()) return s;
		StringBuffer re = new StringBuffer();
		int step = 2 * numRows - 2;
		for(int i = 0; i < Math.min(numRows, s.length()); i++){
			re.append(s.charAt(i));
			
			int zig_space = 2 * (numRows - i - 1) <= 0 ? step:  2 * (numRows - i - 1);
			int j = i + zig_space;
			while(j < s.length() && zig_space > 0){
				re.append(s.charAt(j));
				if(zig_space <= 0) break;
				else if(zig_space != step) zig_space = step - zig_space;
				j += zig_space;
			}
		}
		return re.toString();
	}
	
//	MY fail
//    public String convert(String s, int numRows) {
//    	int step = 2 * numRows - 2;
//    	String re = "";
//        for(int i = 0; i < numRows; i++){
//        	int j = i;
//        	while(j < s.length()){
//        		if(step > 0 && (j % step == 0 || (j - numRows + 1) % step == 0)){
//        			re += s.charAt(j);
////        			System.out.println(j);
//        			j += step;
//        		}
//        		else{
//        			re += s.charAt(j);
//        			int zig_space = 2 * (numRows - i - 1);
//        			j += zig_space;
////        			System.out.println(j);
//        			if(j < s.length() && j >= 0) re += s.charAt(j);
//        			j += step - zig_space;
////        			System.out.println(j);
////        			if(j < s.length() && j >= 0) re += s.charAt(j);
//        		}
//        	}
//        }
//    	return re;
//    }

//	discussion
//	public String convert(String s, int nRows) {
//	    char[] c = s.toCharArray();
//	    int len = c.length;
//	    StringBuffer[] sb = new StringBuffer[nRows];
//	    for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
//	    
//	    int i = 0;
//	    while (i < len) {
//	        for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
//	            sb[idx].append(c[i++]);
//	        for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
//	            sb[idx].append(c[i++]);
//	    }
//	    for (int idx = 1; idx < sb.length; idx++)
//	        sb[0].append(sb[idx]);
//	    return sb[0].toString();
//	}
//	public String convert(String s, int numRows) {
//        if(numRows<=1)return s;
//        StringBuilder[] sb=new StringBuilder[numRows];
//        for(int i=0;i<sb.length;i++){
//            sb[i]=new StringBuilder();   //init every sb element **important step!!!!
//        }
//        int incre=1;
//        int index=0;
//        for(int i=0;i<s.length();i++){
//            sb[index].append(s.charAt(i));
//            if(index==0){incre=1;}
//            if(index==numRows-1){incre=-1;}
//            index+=incre;
//        }
//
//        for(int i=1;i<sb.length;i++){
//            sb[0].append(sb[i]);
//        }
//        return sb[0].toString();
//    }
	//	fast
//	public String convert(String s, int numRows) {
//	    if(numRows==1) return s;
//	    int x = 2 * (numRows-1); // distance between pipes |/|/|...
//	    int len = s.length();
//	    char[] c = new char[len];
//	    int k =0;
//	    for(int i=0; i < numRows; i++)
//	    {
//	        for(int j=i;j<len;j=j+x)
//	        {
//	            c[k++] = s.charAt(j);
//	            if(i>0 && i<numRows-1 && j+x-2*i < len)
//	            {
//	                   c[k++] = s.charAt(j+x-2*i); // extra character between pipes
//	            }
//	        }
//	    }
//	    return new String(c);
//	}

    public static void main(String[] arg){
    	String s = "ABC";
    	int numRows = 2;
    	LE006Convert test = new LE006Convert();
    	System.out.println(test.convert(s, numRows));
    }
}
