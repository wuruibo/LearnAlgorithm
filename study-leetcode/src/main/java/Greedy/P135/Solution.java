package Greedy.P135;

import java.util.Arrays;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1:
 *
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 *
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    /**
     * 逻辑有问题
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        //先找到份数最小的孩子发一颗糖 然后分别往左往右发糖
        int[] min={Integer.MAX_VALUE,-1};
        for (int i = 0; i < ratings.length; i++) {
            if (ratings[i]<min[0]) {
                min[0]=ratings[i];
                min[1]=i;
            }
        }
        //找到最小值之后分别往前往后发糖
        int sum=1,right=1,left=1;
        //往右发糖
        for (int i = min[1]+1; i < ratings.length; i++) {
            if (ratings[i]>ratings[i-1]) {
                right+=1;
            }else if(right>1){
                right-=1;
            }
            sum+=right;
        }
        //往左发糖
        for (int i = min[1]-1; i >= 0; i--) {
            if (ratings[i]>ratings[i+1]) {
                left+=1;
            }else if(left>1){
                left-=1;
            }
            sum+=left;
        }

        return sum;
    }

    /**
     * 正确逻辑 左右各扫一遍
     * @param ratings
     * @return
     */
    public int candy1(int[] ratings) {
        int[] nums=new int[ratings.length];
        Arrays.fill(nums,1);

        //先从左往右发糖 如果右边的小于左边的话 左边的多发一颗糖
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i]>ratings[i-1]) {
                nums[i]=nums[i-1]+1;
            }
        }
        //再从右往左发糖 如果左边的小于右边的话 右边的多发一颗糖
        for(int i = ratings.length -2 ; i >= 0; i--){
            if(ratings[i] > ratings[i+1] && nums[i] <= nums[i+1]){
                nums[i] = nums[i+1] +1;
            }
        }
        int result=0;
        for (int i : nums) {
            result+=i;
        }

        return result;
    }

    /**
     * 逻辑有问题
     * @param ratings
     * @return
     */
    public int candy2(int[] ratings) {
        int[] nums=new int[ratings.length];
        Arrays.fill(nums,1);
        //直接一遍遍历 如果是左右两边有任何一个小于它的节点 当前的节点都要多发一颗糖
        for (int i = 0; i < ratings.length; i++) {
            existSmaller(i-1,i+1,i,ratings,nums);
        }
        int count=0;
        for (int num : nums) {
            count+=num;
        }
        return count;
    }
    private void existSmaller(int left,int right,int mid,int[] ratings,int[] nums){
        int countLeft=0,countRight=0;
        if (left>=0 && ratings[mid]>ratings[left]){
            countLeft=nums[left];
        }
        if(right<ratings.length && ratings[mid]>ratings[right]){
            countRight=nums[right];
        }
        nums[mid]=Math.max(countLeft,countRight)+1;
    }
    public static void main(String[] args) {
        int[] test={1,2,87,87,87,2,1};
        System.out.println(new Solution().candy1(test));
        int[] test1={1,0,2};
        System.out.println(new Solution().candy1(test1));

        System.out.println(new Solution().candy2(test));
        System.out.println(new Solution().candy2(test1));
    }
}