package BinarySearch.P1305;

import CommonUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> left= new ArrayList<>(),right=new ArrayList<>();
        dfs(root1,left);dfs(root2,right);
        return mergeSort(left,right);
    }
    private List<Integer> mergeSort(List<Integer> left,List<Integer> right){
        int first=0,second=0;
        List<Integer> result=new ArrayList<>();
        while (first<left.size() || second<right.size()){
            if (first==left.size()) {
                result.add(right.get(second++));
            }else if (second==right.size()){
                result.add(left.get(first++));
            }else {
                if (left.get(first)<right.get(second)) {
                    result.add(left.get(first++));
                }else {
                    result.add(right.get(second++));
                }
            }
        }
        return result;
    }
    private void dfs(TreeNode root,List<Integer> params){
        if (root==null) {
            return;
        }
        dfs(root.left,params);
        params.add(root.val);
        dfs(root.right,params);
    }

    public static void main(String[] args) {

    }
}