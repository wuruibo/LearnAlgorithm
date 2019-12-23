package Array.P73;

import java.util.Arrays;

/**
 *
 *
 * @Description
 * Example 1:
 *
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 *
 * [                         [                            [                          [                       [
 *   [1,1,1],     step 1        [1,0,1],      step 2        [1,0,1],    step 3         [1,0,1],   step 4       [1,0,1],
 *   [1,0,1],    --------->     [0,0,1],   --------->       [0,0,1], ---------->       [0,0,0], ---------->    [0,0,0],
 *   [1,1,1]  （第一行第一列忽略） [1,1,1]   （处理第一行）      [1,0,1]   （处理第一列）     [1,0,1]                 [1,0,1]
 * ]                         ]                           ]                          ]                        ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * Example 2:
 *
 * Input:
 * [                         [                         [                         [                            [
 *   [0,1,2,0],                [0,1,2,0],                [0,1,2,0],                [0,1,2,0],                   [0,0,0,0],
 *   [3,4,5,2], -------->      [3,4,5,2], ---------->    [3,4,5,0],  --------->    [3,4,5,0],  --------->       [0,4,5,0],
 *   [1,3,1,5]                 [1,3,1,5]                 [1,3,1,0]                 [1,3,1,0]                    [0,3,1,0]
 * ]                         ]                         ]                         ]                            ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRow=false,firstColumn=false;
        //step1 遍历一遍设置set第一行值
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i==0 || j==0) {
                    if (i==0)firstRow=(matrix[i][j]==0 || firstRow)?true:false;
                    if (j==0)firstColumn=(matrix[i][j]==0 || firstColumn)?true:false;
                } else if (matrix[i][j]==0) {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        //step2 遍历第一行 将值为0的对应列置为0

        int[] row=matrix[0];
        for (int i = 1; i < row.length; i++) {
            if (matrix[0][i]==0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i]=0;
                }
            }
        }
        //step3 遍历第一列 将值为0的对应的行全部置0
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0]==0) {
                for (int j = 1; j < matrix[i].length; j++) {
                    matrix[i][j]=0;
                }
            }
        }
        //step4 将第一行和第一列根据之前记录的flag置为0
        if (firstRow) {
            //第一行置为0
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i]=0;
            }
        }
        if (firstColumn) {
            //第一列置为0
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][0]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] test={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] ints={  {1,1,1},{0,1,2}};
        new Solution().setZeroes(test);
        Arrays.stream(test).forEach(ints1 -> {Arrays.stream(ints1).forEach(ints2-> System.out.print(ints2+" "));
            System.out.println();});
/*        new Solution().setZeroes(test);
        Arrays.stream(test).forEach(ints1 -> {Arrays.stream(ints1).forEach(ints2-> System.out.print(ints2+" "));
            System.out.println();});*/
    }
}