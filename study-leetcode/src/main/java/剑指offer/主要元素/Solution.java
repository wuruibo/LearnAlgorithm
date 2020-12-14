package 剑指offer.主要元素;

class Solution {
    public int majorityElement(int[] nums) {
        int majority=nums[0],count=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==majority) {
                count++;
            }else {
                count--;
            }
            if (count<0){
                majority=nums[i];
                count=1;
            }
        }
        //验证当前的majority是否存在大多数
        count=0;
        for (int i = 0; i < nums.length; i++) {
            count+=nums[i]==majority?1:0;
        }
        return count>nums.length/2?majority:-1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5}));
        System.out.println(new Solution().majorityElement(new int[]{1, 2, 3}));
    }
}