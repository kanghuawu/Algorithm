package org.khwu._449_serialize_and_deserialize_bst;

import org.khwu.utility.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Codec {

    private final String DELIMINATOR = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        sb.append(DELIMINATOR);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> q = new LinkedList<>(Arrays.asList(data.split(DELIMINATOR)));
        if (q.getFirst().equals("")) return null;
        return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserialize(Deque<String> q, int min, int max) {
        if (q.isEmpty()) return null;
        int val = Integer.parseInt(q.getFirst());
        if (val > max || val < min) return null;
        val = Integer.parseInt(q.removeFirst());
        TreeNode node = new TreeNode(val);
        node.left = deserialize(q, min, val);
        node.right = deserialize(q, val, max);
        return node;
    }
}
