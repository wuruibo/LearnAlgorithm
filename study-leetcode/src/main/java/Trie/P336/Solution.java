package Trie.P336;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    private Node root=new Node();
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = words.length;
        //1.构造字典树
        for (int i = 0; i < n; i++) {
            build(words[i],i);
        }
        //2.对每一个点的单词进行搜索缺失的回文串
        for (int i = 0; i < n; i++) {
            String reversed=new StringBuilder(words[i]).reverse().toString();
            String[] targets=new String[]{reversed,reversed.substring(1)};
            int next;
            for (String target : targets) {
                if ((next=check(target))>=0) {
                    ans.add(Arrays.stream(new int[]{i, next}).boxed().collect(Collectors.toList()));
                }
            }
        }
        return ans;
    }

    /**
     * 构建字典树
     * @param input
     */
    private void build(String input,int pos){
        Node cur=root;
        for (int i = 0; i < input.length(); i++) {
            int index=input.charAt(i)-'a';
            if (cur.childrens[index]==null) {
                cur.childrens[index]=new Node();
            }
            cur=cur.childrens[index];
        }
        cur.index=pos;
    }
    /**
     * 字典树判断 是否存在
     * @param s
     * @return
     */
    private int check(String s) {
        Node cur=root;
        for (int i = 0; i < s.length(); i++) {
            int index=s.charAt(i)-'a';
            if (cur.childrens[index]==null) {
                return -1;
            }else {
                cur=cur.childrens[index];
            }
        }
        return cur.index;
    }
    private static  class Node{
        private int index;
        private Node[] childrens;

        public Node() {
            this.index=-1;
            childrens=new Node[26];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"}));
        System.out.println(new Solution().palindromePairs(new String[]{"bat","tab","cat"}));
    }
}