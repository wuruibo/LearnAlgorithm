package 剑指offer.剪绳子;

/**
 * 数论 结论就是尽可能将元素拆分为3除非最后一个剩下1
 *
 * 1.任何大于1的数都可由2和3相加组成（根据奇偶证明）
 * 2.因为2*2=1*4，2*3>1*5, 所以将数字拆成2和3，能得到的积最大
 * 3.因为2*2*2<3*3, 所以3越多积越大 时间复杂度O(n/3)，用幂函数可以达到O(log(n/3)), 因为n不大，所以提升意义不大，我就没用。 空间复杂度常数复杂度O(1)
 */
class Solution {
    public int cuttingRope(int n) {
            if (n<=3) {
                return n-1;
            }
            int div = n/3;
            int rem = n % 3;
            long result = 1;
            for (int i = 0; i < div; i++) {
                result *= i<div-1 ? 3 : (rem == 2 ? 3*rem : (3+rem));
                if (result >= 1000000007) {
                    result = result%1000000007;
                }
            }
            return (int)result;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().cuttingRope(2));
        System.out.println(new Solution().cuttingRope(10));
    }
}