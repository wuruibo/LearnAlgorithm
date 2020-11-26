package Trie.P648;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 */
class Solution {
    private class Node{
        private List<Integer> indexs;
        private Node[] children;

        public Node() {
            indexs= new ArrayList<>();
            children=new Node[26];
        }
    }
    private Node root= new Node();
    public String replaceWords(List<String> dictionary, String sentence) {
        dictionary.sort((a,b)->b.length()-a.length());
        List<String> temp=Arrays.stream(sentence.split(" ")).collect(Collectors.toList());
        buildTrie(temp);
        //遍历替换temp
        for (String s : dictionary) {
            //先找到前缀结尾的位置
            Node cur=root;
            for (char c : s.toCharArray()) {
                cur=cur.children[c-'a'];
                if (cur==null) {
                    break;
                }
            }
            //进行dfs替换
            dfs(temp,cur,s);
        }
        return temp.stream().reduce((a,b)->a+" "+b).get();
    }
    private void dfs(List<String> temp,Node root,String replace){
        if (root==null) {
            return;
        }
        if (root.indexs.size()!=0) {
            for (Integer index : root.indexs) {
                temp.set(index,replace);
            }
        }
        for (Node child : root.children) {
            dfs(temp,child,replace);
        }
    }
    private void buildTrie(List<String> words){
        for (int i = 0; i < words.size(); i++) {
            Node cur=root;
            for (char c : words.get(i).toCharArray()) {
                if (cur.children[c-'a']==null) {
                    cur.children[c-'a']=new Node();
                }
                cur=cur.children[c-'a'];
            }
            //结尾节点特殊处理
            cur.indexs.add(i);
        }
    }

    public static void main(String[] args) {
        List<String> temp=Arrays.stream(new String[]{"a", "aa", "aaa", "aaaa"}).collect(Collectors.toList());
        System.out.println(new Solution().replaceWords(temp,"a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));

        List<String> temp1=Arrays.stream(new String[]{"catt","cat","bat","rat"}).collect(Collectors.toList());
        System.out.println(new Solution().replaceWords(temp1,"the cattle was rattled by the battery"));


        List<String> temp2=Arrays.stream(new String[]{"a", "aa", "aaa", "aaaa"}).collect(Collectors.toList());
        System.out.println(new Solution().replaceWords(temp2,"a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
    }
}