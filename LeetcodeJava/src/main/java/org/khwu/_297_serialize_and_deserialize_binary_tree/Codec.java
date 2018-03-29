package org.khwu._297_serialize_and_deserialize_binary_tree;

import org.khwu.utility.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public public class Codec {
    private static final String splitter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        build(root, sb);
        return sb.toString();
    }

    private void build(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NN);
            return;
        }
        sb.append(root.val);
        sb.append(splitter);
        build(root.left, sb);
        sb.append(splitter);
        build(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(splitter);
        Deque<String> q = new LinkedList<>(Arrays.asList(arr));
        return decompose(q);
    }

    private TreeNode decompose(Deque<String> q) {
        String s = q.removeFirst();
        if (s.equals(NN)) return null;

        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = decompose(q);
        root.right = decompose(q);
        return root;
    }
}
