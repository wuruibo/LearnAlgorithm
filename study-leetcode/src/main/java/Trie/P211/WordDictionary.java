package Trie.P211;

import lombok.Getter;
import lombok.Setter;

class WordDictionary {
    //    定义字典树根节点
    private TrieNode root;
    //定义一个队列
    //定义字典节点
    @Getter
    @Setter
    public class TrieNode {
        private TrieNode[] trieNodes;
        private boolean isEnd;

        public TrieNode() {
            this.trieNodes = new TrieNode[26];
            this.isEnd = false;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            //当前字符的index 同时获取数组列表
            int index = word.charAt(i) - 'a';
            TrieNode[] current = temp.getTrieNodes();

            //如果当前节点索引的位置为空 那就生成一个 然后将temp置为当前即节点 直到最后的节点 setEnd为true
            if (current[index] == null) {
                current[index] = new TrieNode();
            }
            temp = current[index];
        }
        temp.setEnd(true);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return backTracking(word,0,root);
    }
    public boolean backTracking(String word,int index,TrieNode temp){
        if (index==word.length()) {
            return temp.isEnd;
        }

        if (word.charAt(index)=='.') {
            //继续backtracking
            for (int i = 0; i < 26; i++) {
                if (temp.getTrieNodes()[i]!=null && backTracking(word,index+1,temp.getTrieNodes()[i])) {
                    //如果子问题返回true 直接返回 返回false继续往后
                    return true;
                }
            }
            return false;
        }else {
            //当前位置超长 当前位置无元素直接返回失败
            return temp.getTrieNodes()[word.charAt(index)-'a']!=null && backTracking(word,index+1,temp.getTrieNodes()[word.charAt(index)-'a']);
        }
    }
    /**
     * 这种搜索方式不行 需要backtracking
     * @param word
     * @return
     */
    @Deprecated
    public TrieNode searchStartWith(String word) {
        //搜索匹配
        TrieNode temp = root;

        for (int i = 0; i < word.length(); i++) {
            //直接拿到当前位置先匹配一下
            TrieNode[] current = temp.getTrieNodes();
            //如果当前字符为.要直接跳过
            if (word.charAt(i) == '.') {
                //当前字符为.并且当前位置的所有节点都为空 表示无路可走
                if (current.length == 0) {
                    return null;
                }//最后一位如果是.进行特殊处理
                else if (i==word.length()-1) {
                    TrieNode virtual=new TrieNode();
                    virtual.setEnd(true);
                    return virtual;
                }else {
                    //其他的位置出现.都直接过滤 但是下一个次遍历到非.的位置时需要拿出当前位置所有节点 先存进队列

                    continue;
                }
            }
            //拿到当前位置索引
            int index = word.charAt(i) - 'a';
            //拿到当前索引位置的节点
            if (current[index] == null) {
                return null;
            }
            temp = current[index];
        }
        return temp;
    }

    public static void main(String[] args) {

        WordDictionary word=new WordDictionary();
        word.addWord("at");
        word.addWord("and");
        word.addWord("an");
        word.addWord("add");
        System.out.println(word.search("a")); //false
        System.out.println(word.search(".at")); //false

        word.addWord("bat");
        System.out.println(word.search(".at")); //true
        System.out.println(word.search("an.")); //true
        System.out.println(word.search("a.d.")); // false
        System.out.println(word.search("b."));// false
        System.out.println(word.search("a.d")); // true
        System.out.println(word.search(".")); // false
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */