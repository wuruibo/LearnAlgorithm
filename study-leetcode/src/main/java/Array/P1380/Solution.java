package Array.P1380;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] tmp = new int[m];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            tmp[i] = getMinClo(matrix[i]);
        }
        for(int i = 0; i < tmp.length; i++) {
            int col = tmp[i];
            boolean isValid = true;
            for(int j = 0; j < m; j++) {
                if(matrix[j][col] > matrix[i][col]) {
                    isValid = false;
                    break;
                }
            }
            if(isValid) {
                ans.add(matrix[i][col]);
            }
        }
        return ans;
    }

    public int getMinClo(int[] num) {
        int ans = 0;
        int i = 1;
        for(; i < num.length; i++) {
            if(num[i] < num[ans]) {
                ans = i;
            }
        }
        return ans;
    }
}