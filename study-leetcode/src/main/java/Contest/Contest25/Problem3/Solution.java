package Contest.Contest25.Problem3;

class Solution {
    public int minOperations(int n) {
        int average=(n<<1)>>1,result=0;
        for (int i = 1; i <=(n>>1); i++) {
            int current=2*i-1;
            if (current<average){
                result+=average-current;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(3));
        System.out.println(new Solution().minOperations(6));
    }
}