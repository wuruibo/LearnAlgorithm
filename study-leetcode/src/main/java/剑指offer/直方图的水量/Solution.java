package 剑指offer.直方图的水量;

/**
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 1.对于每个点都要找到左边的最大值和右边的最大值
 * 2.利用两个数组分别存储左边和右边的最大值
 */
class Solution {
    public int trap(int[] height) {
        //第一遍从左到右
        int n=height.length;
        int[] left= new int[n],right=new int[n];
        for (int i = 0; i < height.length; i++) {
            if (i==0) {
                left[0]=height[0];
            }else if (height[i]>left[i-1]) {
                left[i]=height[i];
            }else {
                left[i]=left[i-1];
            }
        }
        //第二遍从右往左扫描
        for (int r = n-1; r >= 0; r--) {
            if (r==n-1) {
                right[n-1]=height[n-1];
            }else if (height[r]>right[r+1]) {
                right[r]=height[r];
            }else {
                right[r]=right[r+1];
            }
        }
        //一边扫描求和
        int result=0;
        for (int i = 0; i < height.length; i++) {
            int max=Math.min(left[i],right[i]);
            if (max>height[i]) {
                result+=(max-height[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new Solution().trap(new int[]{}));
    }
}