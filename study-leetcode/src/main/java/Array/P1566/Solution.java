package Array.P1566;

class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        if (m*k>arr.length) {
            return false;
        }
        int i, j;
        for(i = 0; i <= arr.length - m * k; ++i) {
            for(j = i + m; j < i + m * k; ++j) {
                if(arr[j] != arr[j - m]) {
                    break;
                }
            }
            if(j == i + m * k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().containsPattern(new int[]{1,2,4,4,4,4},1,3));
        System.out.println(new Solution().containsPattern(new int[]{1,2,1,2,1,1,1,3},2,2));
        System.out.println(new Solution().containsPattern(new int[]{1,2,1,2,1,3},2,3));
        System.out.println(new Solution().containsPattern(new int[]{1,2,3,1,2},2,2));
        System.out.println(new Solution().containsPattern(new int[]{1,2,3,1,2},2,2));
    }
}