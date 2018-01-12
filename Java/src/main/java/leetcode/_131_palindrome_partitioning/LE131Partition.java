package leetcode._131_palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;

public class LE131Partition {

    // MY refinement 
    private List<List<String>>[] dp;
    private String s;
    private int len;
    public List<List<String>> partition(String s) {
        this.s = s;
        this.len = s.length();
        dp = new List[len+1];
        for (int i = 0; i < len+1; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add(new ArrayList<>());

        for (int i = 0; i < len; i++) {
            findPal(i, i);
            findPal(i, i+1);
        }

        return dp[len];
    }

    private void findPal(int j, int k) {
        for (; j >=0 && k < len; j--, k++) {
            if (s.charAt(j) != s.charAt(k)) break;
            String str = s.substring(j, k+1);
            for (List<String> arrAtJ : dp[j]) {
                List<String> arrAtK = new ArrayList<>(arrAtJ);
                arrAtK.add(str);
                dp[k+1].add(arrAtK);
            }
        }
    }

    // MY
//    public List<List<String>> partition(String s) {
//        List<List<String>>[] res = new List[s.length()+1];
//        char[] sArr = s.toCharArray();
//        res[0] = new ArrayList<>();
//        res[0].add(new ArrayList<>());
//        for (int i = 0; i < sArr.length; i++) {
//            res[i+1] = new ArrayList<>();
//            for (int j = 0; j <= i; j++) {
//                if (isPalindrome(sArr, j, i)) {
//                    int len = res[j].size();
//                    for (int k = 0; k < len; k++) {
//                        List<String> tmp = new ArrayList<>(res[j].get(k));
//                        tmp.add(s.substring(j, i+1));
//                        // System.out.println(s.substring(j, i+1));
//                        res[i+1].add(tmp);
//                    }
//                }
//            }
//        }
//        // for (List<List<String>> ll : res) {
//        //     System.out.println(ll);
//        // }
//        return res[s.length()];
//    }
//
//    private boolean isPalindrome(char[] sArr, int j, int i) {
//        for (; j < i; i--, j++) {
//            if (sArr[i] != sArr[j]) return false;
//        }
//        return true;
//    }
}
