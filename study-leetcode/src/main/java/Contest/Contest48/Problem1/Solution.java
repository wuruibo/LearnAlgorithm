package Contest.Contest48.Problem1;

/**
 * 输入：encoded = [1,2,3], first = 1
 * 输出：[1,0,2,1]
 * 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 */
class Solution {
    public int[] decode(int[] encoded, int first) {
        int n=encoded.length+1;
        int[] result=new int[n];
        result[0]=first;
        for (int i = 1; i < n; i++) {
            result[i]=encoded[i-1]^result[i-1];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decode(new int[]{1, 2, 3}, 1));
        System.out.println(new Solution().decode(new int[]{6,2,7,3}, 4));
    }
}