package TwoPointer.P930;

/**
 * In an array A of 0s and 1s, how many non-empty subarrays have sum S?
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,0,1,0,1], S = 2
 * Output: 4
 * Explanation:
 * The 4 subarrays are bolded below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 *
 *
 * Note:
 *
 * A.length <= 30000
 * 0 <= S <= A.length
 * A[i] is either 0 or 1.
 */
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int first=0,second=0,counter=S;

        int count=0;
        while (second<A.length){
            counter-=A[second++];

            while (counter<0){
                counter+=A[first++];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A={1,0,1,0,1};
        System.out.println(new Solution().numSubarraysWithSum(A, 0));
    }
}