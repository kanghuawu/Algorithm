package leetcode._779_kth_symbol_in_grammar;

public class LE779KthGrammar {
    public int kthGrammar(int N, int K) {
        if (N == 1 && K == 1) return 0;
        if (kthGrammar(N-1, (K+1)/2) == 0) {
            if (K % 2 == 0) return 1;
            if (K % 2 == 1) return 0;
        }
        if (K % 2 == 0) return 0;
        return 1;
    }
}
