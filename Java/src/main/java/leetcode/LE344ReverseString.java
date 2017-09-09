package leetcode;

public class LE344ReverseString {
	//MY
//	public String reverseString(String s) {
//        int i = 0;
//        int j = s.length() - 1;
//        char[] s_char = new char[s.length()];
//        while(i <= j){
//        	s_char[i] = s.charAt(j);
//        	s_char[j] = s.charAt(i);
//        	i++;
//        	j--;
//        }
//        return String.valueOf(s_char);
//    }
	
//    public String reverseString(String s) {
//        byte[] bytes = s.getBytes();
//        for(int i = 0; i < bytes.length; i++){
//        	System.out.println(bytes[i]);
//        }
//        int i = 0;
//        int j = s.length() - 1;
//        while (i < j) {
//            byte temp = bytes[i];
//            bytes[i] = bytes[j];
//            
//            bytes[j] = temp;
//            i++;
//            j--;
//        }
//        return new String(bytes);
//    }
    
//    public String reverseString(String s) {
//        char[] word = s.toCharArray();
//        int i = 0;
//        int j = s.length() - 1;
//        while (i < j) {
//            word[i] = (char) (word[i] ^ word[j]);
//            word[j] = (char) (word[i] ^ word[j]);
//            word[i] = (char) (word[i] ^ word[j]);
//            i++;
//            j--;
//        }
//        return new String(word);
//    }
    
    public String reverseString(String s) {
        if(s.length() <= 1) return s;
        String left = reverseString(s.substring(0, s.length() / 2));
        String right = reverseString(s.substring(s.length() / 2));
        return right + left;
    }

    public static void main(String[] arg){
    	String s = "acbde";
    	LE344ReverseString test = new LE344ReverseString();
    	String toprint = test.reverseString(s);
    	System.out.println(toprint);
    }
}
