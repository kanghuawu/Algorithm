
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;

public class WordNet {
    private final RedBlackBST<String, Bag<Integer>> nouns;
    private final RedBlackBST<Integer, String> nounsR;
    private final Digraph graph;
    private final SAP sca;
    // constructor takes the name of the two input files
    // linearithmic
    public WordNet(String synsets, String hypernyms) {
        if (synsets == null || hypernyms == null) {
            throw new IllegalArgumentException();
        }
        this.nouns = new RedBlackBST<String, Bag<Integer>>();
        this.nounsR = new RedBlackBST<Integer, String>();
        In syn = new In(synsets);
        while (syn.hasNextLine()) {
            String[] nums = syn.readLine().split(",");
            int key = Integer.parseInt(nums[0]);
            String[] words = nums[1].split(" ");
            nounsR.put(key, nums[1]);
            for (String word : words) {
                Bag<Integer> bag = nouns.get(word);
                if (bag == null) {
                    bag = new Bag<Integer>();
                    nouns.put(word, bag);
                }
                bag.add(key);
            }
        }
        this.graph = new Digraph(nouns.size());
        In hyper = new In(hypernyms);
        while (hyper.hasNextLine()) {
            String[] hypers = hyper.readLine().split(",");
            int v = Integer.parseInt(hypers[0]);
            for (int i = 1; i < hypers.length; i++) {
                graph.addEdge(v, Integer.parseInt(hypers[i]));
            }
        }
        if (new DirectedCycle(graph).hasCycle()) {
            throw new IllegalArgumentException();
        }
        this.sca = new SAP(graph);
    }

    // all WordNet nouns
    public Iterable<String> nouns() {
        return nouns.keys();
    }

    // is the word a WordNet noun?
    // logarithmic
    public boolean isNoun(String word) {
        return nouns.contains(word);
    }

    // a synset (second field of synsets.txt) that is a shortest common ancestor
    // of noun1 and noun2 (defined below)
    // call ShortestCommonAncestor ancestor() once
    public String sap(String noun1, String noun2) {
        if (!isNoun(noun1) || !isNoun(noun2)) {
            throw new IllegalArgumentException();
        }
        int ancestor = sca.ancestor(nouns.get(noun1), nouns.get(noun2));
        return nounsR.get(ancestor);
    }

    // distance between noun1 and noun2 (defined below)
    // call ShortestCommonAncestor length() once
    public int distance(String noun1, String noun2) {
        if (!isNoun(noun1) || !isNoun(noun2)) {
            throw new IllegalArgumentException();
        }
        return sca.length(nouns.get(noun1), nouns.get(noun2));
    }

    // do unit testing of this class
    public static void main(String[] args) {
      
    }
}