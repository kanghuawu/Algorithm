package org.khwu;

public class LE388LengthLongestPath {
	// MY
    // idea: accumulation sum, tab's length = 1
    public int lengthLongestPath(String input) {
        String[] arr = input.split("\n");
        int[] len = new int[arr.length + 1];
        int max = 0;
        for(String str : arr){
            int tabs = str.lastIndexOf("\t")+ 1;    // <- lastIndexOf(string) usage
            int str_len = str.length() - tabs;    // <- tab's length = 1
            // System.out.println(tabs + " " + str_len);
            if(tabs > 0)
                len[tabs] = len[tabs -1] + str_len;
            else
                len[tabs] = str_len;
            if(str.contains(".")) 
                max = Math.max(max, len[tabs] + tabs);
        }
        return max;
    }
    
    // stack
}
