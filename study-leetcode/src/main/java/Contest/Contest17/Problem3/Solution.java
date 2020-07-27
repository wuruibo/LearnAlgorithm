package Contest.Contest17.Problem3;

class Solution {
    public int numSplits(String s) {
        int[] leftHash=new int[26];
        int[] rightHash=new int[26];
        //step1 rightHash填充
        for (int j = 0; j < s.length(); j++) {
            rightHash[s.charAt(j)-'a']++;
        }
        int count=0;
        for (int i = 0; i < s.length()-1; i++) {
            leftHash[s.charAt(i)-'a']++;
            rightHash[s.charAt(i)-'a']--;
            int leftCount=0,rightCount=0;
            for (int r = 0; r < 26; r++) {
                if (leftHash[r]>0) {
                    leftCount++;
                }
                if (rightHash[r]>0) {
                    rightCount++;
                }
            }
            if (leftCount==rightCount) {
                count++;
            }
        }
        return count;
    }
}