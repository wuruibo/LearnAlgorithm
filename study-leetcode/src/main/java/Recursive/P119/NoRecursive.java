package Recursive.P119;

import java.util.Arrays;
import java.util.List;

/**
 * leetCode 题解 都是高手
 *
 * @autor yeqiaozhu.
 * @date 2019-11-25
 */
public class NoRecursive {
    public List<Integer> getRow(int k) {
        Integer[] arr = new Integer[k + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for (int i = 1; i <= k; i++)
            for (int j = i; j > 0; j--)
                arr[j] = arr[j] + arr[j - 1];

        return Arrays.asList(arr);
    }
    public static void main(String[] args) {
        new NoRecursive().getRow(2);
    }
}
