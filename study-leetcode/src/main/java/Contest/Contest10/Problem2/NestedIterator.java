package Contest.Contest10.Problem2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private int index = 0;
    private List<Integer> result = new ArrayList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        recursive(nestedList);
    }

    private void recursive(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return;
        }
        for (int i = 0; i < nestedList.size(); i++) {
            recursive(nestedList.get(i).getList());
            result.add(nestedList.get(i).getInteger());
        }
    }

    @Override
    public Integer next() {
        if (index + 1 < result.size()) {
            return result.get(index + 1);
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        return index < result.size();
    }


    public static void main(String[] args) {

    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */