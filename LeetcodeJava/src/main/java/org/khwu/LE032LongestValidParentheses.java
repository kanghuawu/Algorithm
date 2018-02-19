package org.khwu;

public class LE032LongestValidParentheses {
	//MY
    public int longestValidParentheses(String s) {
      int[] dp = new int[s.length()];
      int pos = 0;
      int maxlen = 0;
      for(int i = 0; i < s.length(); i++){
    	  dp[i] = pos;
    	  if(s.charAt(i) == '('){
    		  pos++;
    	  }else if(s.charAt(i) == ')'){
    		  pos--;
    		  for(int j = i - 1; j >= 0; j--){
    			  if(dp[j] == pos) {
    			      maxlen = Math.max(maxlen, i - j + 1);
    			  }else if(dp[j] < pos) break;
    		  }
    		  
    	  }
      }
      return maxlen;
    }
    //DP Time: O(n); Space: O(n)
//	public int longestValidParentheses(String s) {
//	    char[] S = s.toCharArray();
//	    int[] V = new int[S.length];
//	    int open = 0;
//	    int max = 0;
//	    for (int i=0; i<S.length; i++) {
//	        if (S[i] == '(') open++;
//	        if (S[i] == ')' && open > 0) {
//	            // matches found
//	            V[i] = 2+ V[i-1];
//	            // add matches from previous
//	            System.out.println(i + " / " + V[i] + " / " + V[i - 1]);
//	            System.out.println("open: " + open);
//	            System.out.println("i - V[i]: " + (i - V[i]));
//	            if(i-V[i]>0)
//	                V[i] += V[i-V[i]];
//	            System.out.println("V[i]: " + V[i]);
//	            open--;
//	        }
//	        if (V[i] > max) max = V[i];
//	    }
//	    return max;
//	}
//	public static void printarr(int[] arr){
//		for(int i = 0; i < arr.length; i++){
//			if(i < arr.length - 1) System.out.print(arr[i] + ", ");
//			else System.out.println(arr[i]);
//		}
//	}
	
    // stack
//	public int longestValidParentheses(String s) {
//        LinkedList<Integer> stack = new LinkedList<Integer>();
//        int result = 0;
//        stack.push(-1);
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
//                stack.pop();
//                result = Math.max(result, i - stack.peek());
//            } else {
//                stack.push(i);
//            }
//        }
//        return result;
//    }
	
	// Time: O(2n); Space: O(1)
//	public int longestValidParentheses(String s) {
//      return ltr(s, 0, s.length());
//    }
//
//    public int ltr(String s, int start, int end) {
//      int left = start;
//      int openLeft = 0;
//      int max = 0;
//      for(int i = start; i < end; i++) {
//        if(s.charAt(i) == '(')
//          openLeft++;
//        else
//          openLeft--;
//        if(openLeft < 0) {
//          int length = i - left;
//          if(length > max)
//            max = length;
//          left = i + 1;
//          openLeft = 0;
//        }
//      }
//      System.out.println(max);
//      if(openLeft == 0) {
//        int length = end - left;
//        if(length > max)
//          max = length;
//        System.out.println("l " + max);
//      } else {
//        int length = rtl(s, left, end);
//        if(length > max)
//          max = length;
//        System.out.println("r " + max);
//      }
//      return max;
//    }
//
//    public int rtl(String s, int start, int end) {
//      int right = end;
//      int openRight = 0;
//      int max = 0;
//      for(int i = end - 1; i >= start; i--) {
//        if(s.charAt(i) == ')')
//          openRight++;
//        else
//          openRight--;
//        if(openRight < 0) {
//          int length = right - (i + 1);
//          if(length > max)
//            max = length;
//          right = i;
//          openRight = 0;
//        }
//      }
//      if(openRight == 0) {
//        int length = right - start;
//        if(length > max)
//          max = length;
//      }
//      return max;
//    }
	public static void main(String[] args){
		String s = "()((()()";
		LE032LongestValidParentheses test = new LE032LongestValidParentheses();
		System.out.println(test.longestValidParentheses(s));
	}
}
