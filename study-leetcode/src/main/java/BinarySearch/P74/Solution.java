package BinarySearch.P74;

import CommonUtils.ArrayUtils;

/**
 * 用两次二分搜索
 *
 * 1.第一次二分搜索按列
 * 2.第二次二分搜索按行
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0 || matrix[0].length==0) {
            return false;
        }
        //step1 先判断出在哪咧
        int[] temp = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            temp[i] = matrix[i][0];
        }
        //step2 判断哪咧
        int row = ArrayUtils.binaryFind(temp, target);
        //step3 判断行中哪个元素 这里如果插入位置在0的位置 说明元素比最小的还要小 直接放弃遍历
        if (row==0) {return false;}
        int point = ArrayUtils.binaryFind(matrix[row-1], target);

        return matrix[row-1][point-1] == target;
    }



    public static void main(String[] args) {
/*        int[][] ints = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
        System.out.println(new Solution().searchMatrix(ints, 0));
        System.out.println(new Solution().searchMatrix(ints, 3));
        System.out.println(new Solution().searchMatrix(ints, 24));
        System.out.println(new Solution().searchMatrix(ints, 30));*/

        int[][] ints1 = {{}};
        System.out.println(new Solution().searchMatrix(ints1, 1));
    }
}