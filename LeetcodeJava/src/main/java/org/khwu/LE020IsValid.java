package org.khwu;

public class LE020IsValid {
//    public boolean isValid(String s) {
//    	if(s.length()%2 != 0) return false;
//        char[] charr = s.toCharArray();
//    	Stack<Character> q = new Stack<Character>();
//        for(char ch : charr){
//    		if(ch == '(') {
//    			q.push(')');
//    		}else if(ch == '['){
//    			q.push(']');
//    		}else if(ch == '{'){
//    			q.push('}');
//    		}else if(q.isEmpty() || ch != q.pop()){
//    			return false;
//    		}
//    	}
//        return q.isEmpty();
//    }
    
    public boolean isValid(String s) {
		char[] stack = new char[s.length()];
		int head = 0;
		for(char c : s.toCharArray()) {
			switch(c) {
				case '{':
				case '[':
				case '(':
					stack[head++] = c;
					break;
				case '}':
					if(head == 0 || stack[--head] != '{') return false;
					break;
				case ')':
					if(head == 0 || stack[--head] != '(') return false;
					break;
				case ']':
					if(head == 0 || stack[--head] != '[') return false;
					break;
			}
		}
		return head == 0;
	}
	public static void main(String[] args){
		String s = "([])";
		LE020IsValid test = new LE020IsValid();
		System.out.println(test.isValid(s));
	}
}
