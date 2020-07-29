package Contest.Contest18.Problem3;

import CommonUtils.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 *   求每一个节点，左右的叶子节点，之间距离<=distance的组合，接着递归向左右子节点
 *   不会重复，因为每个节点的左右子组合都是不一样的，只让左的数目*右的数目
 */
class Solution {
    private int ans = 0;
    public int countPairs(TreeNode root, int distance) {
        dfs( root, distance );
        return ans;
    }
    //自底向上的递归，用count数组统计和当前节点的距离为 i 的叶子节点数目，
    //多于distance的不用考虑
    public int[] dfs( TreeNode root, int distance ){
        if( root == null ){
            return new int[ distance+1 ];
        }
        int[] count = new int[distance+1];
        if( root.left==null && root.right==null ){
            count[1] = 1;
            return count;
        }
        int[] leftCount = dfs( root.left, distance);
        int[] rightCount = dfs( root.right, distance);
        //计算组合数
        for( int i=1; i<=distance; i++){
            for( int j=1; j<=distance-i; j++ ){
                ans += leftCount[i]*rightCount[j];
            }
        }
        //向上层返回，距离+1
        for( int i=2; i<=distance; i++ ){
            count[i] = leftCount[i-1]+rightCount[i-1];
        }
        return count;
    }
}