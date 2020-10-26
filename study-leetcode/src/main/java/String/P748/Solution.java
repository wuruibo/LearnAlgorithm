package String.P748;

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] licenseCount = getWordCount(licensePlate);
        String result = null;
        for (String word : words) {
            if (result != null && word.length() >= result.length()) {
                continue;
            }
            int[] count = getWordCount(word);
            if (isMatch(licenseCount, count)) {
                result = word;
            }
        }
        return result;
    }

    private boolean isMatch(int[] license, int[] word) {
        for (int i = 0; i < license.length; i++) {
            if (word[i] < license[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getWordCount(String word) {
        word = word.toLowerCase();
        int[] count = new int['z' - 'a' + 1];
        for (int i = 0; i < word.length(); i++) {
            char cha = word.charAt(i);
            if (cha >= 'a' && cha <= 'z') {
                count[cha - 'a']++;
            }
        }
        return count;
    }
}