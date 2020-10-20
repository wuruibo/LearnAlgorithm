package 剑指offer.最长单词;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * 检测word是否是由set里面的单词组成
     * @param set
     * @param word
     * @return
     */
    private boolean isComposeWord(Set<String> set, String word) {
        if (word.length() == 0) {
            return true;
        }

        for (int i = 0; i < word.length(); i++) {
            if (set.contains(word.substring(0, i + 1)) && isComposeWord(set, word.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }

    public String longestWord(String[] words) {
        // 将单词列表按照长度降序，长度相同按照字典序
        Arrays.sort(words, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return Integer.compare(o2.length(), o1.length());
            }
        });

        // 把数组做成set，提高检测的效率
        Set<String> set = new HashSet<>(Arrays.asList(words));
        // 遍历检测当前单词是不是组合单词，是的话直接返回
        for (String  word :words ) {
            set.remove(word);
            if (isComposeWord(set, word)) {
                return word;
            }
            set.add(word);
        }
        return "";
    }
}