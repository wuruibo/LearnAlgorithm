package WaitingCollect.P437;

import CommonUtils.TreeNodeUtils;
import WaitingCollect.P104.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        //以当前root节点开头的 统计
        int mid=count(root,sum);
        int left=pathSum(root.left,sum);
        int right=pathSum(root.right,sum);

        return mid+left+right;
    }
    public int count(TreeNode root,int sum){
        if (root == null) {
            return 0;
        }
        int isMe=(root.val==sum)?1:0;
        int countLeft=count(root.left,sum-root.val);
        int countRight=count(root.right,sum-root.val);

        return isMe+countLeft+countRight;
    }
    public static void main(String[] args) {
        int[] ints={10,5,-3,3,2,11,3,-2,1};
        TreeNode treeNode=TreeNodeUtils.buildTreeNodeUsingArray(ints);

        new Solution().pathSum(treeNode,8);
    }
}