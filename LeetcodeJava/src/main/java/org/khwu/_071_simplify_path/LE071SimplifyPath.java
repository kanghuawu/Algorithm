package org.khwu._071_simplify_path;

import java.util.Deque;
import java.util.LinkedList;

public class LE071SimplifyPath {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Deque<String> q = new LinkedList<>();
        helper(arr, 0, q);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append("/");
            sb.append(q.removeFirst());
        }
        return sb.length() == 0 ?  "/" : sb.toString();
    }

    private void helper(String[] arr, int idx, Deque<String> q) {
        if (idx == arr.length) return;
        else if (arr[idx].equals("..")) {
            if (!q.isEmpty()) q.removeLast();
        } else if (!arr[idx].equals("") && !arr[idx].equals(".")) {
            q.addLast(arr[idx]);
        }
        helper(arr, idx + 1, q);
    }
}
