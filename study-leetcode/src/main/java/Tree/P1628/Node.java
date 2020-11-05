package Tree.P1628;

import CommonUtils.Node;

import java.util.Stack;


/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<BiOpNode> stack = new Stack<>();
        for (String s : postfix) {
            BiOpNode node = new BiOpNode(s);
            if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                node.right = stack.pop();
                node.left = stack.pop();
            }
            stack.push(node);
        }
        return stack.pop();
    }

    class BiOpNode extends Node {
        String val;
        BiOpNode left;
        BiOpNode right;

        BiOpNode(String val) {
            this.val = val;
        }

        public int evaluate() {
            switch (val) {
                case "+":
                    return left.evaluate() + right.evaluate();
                case "-":
                    return left.evaluate() - right.evaluate();
                case"*":
                    return left.evaluate() * right.evaluate();
                case"/":
                    return left.evaluate() / right.evaluate();
                default:
                    return Integer.valueOf(val);
            }
        }
    }
}

/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */