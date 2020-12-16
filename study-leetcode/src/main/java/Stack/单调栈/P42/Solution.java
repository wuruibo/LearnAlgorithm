package Stack.单调栈.P42;

/**
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
class Solution {
    public int trap(int[] height) {
        //step1 定义双指针 left和right一个从左往右一个从右往左
        int left=0,right=height.length-1;
        //step2 定义双指针前后的最大高度 当height[left]<height[right]时 left最大高度-height[left] 反过来也一样
        int leftMax=0,rightMax=0;
        //step3 定义result
        int result=0;
        while (left<right){
            if (height[left]<height[right]) {
                if (height[left]<leftMax) {
                    result+=(leftMax-height[left]);
                }else {
                    leftMax=height[left];
                }
                left++;
            }else {
                if (height[right]<rightMax) {
                    result+=(rightMax-height[right]);
                }else {
                    rightMax=height[right];
                }
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints={0};
        System.out.println(new Solution().trap(ints));
    }
}