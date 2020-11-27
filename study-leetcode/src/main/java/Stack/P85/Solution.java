package Stack.P85;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 输入：matrix = [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1'],['1','0','0','1','0']]
 * 输出：6
 * 解释：最大矩形如上图所示。
 *
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length==0) {
            return 0;
        }
        //定义一个数组存储每一行的高度
        int max=0;
        int[] height=new int[matrix[0].length+1];
        //往下循环遍历 matrix.length种情况
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
               height[j] = matrix[i][j] == '0' ? 0 : height[j]+1;
            }
            //求height数组能够构成的最大的矩阵面积
            max=Math.max(findMaxSquare(height),max);
        }
        return max;
    }
    private int findMaxSquare(int[] height){
        Deque<Integer> deque= new LinkedList<>();
        int max=0;
        for (int i = 0; i < height.length; i++) {
            //维护单调递增栈
            while (!deque.isEmpty() && height[i] < height[deque.peekLast()]) {
                Integer h=height[deque.pollLast()];
                int len=deque.isEmpty()?i:i-deque.peekLast()-1;
                max=Math.max(max,h*len);
            }
            deque.offerLast(i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
        System.out.println(new Solution().maximalRectangle(new char[][]{{'1','1'}}));
        System.out.println(new Solution().maximalRectangle(new char[][]{{'0','1'},{'1','0'}}));
    }
}