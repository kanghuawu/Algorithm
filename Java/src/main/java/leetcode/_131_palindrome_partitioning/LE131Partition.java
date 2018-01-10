package leetcode._131_palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;

public class LE131Partition {
    public List<List<String>> partition(String s) {
        List<List<String>>[] res = new List[s.length()+1];
        char[] sArr = s.toCharArray();
        res[0] = new ArrayList<>();
        res[0].add(new ArrayList<>());
        for (int i = 0; i < sArr.length; i++) {
            res[i+1] = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (isPalindrome(sArr, j, i)) {
                    int len = res[j].size();
                    for (int k = 0; k < len; k++) {
                        List<String> tmp = new ArrayList<>(res[j].get(k));
                        tmp.add(s.substring(j, i+1));
                        // System.out.println(s.substring(j, i+1));
                        res[i+1].add(tmp);
                    }
                }
            }
        }
        // for (List<List<String>> ll : res) {
        //     System.out.println(ll);
        // }
        return res[s.length()];
    }

    private boolean isPalindrome(char[] sArr, int j, int i) {
        for (; j < i; i--, j++) {
            if (sArr[i] != sArr[j]) return false;
        }
        return true;
    }
}
