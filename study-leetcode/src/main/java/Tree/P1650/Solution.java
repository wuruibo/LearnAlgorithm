package Tree.P1650;

import java.util.HashSet;
import java.util.Set;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};


class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Integer> set= new HashSet<>();
        while (p.parent != p) {
            set.add(p.val);
            p=p.parent;
        }
        set.add(p.val);
        while (!set.contains(q.val)){
            q=q.parent;
        }
        return q;
    }
}