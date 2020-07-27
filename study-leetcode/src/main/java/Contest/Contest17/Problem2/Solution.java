package Contest.Contest17.Problem2;

class Solution {
    public int numOfSubarrays(int[] arr) {
        long[] subSum=new long[arr.length+1];
        int[] hash=new int[2];
        for (int i = 1; i <= arr.length; i++) {
            subSum[i]=subSum[i-1]+arr[i-1];
        }
        long count=0;
        for (int i = 0; i < subSum.length; i++) {
            if ((subSum[i]&1)==0) {
                count+=hash[1];
                hash[0]++;
            }else {
                count+=hash[0];
                hash[1]++;
            }
        }
        return (int) (count%((int)Math.pow(10,9) + 7));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numOfSubarrays(new int[]{64,69,7,78,31,83,47,84,47,6,67}));
        System.out.println(new Solution().numOfSubarrays(new int[]{7}));
        System.out.println(new Solution().numOfSubarrays(new int[]{1,2,3,4,5,6,7}));
        System.out.println(new Solution().numOfSubarrays(new int[]{100,100,99,99}));
    }
}