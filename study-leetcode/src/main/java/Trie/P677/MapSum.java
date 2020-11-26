package Trie.P677;

/**
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 */
class MapSum {
    private TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        root=new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode cur=root;
        for (char c:key.toCharArray()) {
            if (cur.children[c-'a']==null) {
                cur.children[c-'a']=new TrieNode();
            }
            cur=cur.children[c-'a'];
        }
        //最后一个节点是可以结尾的
        cur.val=val;
    }
    
    public int sum(String prefix) {
        //遍历一下前缀树 先找到prefix的尾节点 然后向下dfs有end的位置就记录下来
        TrieNode cur=root;
        //找prefix的尾节点
        for (char c : prefix.toCharArray()) {
            cur=cur.children[c-'a'];
            if (cur==null) {
                return 0;
            }
        }
        //往下dfs记录
        return dfs(cur);
    }

    /**
     * 先序遍历
     * @param root
     * @return
     */
    private int dfs(TrieNode root){
        if (root==null) {
            return 0;
        }
        int result=root.val;
        for (int i = 0; i < root.children.length; i++) {
            result+=dfs(root.children[i]);
        }
        return result;
    }
    private static class TrieNode{
        public TrieNode() {
            this.val = 0;
            this.children = new TrieNode[26];
        }
        private int val;
        private TrieNode[] children;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */