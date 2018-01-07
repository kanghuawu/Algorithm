package leetcode._760_find_anagram_mappings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LE760AnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            List<Integer> li = map.get(B[i]);
            if (li == null) {
                li = new ArrayList<>();
                map.put(B[i], li);
            }
            li.add(i);
        }

        int[] res = new int[B.length];
        for (int j = 0; j < A.length; j++) {
            List<Integer> li = map.get(A[j]);
            res[j] = li.remove(li.size()-1);
        }
        return res;
    }
}
