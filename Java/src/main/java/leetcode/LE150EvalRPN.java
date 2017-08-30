package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LE150EvalRPN {
	// MY
//	public int evalRPN(String[] tokens) {
//        Deque<Integer> stack = new ArrayDeque<Integer>();
//        int first = 0;
//        int second = 0;
//        for (String s : tokens) {
//            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
//                second = stack.pop();
//                first = stack.pop();
//            }
//            switch(s) {
//                case "+":
//                    stack.push(first+second);
//                    break;
//                case "-":
//                    stack.push(first-second);
//                    break;
//                case "*":
//                    stack.push(first*second);
//                    break;
//                case "/":
//                    stack.push(first/second);
//                    System.out.println(first/second);
//                    break;
//                default:
//                    stack.push(Integer.parseInt(s));
//                    break;
//            }
//        }
//        return stack.pop();
//    }
	// MY
	public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (String s : tokens) {
            try {
                stack.push(Integer.parseInt(s));
            } catch(NumberFormatException e) {
                int second = stack.pop();
                int first = stack.pop();
                switch(s) {
                    case "+":
                        stack.push(first+second);
                        break;
                    case "-":
                        stack.push(first-second);
                        break;
                    case "*":
                        stack.push(first*second);
                        break;
                    case "/":
                        stack.push(first/second);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
