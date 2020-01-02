package Tree.P589;

import Tree.Node;

import java.util.ArrayList;
import java.util.List;

/*
// Definition for a Node.

*/
public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result=new ArrayList<>();
        preOrderRecur(root, result);
        return result;
    }
    private void preOrderRecur(Node root,List<Integer> temp){
        if (root==null) {
            return;
        }
        List<Node> list=root.children;
        temp.add(root.val);
        for (Node node : list) {
            preOrderRecur(node,temp);
        }
    }
}
