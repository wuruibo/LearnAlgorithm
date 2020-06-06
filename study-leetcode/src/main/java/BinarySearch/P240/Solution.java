package BinarySearch.P240;

import CommonUtils.ArrayUtils;

/**
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0 || matrix[0].length==0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            int start=matrix[i][0],end=matrix[i][matrix[i].length-1];
            if (target>=start && target<=end) {
                int index=ArrayUtils.binaryFind(matrix[i],target);
                if (matrix[i][index-1]==target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] ints={
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(new Solution().searchMatrix(ints,5));
        System.out.println(new Solution().searchMatrix(ints,20));
    }
}