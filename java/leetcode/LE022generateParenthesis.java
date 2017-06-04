package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LE022generateParenthesis {
	public List<String> generateParenthesis(int n) {
        List<String> re = generateParenthesisHelper(n, n, new ArrayList<String>(), new StringBuilder());
        return re;
    }
    
    public List<String> generateParenthesisHelper(int right, int left, List<String> list, StringBuilder sb){
        if(right == 0 && left == 0){
        	list.add(sb.toString());
        }else{
            if(right > 0){
                sb.append("(");
                generateParenthesisHelper(right - 1, left, list, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            if(right < left){
                sb.append(")");
                generateParenthesisHelper(right, left - 1, list, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return list;
    }
	
//	public List<String> generateParenthesis(int n) {
//        List<String> list = new ArrayList<String>();
//        backtrack(list, "", 0, 0, n);
//        return list;
//    }
//    
//    public void backtrack(List<String> list, String str, int open, int close, int max){
//        
//        if(str.length() == max*2){
//            list.add(str);
//            return;
//        }
//        
//        if(open < max) //open < max!!
//            backtrack(list, str+"(", open+1, close, max);
//        if(close < open) //close < open!!
//            backtrack(list, str+")", open, close+1, max);
//    }
}
