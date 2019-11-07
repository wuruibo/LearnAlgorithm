package P1079;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    private int count=0;
    private Set<String> set= new HashSet<>();
    public int numTilePossibilities(String tiles) {
        List<Character> tilesList=new LinkedList<>();
        for (int i = 0; i < tiles.length(); i++) {
            tilesList.add(tiles.charAt(i));
        }
        countNumTilePossibilities(tilesList,"");
        return count;
    }
    public void countNumTilePossibilities(List<Character> list,String str){
        if (!set.contains(str) && !(str.length()==0)) {
            count++;
            set.add(str);
        }
        if (list.size()==0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            List<Character> subList=new LinkedList<>();
            //拷贝复制一份
            for (int j = 0; j < list.size(); j++) {
                if (i!=j) {
                    subList.add(list.get(j));
                }
            }
            countNumTilePossibilities(subList,str+list.get(i));
        }
    }

    public static void main(String[] args) {
        new Solution().numTilePossibilities("AAABBC");
    }
}