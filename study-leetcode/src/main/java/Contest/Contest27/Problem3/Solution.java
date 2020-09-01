package Contest.Contest27.Problem3;

import java.util.TreeSet;

class Solution {
    public int findLatestStep(int[] arr, int m) {
        if (m == arr.length) {
            return m;
        }
        // 左开右开区间，两个连续的数之间包含为连续的1长度
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(0);
        treeSet.add(arr.length + 1);
        // 逆序拆分，使用了tree加速查找拆分的位置，并在每次拆分后判断左右连续1的长度是否符合条件
        for (int i = arr.length - 1; i >= 0; i--) {
            int divIndex = arr[i];
            int lower = treeSet.lower(divIndex);
            int higher = treeSet.higher(divIndex);
            if (divIndex - lower - 1 == m || higher - divIndex - 1 == m) {
                return i;
            } else {
                treeSet.add(divIndex);
            }

        }
        return -1;
    }
}