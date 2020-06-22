package Contest.Contest6.Problem1;

class Solution {
    public int xorOperation(int n, int start) {
        int result=0,first=start;
        for (int i = 0; i < n; i++) {
            start=(first+(i<<1));
            result^=start;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().xorOperation(5, 0));
        System.out.println(new Solution().xorOperation(4, 3));
        System.out.println(new Solution().xorOperation(1, 7));
        System.out.println(new Solution().xorOperation(10, 5));
    }
}