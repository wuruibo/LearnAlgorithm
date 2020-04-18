package Tree.P508;

import CommonUtils.TreeNode;
import CommonUtils.TreeNodeUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 *
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *
 * Examples 1
 * Input:
 *
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 *
 *   5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
class Solution {
    private Integer mostTime=0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> temp= new HashMap<>();
        calculateSubtree(root,temp);

        //进行搜索
        List<Integer> result= new ArrayList<>();
        Iterator<Map.Entry<Integer,Integer>> iterator=temp.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer,Integer> entry=iterator.next();
            if (entry.getValue()==mostTime) {
                result.add(entry.getKey());
            }
        }
        int[] array=new int[result.size()];
        for (int j = 0; j < array.length; j++) {
            array[j]=result.get(j);
        }
        return array;
    }
    public int calculateSubtree(TreeNode root, Map<Integer,Integer> temp){
        if (root==null) return 0;

        int left=calculateSubtree(root.left,temp);
        int right=calculateSubtree(root.right,temp);
        int current=left+right+root.val;
        temp.put(current,temp.getOrDefault(current,0)+1);
        mostTime=Math.max(mostTime,temp.get(current));

        return current;
    }

    public static void main(String[] args) {
        TreeNode treeNode= TreeNodeUtils.stringToTreeNode("[5,2,null,null,-3,null,null]");
        Arrays.stream(new Solution().findFrequentTreeSum(treeNode)).forEach(integer-> System.out.println(integer));
    }
}