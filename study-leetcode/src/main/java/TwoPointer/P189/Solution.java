package TwoPointer.P189;

/**
 * using copy
 */
class Solution {
    public void rotate(int[] nums, int k) {
        if (k< 0 || nums==null) {
            return;
        }
        if (k>nums.length) {
            k=k%nums.length;
        }
        int[] copy=new int[nums.length];

        //从指定位置先添加后半部分
        for (int i = 0; i < k; i++) {
            copy[i]=nums[nums.length-k+i];
        }
        //开始加前面的元素
        for (int j = k; j < nums.length; j++) {
            copy[j]=nums[j-k];
        }
        //复制回去
        for (int t = 0; t < nums.length; t++) {
            nums[t]=copy[t];
        }
    }

    public static void main(String[] args) {
        int[] ints={1,2,3,4,5,6,7,8};
        int[] ints1={1,2};
        new Solution().rotate(ints,3);
        new Solution().rotate(ints,0);
        new Solution().rotate(ints1,3);
    }
}