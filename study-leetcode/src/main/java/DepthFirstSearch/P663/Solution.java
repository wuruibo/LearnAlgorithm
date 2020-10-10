package DepthFirstSearch.P663;

import CommonUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<Integer> subSums=new ArrayList<Integer>();
    
    public boolean checkEqualTree(TreeNode root) {
        if(root==null){
            return false;
        }
        int totalSum=getSum(root);
        // 删除最后一个存的totalSum 如果是root节点 将无法删除边(排除root节点)
        subSums.remove(subSums.size()-1);
        // 总数为奇数时不可能均分
        if((totalSum&1)!=0){
            return false;
        }
        return subSums.contains(totalSum/2);
    }
    
    public int getSum(TreeNode node){
        if(node==null){
            return 0;
        }
        int sum=node.val + getSum(node.left) + getSum(node.right);
        subSums.add(sum);
        return sum;
    }
}
