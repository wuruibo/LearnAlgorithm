package Stack.P145;

import CommonUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Input: [1,null,2,3]
 *    1
 *     \               step1        step2       step3
 *      2            -------> [1] ------> [2,1]----->[3,2,1]
 *     /
 *    3
 * Output: [3,2,1]
 *
 *
 *
 *
 * @autor yeqiaozhu.
 * @date 2020-01-03
 */
public class UsingStack {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.add(0,curr.val);
            if(curr.left!=null) {
                stack.push(curr.left);
            }
            if(curr.right!=null) {
                stack.push(curr.right);
            }
        }
        return list;
    }
}
