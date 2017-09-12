
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WordNet {
    private RedBlackBST<String, Bag<Integer>> nouns;
    // constructor takes the name of the two input files
    // linearithmic
    public WordNet(String synsets, String hypernyms) {
        nouns = new RedBlackBST<String, Bag<Integer>>();
        In in = new In(synsets);
        while (in.hasNextLine()) {
            String[] nums = in.readLine().split(",");
            StdOut.println(Arrays.toString(nums));
            int key = Integer.parseInt(nums[0]);
            String[] words = nums[1].split(" ");
            for (String word : words) {
                Bag<Integer> bag = nouns.get(word);
                if (bag == null) {
                    bag = new Bag<Integer>();
                    nouns.put(word, bag);
                }
                bag.add(key);
            }
        }
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
    public String sca(String noun1, String noun2) {

    }

    // distance between noun1 and noun2 (defined below)
    // call ShortestCommonAncestor length() once
    public int distance(String noun1, String noun2) {

    }

    // do unit testing of this class
    public static void main(String[] args) {
      
    }
}