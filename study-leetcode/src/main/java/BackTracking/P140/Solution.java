package BackTracking.P140;


import java.util.*;

class Solution {
    /**
     * 记忆化递归map
     */
    private Map<Integer,List<String>> temp= new HashMap<>(32);
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s,0,wordDict);
    }
    private List<String> dfs(String s,int i,List<String> wordDict){
        List<String> result= new ArrayList<>();
        for (int j = i; j < s.length(); j++) {
            String current=s.substring(i,j+1);
            if (wordDict.contains(current)) {
                List<String> next;
                if (temp.containsKey(j+1)) {
                    next=temp.get(j+1);
                }else {
                    next=dfs(s, j + 1, wordDict);
                    temp.put(j+1,next);
                }
                if (next.size()!=0) {
                    next.stream().forEach(string -> result.add(current+" "+string));
                }else if (j==s.length()-1){
                    result.add(current);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("catsanddog", Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"})));
        System.out.println(new Solution().wordBreak("pineapplepenapple", Arrays.asList(new String[]{"apple", "pen", "applepen", "pine", "pineapple"})));
        System.out.println(new Solution().wordBreak("catsandog", Arrays.asList(new String[]{"cats","dog","sand","and","cat"})));
    }
}