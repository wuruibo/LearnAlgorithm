package BFS.P127;

import java.util.*;

/**
 * todo 跟P433相似 手写todo
 */
public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet=new HashSet<>();
        for (String s : wordList) {
            wordSet.add(s);
        }
        return ladderLength(beginWord,endWord,wordSet);
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String str = queue.poll();
                if(str.equals(endWord))return level;
                for(String neighbor : neighbors(str,wordList)){
                    queue.offer(neighbor);
                }
            }
            level++;
        }
        return 0;
    }

    public List<String> neighbors(String s, Set<String> wordList){
        List<String> res = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char [] chars = s.toCharArray();
            for(char ch = 'a'; ch <= 'z'; ch++){
                chars[i] = ch;
                String word = new String(chars);
                if(wordList.remove(word)){
                    res.add(word);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strings={"hot","dot","dog","lot","log","cog"};
        System.out.println(new Solution().ladderLength("hit", "cog", Arrays.asList(strings)));

        String[] strings1={"hot","dot","dog","lot","log"};
        System.out.println(new Solution().ladderLength("hit", "cog", Arrays.asList(strings1)));

    }
}