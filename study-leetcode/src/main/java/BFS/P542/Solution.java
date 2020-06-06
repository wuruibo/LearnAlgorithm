package BFS.P542;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 * Example 2:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,1,1]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,2,1]]
 *
 *
 * Note:
 *
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 */
public class Solution {
    public class Pointer{
        private int value;
        private int row;
        private int column;

        public Pointer(int value, int row, int column) {
            this.value = value;
            this.row = row;
            this.column = column;
        }

        public int getValue() {
            return value;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    Queue<Pointer> queue = new LinkedList<>();
                    Pointer pointer=new Pointer(1,i,j);
                    queue.offer(pointer);

                    int level=0;
                    while (!queue.isEmpty()){
                        int size=queue.size();
                        for (int k = 0; k < size; k++) {
                            Pointer current=queue.poll();

                            if (current.value==0) {matrix[i][j]=level;queue.clear();break;}
                            //继续添加节点
                            int left=current.getColumn()-1;
                            int right=current.getColumn()+1;
                            int top=current.getRow()-1;
                            int bottom=current.getRow()+1;
                            if (left>=0) queue.offer(new Pointer(matrix[current.getRow()][left], current.getRow(),left));
                            if (right<n) queue.offer(new Pointer(matrix[current.getRow()][right],current.getRow(),right));
                            if (top>=0) queue.offer(new Pointer(matrix[top][current.getColumn()],top,current.getColumn()));
                            if (bottom<m) queue.offer(new Pointer(matrix[bottom][current.getColumn()],bottom,current.getColumn()));

                        }
                        level++;
                    }

                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] test={{0,0,0},
                {0,1,0},
                {1,1,1}};
        new Solution().updateMatrix(test);

    }
}