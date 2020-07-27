package Contest.Contest17.Problem1;

class Solution {
    public int countOdds(int low, int high) {
        int count=0;
        for (int i = low; i <= high; i++) {
            if ((i&1)==1) {
                count++;
            }
        }
        return count;
    }
}