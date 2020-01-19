package Sort.P75;

/**
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
class Solution {
    public void sortColors(int[] nums) {
        int[] temp=new int[3];

        for (int num : nums) {
            temp[num]++;
        }
        //第一种遍历方式
        /*int index=0;
        for (int i = 0; i < nums.length;) {
            if (temp[index] == 0) {
                index++;
            }else {
                nums[i] = index;
                temp[index]--;
                i++;
            }
        }*/
        //第二种遍历方式
        int index=0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i]; j++) {
                nums[index++]=i;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints={1,2,0,2};
        new Solution().sortColors(ints);
    }
}