package Tree.二叉树后继者;

import CommonUtils.TreeNode;

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //问题的本质是找到最靠近p节点且值大于p节点值的那个节点
        TreeNode res = root;
        //设定临时变量方便对树的操作
        TreeNode temp = root;
        while (temp != null){
            //如果当前节点的值小于等于目标节点的值，那一定不是答案节点，且答案节点在该节点的右孩子中
            if (temp.val <= p.val) {
                temp = temp.right;
            } else {
                //如果当前节点的值大于目标节点的值，那么该节点有可能是答案节点，具体是不是需要遍历其左孩子，寻找更靠近p节点值的答案
                res = temp;
                temp = temp.left;
            }
        }
        return res.val <= p.val ? null : res;
    }
}
