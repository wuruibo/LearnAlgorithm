package BitManipulation.P137;

class Solution {
    public int singleNumber(int[] nums) {
        //计算32位
        int result=0;
        for (int i = 0; i < 32; i++) {
            int mask=1<<i,count=0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j]&mask)!=0) {
                    count++;
                }
            }
            if (count%3!=0) {
                result^=mask;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{2,2,3,2}));
    }
}