package org.khwu._151_reverse_words_in_a_string;

public class LE151ReverseWords {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') continue;
            int j = i;
            while (i >= 0 && s.charAt(i) != ' ') i--;
            sb.append(s, i + 1, j+ 1);
            sb.append(' ');
        }
        return sb.toString().trim();
    }

//    public String reverseWords(String s) {
//        StringBuilder sb = new StringBuilder();
//        String store;
//        int idx;
//        s = s.trim();
//        while(s.length() != 0){
//
//            idx = s.lastIndexOf(' ');
//            if(idx == -1) {
//                sb.append(s);
//                break;
//            }
//
//            store = s.substring(idx + 1);
//
//            sb.append(store);
//            sb.append(' ');
//            s = s.substring(0, idx);
//            s = s.trim();
//        }
//        return sb.toString().trim();
//    }

    public static void main(String[] args) {
        LE151ReverseWords test = new LE151ReverseWords();
        String s = " the sky is blue ";
        System.out.println(test.reverseWords(s));
    }
}
