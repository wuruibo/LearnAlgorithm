package P238;

/**
 * Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except 4 is 2*3*5 which consists of two parts: left 2*3 and right 5. The product is left*right. We can get lefts and rights:
 *
 * Numbers:     2    3    4     5
 * Lefts:            2  2*3 2*3*4
 * Rights:  3*4*5  4*5    5
 * Let’s fill the empty with 1:
 *
 * Numbers:     2    3    4     5
 * Lefts:       1    2  2*3 2*3*4
 * Rights:  3*4*5  4*5    5     1
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        //
        int length=nums.length;
        int[] res=new int[length];
        res[0]=1;
        for (int i = 1; i < nums.length; i++) {
            res[i]=res[i-1]*nums[i-1];
        }

        //从右往左扫描
        int temp=1;
        for (int i = length-1; i >= 0; i--) {
            res[i]=res[i]*temp;
            temp=temp*nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints={1,2,3,4};
        new Solution().productExceptSelf(ints);
    }


}