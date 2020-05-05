package BackTracking.P1286;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Design an Iterator class, which has:
 *
 * A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
 * A function next() that returns the next combination of length combinationLength in lexicographical order.
 * A function hasNext() that returns True if and only if there exists a next combination.
 *
 *
 * Example:
 *
 * CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.
 *
 * iterator.next(); // returns "ab"
 * iterator.hasNext(); // returns true
 * iterator.next(); // returns "ac"
 * iterator.hasNext(); // returns true
 * iterator.next(); // returns "bc"
 * iterator.hasNext(); // returns false
 *
 *
 * Constraints:
 *
 * 1 <= combinationLength <= characters.length <= 15
 * There will be at most 10^4 function calls per test.
 * It's guaranteed that all calls of the function next are valid.
 */
class CombinationIterator {
    private List<String> result;
    private Integer index=0;
    private String characters;
    private Integer combinationLength;
    public CombinationIterator(String characters, int combinationLength) {
        this.result= new ArrayList<>();
        this.characters=characters;
        this.combinationLength=combinationLength;
        backTracking(0,new StringBuilder());
    }
    private void backTracking(int begin,StringBuilder temp){
        if (temp.length()==combinationLength) {
            result.add(temp.toString());
            return;
        }
        for (int i = begin; i < characters.length(); i++) {
            temp.append(characters.charAt(i));
            backTracking(i+1,temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    
    public String next() {
        return result.get(index++);
    }
    public boolean hasNext() {
        return index<result.size();
    }

    public static void main(String[] args) {
        CombinationIterator iterator=new CombinationIterator("abc",3);
        while (iterator.hasNext()) System.out.println(iterator.next());
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */