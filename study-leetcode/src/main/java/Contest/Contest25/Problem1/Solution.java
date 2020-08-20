package Contest.Contest25.Problem1;

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length-2; i++) {
            int left=arr[i];
            int mid=arr[i+1];
            int right=arr[i+2];
            if ((left&1)==1 && (mid&1)==1 && (right&1)==1) {
                return true;
            }
        }
        return false;
    }
}