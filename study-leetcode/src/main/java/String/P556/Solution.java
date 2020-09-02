package String.P556;

/**
 *
 * 给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。
 *
 * 示例 1:
 *
 * 输入: 12
 * 输出: 21
 * 示例 2:
 *
 * 输入: 21
 * 输出: -1
 */
class Solution {
    public int nextGreaterElement(int n) {
        //1.将n转换为数字数组  若n=62431 得到1 3 4 2 6数组
        char[] a = ("" + n).toCharArray();
        int i = a.length - 2;
        //2.自左往右遍历数组 如果一直单调递增 1 3 4 前面任何一个数换上来都会导致变小 1 3 4 2用2换下面大于2值里面最小的上来
        while (i >= 0 && a[i + 1] <= a[i]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = a.length - 1;
        while (j >= 0 && a[j] <= a[i]) {
            j--;
        }
        //3.进行交换
        swap(a, i, j);
        reverse(a, i + 1);
        try {
            //4.重建数值
            return Integer.parseInt(new String(a));
        } catch (Exception e) {
            return -1;
        }
    }
    private void reverse(char[] a, int start) {
        int i = start, j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }
    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}