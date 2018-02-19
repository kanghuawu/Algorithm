package org.khwu;

import java.util.ArrayList;
import java.util.List;

public class LE320GenerateAbbreviations {
	private List<String> result;
	public List<String> generateAbbreviations(String word) {
        genAbbreHelper(1, word);
        return result;
    }
	
	private void genAbbreHelper(int len, String word) {
		if(len == word.length()) return;
		for(int i=0; i<=word.length()-len; i++) {
			StringBuilder sb = new StringBuilder(word.substring(i, len));
			sb.append(String.valueOf(len));
			sb.append(word.substring(i, len));
			result.add(sb.toString());
		}
		// genAbbreHelper(len+1, word);
	}
	
	public static void main(String[] args) {
		LE320GenerateAbbreviations ga = new LE320GenerateAbbreviations();
		 System.out.println(ga.generateAbbreviations("word"));
//		System.out.println("test".substring(0,1));
	}
}
