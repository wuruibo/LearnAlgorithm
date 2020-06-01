package Array.前缀和.P930;

public class Solution {
    public int numSubarrayWithSum(int[] A,int S){
        int[] hash=new int[A.length+1];
        hash[0]=1;
        int count=0;
        for (int i = 0,sum=0; i < A.length; i++) {
            sum+=A[i];
            int index=sum-S;
            if (index>=0 && index<=A.length) {
                count+=hash[index];
            }
            hash[sum]++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A={1,0,1,0,1};
        System.out.println(new Solution().numSubarrayWithSum(A, 3));
    }
}
