package Contest.Contest42.Problem1;

class Solution {
    public int numberOfMatches(int n) {
        int count=0;
        while (n != 1) {
            count+=n/2;
            n=(n+1)/2;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfMatches(7));
        System.out.println(new Solution().numberOfMatches(14));
    }
}