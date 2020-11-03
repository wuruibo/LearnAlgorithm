package Tree.P1261;

import CommonUtils.TreeNode;

import java.util.HashMap;

class FindElements {
    private HashMap<Integer, Integer> map = new HashMap<>();
    public FindElements(TreeNode root) {
        root.val = 0;
        reverse(root, 0);
    }
    public void reverse(TreeNode son, int v) {
        if (son == null) {
            return;
        }
        son.val = v;
        map.put(v, 1);
        reverse(son.left, 2 * v + 1);
        reverse(son.right, 2 * v + 2);
    }
    public boolean find(int target) {
        return map.containsKey(target);
    }
}