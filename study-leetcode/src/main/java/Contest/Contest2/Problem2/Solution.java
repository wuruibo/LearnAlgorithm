package Contest.Contest2.Problem2;


import java.util.Arrays;

/**
 *
 */
class Solution {
    class Word{
        int index;
        String word;
        Word(int index,String word){
            this.index=index;
            this.word=word;
        }
    }
    public String arrangeWords(String text) {
        if (text==null|| text.length()==0) return "";

        String[] words= text.split(" ");
        Word[] objectWords=new Word[words.length];
        for (int i = 0; i < words.length; i++) {
            objectWords[i]=new Word(i,words[i]);
        }
        Arrays.sort(objectWords, (s,s1)->s.word.length()==s1.word.length()?s.index-s1.index:s.word.length()-s1.word.length());

        StringBuilder stringBuilder=new StringBuilder();
        for (Word word : objectWords) {
            stringBuilder.append(word.word.toLowerCase()).append(" ");
        }
        stringBuilder.setCharAt(0,stringBuilder.substring(0,1).toUpperCase().charAt(0));
        return stringBuilder.substring(0,stringBuilder.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().arrangeWords("Leetcode is cool"));
        System.out.println(new Solution().arrangeWords("Keep calm and code on"));
        System.out.println(new Solution().arrangeWords("To be or not to be"));

    }
}