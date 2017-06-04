package leetcode;

public class LE139wordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] arr = new false[s.length()];
        arr[0] = true;
        String temp = ""
        int j;
        for(int i = 0; i< s.length(); i++){
            for(int j = 0; j < i; j++){
                if(wordDict.substring(j, i)) arr[i] = true;
            }
        }
        return arr[s.length() - 1];
    }
	public boolean wordBreak(String s, List<String> wordDict) {
        if(s.contains(s)) return true;
        else{
            for(int i = 0; i < s.length(); i++){
                boolean le = wordBreak(s.substring(0, i), wordDict);
                boolean ri = wordBreak(s.substring(i), wordDict);
                return le && ri;
            }
        }
        return false;
    }
}
