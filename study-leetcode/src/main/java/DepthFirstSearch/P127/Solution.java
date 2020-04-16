package DepthFirstSearch.P127;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
class Solution {
    private Integer min=Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set= new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }
        if (!set.contains(endWord)) return 0;
        return dfs(beginWord,endWord,new int[wordList.size()],wordList);
    }
    public int dfs(String beginWord,String endWord,int[] visited,List<String> wordList){
        if (beginWord.equals(endWord)){
            int count=0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]==1) {
                    count++;
                }
            }
            return count+1;
        }
        boolean flag=false;
        for (int i = 0; i < wordList.size(); i++) {
            String current=wordList.get(i);
            if (diffOne(current,beginWord) && visited[i]!=1) {
                flag=true;
                visited[i]=1;
                int result=dfs(current,endWord,visited,wordList);
                if (result>0) min=Math.min(result,min);
                visited[i]=0;
            }
        }
        return flag?min:0;
    }
    private boolean diffOne(String left,String right){
        int count=0;
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i)!=right.charAt(i)) {
                count++;
            }
        }
        return count==1?true:false;
    }

    public static void main(String[] args) {
        String[] strings={"hot","dot","dog","lot","log","cog"};
        System.out.println(new Solution().ladderLength("hit", "cog", Arrays.asList(strings)));

        String[] strings1={"hot","dot","dog","lot","log"};
        System.out.println(new Solution().ladderLength("hit", "cog", Arrays.asList(strings1)));

        String[] strings2={"a","b","c"};
        System.out.println(new Solution().ladderLength("a", "c", Arrays.asList(strings2)));
    }
}