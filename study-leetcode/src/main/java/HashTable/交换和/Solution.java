package HashTable.交换和;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 *
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 *
 * 示例:
 *
 * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * 输出: [1, 3]
 * 示例:
 *
 * 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
 * 输出: []
 * 提示：
 *
 * 1 <= array1.length, array2.length <= 100000
 *
 */
class Solution {
    public int[] findSwapValues(int[] a, int[] b) {
        int diff = Arrays.stream(a).sum() - Arrays.stream(b).sum();
        if ((diff & 1) != 0) {
            return new int[0];
        }
        final int finalDiff = diff >> 1;
        Set<Integer> bSet = Arrays.stream(b).boxed().collect(Collectors.toSet());
        Integer res = Arrays.stream(a).boxed().filter(i -> bSet.contains(i - finalDiff)).findFirst().orElseGet(()->null);
        return res == null? new int[0] : new int[]{res, res-finalDiff};
    }
}
