package BackTracking.P996;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array A of non-negative integers, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.
 *
 * Return the number of permutations of A that are squareful.  Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].
 *
 *
 *
 * Example 1:
 *
 * Input: [1,17,8]
 * Output: 2
 * Explanation:
 * [1,8,17] and [17,8,1] are the valid permutations.
 * Example 2:
 *
 * Input: [2,2,2]
 * Output: 1
 *
 *
 * Note:
 *
 * 1 <= A.length <= 12
 * 0 <= A[i] <= 1e9
 */
class Solution {
    private int count=0;
    public int numSquarefulPerms(int[] A) {
        List<Integer> result= new ArrayList<>();
        backTracking(A,result);

        return count;
    }

    /**
     * 用-1标记已经被选择
     * @param A
     */
    private void backTracking(int[] A, List<Integer> target){
        if (target.size()==A.length) count++;
        Set<Integer> set= new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i]>=0 && set.add(A[i]) && (target.size()==0 || canBeSqrt(target.get(target.size()-1),A[i]))) {
                int temp=A[i];
                A[i]=-1;
                target.add(temp);
                backTracking(A,target);
                target.remove(target.size()-1);
                A[i]=temp;
            }
        }
    }
    private boolean canBeSqrt(int last,int current){
        double sqrtResult=Math.sqrt(last+current);
        double left=sqrtResult-(int) sqrtResult;

        return left==0?true:false;
    }

    public static void main(String[] args) {
        int[] test={1,17,8};
        System.out.println(new Solution().numSquarefulPerms(test));

        int[] tes1t={2,2,2};
        System.out.println(new Solution().numSquarefulPerms(tes1t));

        int[] test1={0,0,0,1,1,1};
        System.out.println(new Solution().numSquarefulPerms(test1));
    }
}