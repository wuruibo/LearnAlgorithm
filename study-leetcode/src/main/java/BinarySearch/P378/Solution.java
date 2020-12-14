package BinarySearch.P378;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m=matrix.length,n=matrix[0].length;
        int min=matrix[0][0],max=matrix[m-1][n-1];
        while (min<=max) {
            int mid=min+((max-min)>>1);
            //计算小于mid的个数 利用二分查找
            int count=countNumber(mid,matrix);
            if (count>=k) {
                max=mid-1;
            }else {
                min=mid+1;
            }
        }
        return min;
    }

    /**
     * 计算小于当前target的值总和
     * @param target
     * @return
     */
    private int countNumber(int target,int[][] matrix){
        int x=matrix.length-1,y=0,count=0;
        while (x >= 0 && y < matrix[0].length) {
            if (matrix[x][y]>target) {
                x--;
            }else {
                count+=x+1;
                y++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kthSmallest(new int[][]{{1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}}, 8));
    }

}