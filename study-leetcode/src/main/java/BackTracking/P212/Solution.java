package BackTracking.P212;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result= new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            //开始
            result.add(words[i]);
        }
        return result;
    }
    public boolean existBackTracking(char[][] board,String target,int index,int i,int j){
        return true;
    }
}