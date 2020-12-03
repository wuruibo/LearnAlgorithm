package Tree.P331;

/**
 * 验证二叉树的前序遍历
 * https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */
class Solution {
  public boolean isValidSerialization(String preorder) {
    // number of available slots
    int slots = 1;

    int n = preorder.length();
    for(int i = 0; i < n; ++i) {
      if (preorder.charAt(i) == ',') {
        // one node takes one slot
        --slots;

        // no more slots available
        if (slots < 0) {
          return false;
        }

        // non-empty node creates two children slots
        if (preorder.charAt(i - 1) != '#') {
          slots += 2;
        }
      }
    }

    // the last node
    slots = (preorder.charAt(n - 1) == '#') ? slots - 1 : slots + 1;
    // all slots should be used up
    return slots == 0;
  }
}
