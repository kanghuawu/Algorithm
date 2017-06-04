package leetcode;

public class LE151reverseWords {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String store;
        int idx;
        s = s.trim();
        while(s.length() != 0){
            
            idx = s.lastIndexOf(' ');
            if(idx == -1) {
                sb.append(s);
                break;
            }
            
            store = s.substring(idx + 1);
            
            sb.append(store);
            sb.append(' ');
            s = s.substring(0, idx);
            s = s.trim();
        }
        return sb.toString().trim();
    }
}
