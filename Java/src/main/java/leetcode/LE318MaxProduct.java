package leetcode;

public class LE318MaxProduct {
    public int maxProduct(String[] words) {
    	if(words == null || words.length == 0) return 0;
        int len = words.length;
        int[] strnum = new int[len];
        for(int i = 0; i < len; i++){
        	int wordnum = 0;
        	for(int j = 0; j < words[i].length(); j++){
        		int charnum = words[i].charAt(j) - 'a';
        		wordnum = wordnum | (1 << charnum + 1);
        	}
        	strnum[i] = wordnum;
        }
        
        int maxnum = 0;
        for(int i = 0; i < len; i++){
        	for(int j = i; j < len; j++){
        		if((strnum[i] & strnum[j]) == 0){
        			maxnum = Math.max(maxnum ,words[i].length() * words[j].length());
        		}
        	}
        }
        return maxnum;
    }
    public static void main(String[] args){
//		String[] s = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
//    	String[] s = {};
//    	String[] s = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
    	String[] s = {"a", "aa", "aaa", "aaaa"};
		LE318MaxProduct test = new LE318MaxProduct();
		System.out.println(test.maxProduct(s));
    }
}
