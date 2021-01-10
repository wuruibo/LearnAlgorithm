package Contest.Contest10.Problem2;

import java.util.List;

/**
 * @author yqz
 */
public interface NestedInteger {
    /**
     * Return null if this NestedInteger holds a nested list
     * @return true if this NestedInteger holds a single integer, rather than a nested list.
     */
    boolean isInteger();

    /**Return null if this NestedInteger holds a nested list
     * @return the single integer that this NestedInteger holds, if it holds a single integer
     */
    Integer getInteger();

    /**
     * the nested list that this NestedInteger holds, if it holds a nested list
     * @return Return null if this NestedInteger holds a single integer
     */
    List<NestedInteger> getList();

}
