package Array.P243;

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int pos1 = -1, pos2 = -1, res = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                pos1 = i;
                if (pos2 >= 0) {
                    res = Math.min(res, i - pos2);
                }
            } else if (words[i].equals(word2)) {
                pos2 = i;
                if (pos1 >= 0) {
                    res = Math.min(res, i - pos1);
                }
            }
        }
        return res;
    }
}