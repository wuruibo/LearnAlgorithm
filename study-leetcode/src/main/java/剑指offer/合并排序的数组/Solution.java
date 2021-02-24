package 剑指offer.合并排序的数组;

/**
 * 方法二中，之所以要使用临时变量，是因为如果直接合并到数组 AA 中，AA 中的元素可能会在取出之前被覆盖。那么如何直接避免覆盖 AA 中的元素呢？观察可知，AA 的后半部分是空的，可以直接覆盖而不会影响结果。因此可以指针设置为从后向前遍历，每次取两者之中的较大者放进 AA 的最后面。
 *
 * 严格来说，在此遍历过程中的任意一个时刻，AA 数组中有 m-\textit{pa}-1m−pa−1 个元素被放入 AA 的后半部，BB 数组中有 n-\textit{pb}-1n−pb−1 个元素被放入 AA 的后半部，而在指针 \textit{pa}pa 的后面，AA 数组有 m+n-\textit{pa}-1m+n−pa−1 个位置。由于
 */
class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int pa = m - 1, pb = n - 1;
        int tail = m + n - 1;
        int cur;
        while (pa >= 0 || pb >= 0) {
            if (pa == -1) {
                cur = B[pb--];
            } else if (pb == -1) {
                cur = A[pa--];
            } else if (A[pa] > B[pb]) {
                cur = A[pa--];
            } else {
                cur = B[pb--];
            }
            A[tail--] = cur;
        }
    }
}
