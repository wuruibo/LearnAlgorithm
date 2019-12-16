
package DepthFirstSearch.P988;

import CommonUtils.TreeNodeUtils;
import CommonUtils.TreeNode;

/**
 * 这个是废弃的版本
 * divide and conquer没办法解决
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
@Deprecated
class Solution {
    public String smallestFromLeaf(TreeNode root) {
        if (root==null) {
            return "";
        }
        return recursive(root);
    }

    /**
     * 每次都返回最小的组合
     * @param root
     * @return
     */
    public String recursive(TreeNode root){
        if (root==null) {
            return null;
        }
        String leftMin=recursive(root.left);
        String rightMin=recursive(root.right);

        String current=Character.toString((char) (root.val+97));
        if (leftMin!=null && rightMin!=null) {
            return leftSmallerRight(leftMin+current,rightMin+current)==1?leftMin+current:rightMin+current;
        }else if(leftMin==null && rightMin==null){
            return current;
        }else {
            return leftMin==null?rightMin+current:leftMin+current;
        }
    }

    /**
     * 左边比右边小返回1 相等返回0 左边比右边大返回-1
     * @param left
     * @param right
     * @return
     */
    public int leftSmallerRight(String left,String right){
        int size=left.length()>right.length()?right.length():left.length();
        for (int i = 0; i < size; i++) {
            if (left.charAt(i)==right.charAt(i)) {
                continue;
            }
            return left.charAt(i)<right.charAt(i)?1:-1;
        }
        if (left.length()==right.length()) {
            return 0;
        }
        return left.length()<right.length()?1:-1;
    }

    public static void main(String[] args) {
 /*       TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[0,1,2,3,4,3,4]");
        System.out.println(new Solution().smallestFromLeaf(treeNode));

        TreeNode treeNode1= TreeNodeUtils.stringToTreeNode("[25,1,3,1,3,0,2]");
        System.out.println(new Solution().smallestFromLeaf(treeNode1));*/

        TreeNode treeNode2= TreeNodeUtils.stringToTreeNode("[25,1,null,0,0,1,null,null,null,0]");
        System.out.println(new Solution().smallestFromLeaf(treeNode2));
    }
}