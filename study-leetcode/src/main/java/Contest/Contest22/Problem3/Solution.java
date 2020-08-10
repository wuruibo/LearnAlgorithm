
package Contest.Contest22.Problem3;

class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if (sizeByTwo(nums[i])==0) {
                count++;
            }
        }
        return count;
    }
    private Integer sizeByTwo(int num){
        int count=0;
        while (num!=0){
            count++;
            num=num/10;
        }
        return count&1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findNumbers(new int[]{555, 901, 482, 1771}));
        System.out.println(new Solution().findNumbers(new int[]{12,345,2,6,7896}));
    }
}