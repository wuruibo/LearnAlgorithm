package String.P758;

class Solution {
    public String boldWords(String[] words, String S) {
        boolean[] tempS = new boolean[S.length()];

        for (String word : words) {
            int i = S.indexOf(word);
            int size = word.length();
            while (i != -1) {
                for (int j = i; j < i + size; j++) {
                    tempS[j] = true;
                }
                i = S.indexOf(word, i + 1);
            }
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < tempS.length;) {
            if (tempS[i]) {
                sb.append("<b>");
                while (i < tempS.length && tempS[i]) {
                    sb.append(S.charAt(i));
                    i++;
                }
                sb.append("</b>");
            } else {
                sb.append(S.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}