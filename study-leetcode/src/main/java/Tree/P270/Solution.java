package Tree.P270;

import CommonUtils.TreeNode;

/**
 * @author yeqiaozhu
 * 直接用二分
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        int val, closest = root.val;
        while (root != null) {
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            root =  target < root.val ? root.left : root.right;
        }
        return closest;
    }

}
