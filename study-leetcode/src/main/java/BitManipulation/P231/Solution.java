package BitManipulation.P231;

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;

        int result=0;

        for (int i = 0; i < 32; i++) {
            if ((n & 1)==1) {
                result++;
            }
            n=n>>1;
        }
        return result==1?true:false;
    }
}