package leetcode;

public class LE394DecodeString {
    // MY
    public String decodeString(String s) {
        return decodeStringHelper(1, s);
    }

    private String decodeStringHelper(int repeat, String str) {
        StringBuilder sb = new StringBuilder();
        int firstPtr = 0;
        int endPtr = 0;
        while (firstPtr < str.length()) {
            if (str.charAt(firstPtr) - '0' >= 0 && str.charAt(firstPtr) - '0' <= 9) {
                endPtr = firstPtr + 1;
                while (str.charAt(endPtr) - '0' >= 0 && str.charAt(endPtr) - '0' <= 9) endPtr++;
                int num = Integer.parseInt(str.substring(firstPtr, endPtr));
                int count = 1;
                firstPtr = endPtr;
                endPtr = firstPtr + 1;
                while (count != 0) {
                    if (str.charAt(endPtr) == '[') count++;
                    else if (str.charAt(endPtr) == ']') count--;
                    endPtr++;
                }
                sb.append(decodeStringHelper(num, str.substring(firstPtr + 1, endPtr - 1)));
                firstPtr = endPtr;
            } else {
                sb.append(str.charAt(firstPtr));
                firstPtr++;
            }
        }
        StringBuilder re = new StringBuilder();
        while (repeat > 0) {
            re.append(sb);
            repeat--;
        }
        return re.toString();
    }
    // stack
    // ref: https://discuss.leetcode.com/topic/57250/java-short-and-easy-understanding-solution-using-stack
//    public String decodeString(String s) {
//        Stack<Integer> count = new Stack<>();
//        Stack<String> result = new Stack<>();
//        int i = 0;
//        result.push("");
//        while (i < s.length()) {
//            char ch = s.charAt(i);
//            if (ch >= '0' && ch <= '9') {
//                int start = i;
//                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
//                count.push(Integer.parseInt(s.substring(start, i + 1)));
//            } else if (ch == '[') {
//                result.push("");
//            } else if (ch == ']') {
//                String str = result.pop();
//                StringBuilder sb = new StringBuilder();
//                int times = count.pop();
//                for (int j = 0; j < times; j += 1) {
//                    sb.append(str);
//                }
//                result.push(result.pop() + sb.toString());
//            } else {
//                result.push(result.pop() + ch);
//            }
//            i += 1;
//        }
//        return result.pop();
//    }
}