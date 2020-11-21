package DynamicProgramming.P907;

class Solution {
    public int sumSubarrayMins(int[] A) {
        long result = 0, sum = 0;
        int stack[] = new int[A.length + 1], length = 0;
        stack[length++] = -1;
        for (int i = 0; i < A.length; i++) {
            while (length > 1 && A[stack[length - 1]] >= A[i]) {
                sum -= A[stack[length - 1]] * (stack[length - 1] - stack[length - 2]);
                length--;
            }
            sum += A[i] * (i - stack[length - 1]);
            result += sum;
            stack[length++] = i;
        }
        return (int)(result % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sumSubarrayMins(new int[]{3,1,2,4}));
    }
}