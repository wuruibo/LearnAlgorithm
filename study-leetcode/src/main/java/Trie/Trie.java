package Trie;

class Trie {
    //定义root节点
    TrieNode root;
    public static class TrieNode {
        //每个node下都保存26个字母的数组，可以直接通过索引搜索到
        TrieNode[] trieNodes;
        //记录当前节点是不是end节点
        boolean isEnd;

        private static final int size=26;

        public TrieNode() {
            this.trieNodes = new TrieNode[size];
            this.isEnd = false;
        }

        public TrieNode[] getTrieNodes() {
            return trieNodes;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }
    }
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        //定义当前遍历到的节点位置
        TrieNode temp=root;
        for (int i = 0; i < word.length(); i++) {
            char current=word.charAt(i);
            //定位当前字符的索引
            int index=current-'a';
            //获取当前字符对应索引的节点 如果为空说明当前深度未出现过这个字符，直接生成一个新的节点挂上去 如果不为空直接取出来 继续往深了走
            TrieNode[] trieNodes=temp.getTrieNodes();
            //定义当前深度的匹配节点
            TrieNode next;
            if (trieNodes[index]==null){
                next=new TrieNode();
                trieNodes[index]=next;
            }
            temp=trieNodes[index];
            //如果当前字符已经是最后的字符 需要标记当前节点为end，也就是可以以当前节点为最后结尾
            if (i==word.length()-1) {
                temp.setEnd(true);
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode t=startsWithNode(word);
        return t!=null && t.isEnd ;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
       return startsWithNode(prefix)==null?false:true;
    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public TrieNode startsWithNode(String prefix) {
        //定义当前遍历到的节点位置
        TrieNode temp=root;
        for (int i = 0; i < prefix.length(); i++) {
            int index=prefix.charAt(i)-'a';

            TrieNode[] trieNodes=temp.getTrieNodes();

            if (trieNodes[index]==null) {
                return null;
            }else {
                temp=trieNodes[index];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));    // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));   // returns true
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */