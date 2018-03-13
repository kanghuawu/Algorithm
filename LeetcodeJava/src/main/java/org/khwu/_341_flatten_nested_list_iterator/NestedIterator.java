package org.khwu._341_flatten_nested_list_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    private List<Integer> li;
    private int cur;

    public NestedIterator(List<NestedInteger> nested) {
        li = new ArrayList<>();
        cur = 0;
        dfs(nested, li);
    }

    private void dfs(List<NestedInteger> nested, List<Integer> li) {
        for (NestedInteger ni : nested) {
            if (ni.isInteger()) li.add(ni.getInteger());
            else dfs(ni.getList(), li);
        }
    }

    @Override
    public Integer next() {
        return li.get(cur++);
    }

    @Override
    public boolean hasNext() {
        return cur < li.size();
    }
}
