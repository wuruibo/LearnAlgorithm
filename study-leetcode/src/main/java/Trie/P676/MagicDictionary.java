package Trie.P676;

class MagicDictionary {
    private final static int len=26;
    private Node root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root= new Node();
    }
    
    public void buildDict(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            Node cur=root;
            for (int j = 0; j < dictionary[i].length(); j++) {
                int index=dictionary[i].charAt(j)-'a';
                if (cur.childs[index]==null) {
                    cur.childs[index]=new Node();
                }
                cur=cur.childs[index];
            }
            cur.end=true;
        }
    }
    
    public boolean search(String searchWord) {
        return dfs(root,searchWord,0,1);
    }
    private boolean dfs(Node root,String searchWord,int i,int num){
        if (num<0){
            return false;
        }
        if (i==searchWord.length()) {
            return num==0 && root.end;
        }
        int next=searchWord.charAt(i)-'a';
        for (int j = 0; j < len; j++) {
            if (root.childs[j]==null) {
                continue;
            }else if (next==j){
                if (dfs(root.childs[next],searchWord,i+1,num)) {
                    return true;
                }
            }else if (dfs(root.childs[j],searchWord,i+1,num-1)) {
                    return true;

            }
        }
        return false;
    }
    private static class Node{
        private boolean end;
        private Node[] childs;

        public Node() {
            this.end=false;
            childs=new Node[len];
        }
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */