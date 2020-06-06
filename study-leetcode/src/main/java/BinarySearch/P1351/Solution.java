package BinarySearch.P1351;

/**
 * Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise.
 *
 * Return the number of negative numbers in grid.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 * Example 2:
 *
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 * Example 3:
 *
 * Input: grid = [[1,-1],[-1,-1]]
 * Output: 3
 * Example 4:
 *
 * Input: grid = [[-1]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 */
class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            count+=binaryFind(grid[i],0);
        }

        return count;
    }

    private int binaryFind(int[] array,int target){
        int start=0,end=array.length-1;
        while (start<=end) {
            int mid = start + (end - start) / 2;
            if (target<=array[mid]) {
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return array.length-start;
    }

    public static void main(String[] args) {
        int[][] test={{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(new Solution().countNegatives(test));


        int[][] test1={{3,2},{1,0}};
        System.out.println(new Solution().countNegatives(test1));

        int[][] test2={{1,-1},{-1,-1}};
        System.out.println(new Solution().countNegatives(test2));

        int[][] test3={{-1}};
        System.out.println(new Solution().countNegatives(test3));
    }
}