package leetcode;

public class LE038CountAndSay {
    public String countAndSay(int n) {
        StringBuilder oldSB = new StringBuilder("1");
        for (int i = 0; i < n - 1; i++) {
            char ch = oldSB.charAt(0);
            int start = 0;
            StringBuilder newSB = new StringBuilder();
            for (int end = 1; end <= oldSB.length(); end++) {
                if (end == oldSB.length() || ch != oldSB.charAt(end)){
                    newSB.append(String.valueOf(end - start));
                    newSB.append(ch);
                    if (end != oldSB.length()) {
                        ch = oldSB.charAt(end);
                        start = end;
                    }
                }
            }
            oldSB = newSB;
        }
        return oldSB.toString();
    }

//    public String countAndSay(int n) {
//        String s = "1";
//        for (int i = 0; i < n - 1; i++) {
//            char ch = s.charAt(0);
//            int start = 0;
//            StringBuilder sb = new StringBuilder();
//            for (int j = 1; j <= s.length(); j++) {
//                if (j == s.length() || ch != s.charAt(j)){
//                    sb.append(String.valueOf(j - start));
//                    sb.append(ch);
//                    if (j != s.length()) {
//                        ch = s.charAt(j);
//                        start = j;
//                    }
//                }
//            }
//            s = sb.toString();
//        }
//        return s;
//    }
}
